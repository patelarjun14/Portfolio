# Import the following for API
# We are using the following:
# 1. Yahoo Finance
# 2. Frederal Reserve
# 3. Alpha Vantage
import requests
from alpha_vantage.timeseries import TimeSeries
import yfinance as yf
import fredapi as fa

# Import the following for data structures
import pandas as pd
from datetime import timedelta
import pandas_ta as ta

# We are going to use time to slow down 
# request calls
import time

# Here are the API Keys
alpha_vantage_key = '9NLUTD6I2QZTR2BZ'
fred = fa.Fred('c0fec4be089bf8ebac233c2103bffee5')

#########################################################################################################################
# We are going to use Yahoo Finance's database to pull stock price information
# This will help us reduce pull requests for Alpha Vantage

# Bring up the ticker SPY
SPY = yf.Ticker("SPY")

# Get the entire dataset for SPY
# Export date to align with earnings data in alpha vantage
start_date = "1996-03-31"
end_date = "2023-06-30"
SPY_history = SPY.history(start=start_date, end=end_date)

# Here we want to see the close price. This is what our program
# will use for the price to analyze the data 
# The reason why we want close price instead of open is because 
# we want to see if the day will be up or down at the end of the day.
# When the market opens, the value from the close can change
SPY_yf_data = SPY_history[["Close"]]

# Lets rename the column close to Actual_Close
# This way we know this is the real close
SPY_yf_data = SPY_yf_data.rename(columns = {'Close': 'Actual_Close'})

# Here we want to compare previous day and next day to see if the price went up
# If it went up, write 1
# If it went down, write 0
# Here we want to create a target. The target tells us whether the day was up or down.
# We are rolling the data by 2 so that way we compare to close price from a previous day
# and the next day
SPY_yf_data["Target"] = SPY_history.rolling(2).apply(lambda x: x.iloc[1]>x.iloc[0])["Close"]


# NOTE: This is important. Here we want to shift the data by 1 day. This is because when we are 
# analyzing stock prices we have to take past data and not the current data so we need to shift 
# the data by one so that our program knows we are taking past data to predict the future. 
SPY_copy = SPY_history.copy()
SPY_shifted = SPY_copy.shift(1)

# Here we are creating our data and variables we are analyzing
# we will use to train our model
# We will also use the shifted data to make sure we are using past data
# We also want to exclude the first index as its N/A in the target
variables = ["Close","High","Low","Open","Volume"]
SPY_yf_data = SPY_yf_data.join(SPY_shifted[variables]).iloc[1:]

# Lets calculate RSI, MACD, and SMA
rsi = ta.rsi(SPY_yf_data["Close"], timeperiod=14)
macd = ta.macd(SPY_yf_data["Close"], fastperiod=12, slowperiod=26, signalperiod=9)
sma = ta.sma(SPY_yf_data["Close"], timeperiod=20)

# Add RSI, MACD, and SMA and fill any NA with forward fill
SPY_yf_data["RSI"] = rsi.fillna(method='ffill')
SPY_yf_data["MACD_Fast"] = macd["MACD_12_26_9"].fillna(method='ffill')
SPY_yf_data["MACD_Signal"] = macd["MACDs_12_26_9"].fillna(method='ffill')
SPY_yf_data["SMA"] = sma.fillna(method='ffill')


# Lets pull WEI reports
FRED_WEI = fred.get_series("WEI")

# Here we want to cleanup the WEI data. Each report comes out
# on saturday, which means if we want to join it with the stock
# data for SPY from yfinance we need to shift it to monday when the market opens
# NOTE: This is important. There will be some trading days that are not on monday,
# which means that some reports will be excluded
for key in FRED_WEI.keys():
    FRED_WEI[key + timedelta(days=2)] = FRED_WEI[key]
    del FRED_WEI[key]

# Lets get the following from FRED
FRED_VIX = fred.get_series("VIXCLS")
FRED_FFR = fred.get_series("FEDFUNDS")
FRED_UNE = fred.get_series("UNRATE")
FRED_CPI = fred.get_series("STICKCPIM157SFRBATL")
FRED_TRE = fred.get_series("DGS10")
FRED_REC = fred.get_series("RECPROUSM156N")

# We will need to create a name for these dataframes
FRED_WEI.name = "WEI"
FRED_VIX.name = "VIX"
FRED_FFR.name = "FFR"
FRED_UNE.name = "UNEMPLOYMENT"
FRED_CPI.name = "CPI"
FRED_TRE.name = "Treasury 10-Year"
FRED_REC.name = "Recession Prob"


# Lets make the indexs for all data sources the same so that 
# we can join on index
FRED_WEI.index = FRED_WEI.index.strftime('%m/%d/%Y')
FRED_VIX.index = FRED_VIX.index.strftime('%m/%d/%Y')
FRED_FFR.index = FRED_FFR.index.strftime('%m/%d/%Y')
FRED_UNE.index = FRED_UNE.index.strftime('%m/%d/%Y')
FRED_CPI.index = FRED_CPI.index.strftime('%m/%d/%Y')
FRED_TRE.index = FRED_TRE.index.strftime('%m/%d/%Y')
FRED_REC.index = FRED_REC.index.strftime('%m/%d/%Y')
SPY_yf_data.index = SPY_yf_data.index.strftime('%m/%d/%Y')

# We can now join all the data
SPY_yf_data = SPY_yf_data.join(FRED_WEI)
SPY_yf_data = SPY_yf_data.join(FRED_VIX)
SPY_yf_data = SPY_yf_data.join(FRED_FFR)
SPY_yf_data = SPY_yf_data.join(FRED_UNE)
SPY_yf_data = SPY_yf_data.join(FRED_CPI)
SPY_yf_data = SPY_yf_data.join(FRED_TRE)
SPY_yf_data = SPY_yf_data.join(FRED_REC)

# For the current data, if there is any NA
# go ahead and forward fill. This should help with
# interest rates and WIE
SPY_yf_data = SPY_yf_data.fillna(method='ffill')

# Ensure that the data is completely filled
SPY_yf_data = SPY_yf_data.fillna(0)


# Comodities data
crude_oil_data = yf.download('CL=F', start=start_date, end=end_date)
natural_gas_data = yf.download('NG=F', start=start_date, end=end_date)
gold_data = yf.download('GC=F', start=start_date, end=end_date)
silver_data = yf.download('SI=F', start=start_date, end=end_date)
copper_data = yf.download('HG=F', start=start_date, end=end_date)
wheat_data = yf.download('ZW=F', start=start_date, end=end_date)
corn_data = yf.download('ZC=F', start=start_date, end=end_date)
cotton_data = yf.download('CT=F', start=start_date, end=end_date)
coffee_data = yf.download('KC=F', start=start_date, end=end_date)
sugar_data = yf.download('SB=F', start=start_date, end=end_date)

# Lets add the close price data
SPY_yf_data['Crude_Oil_WTI'] = crude_oil_data['Close']
SPY_yf_data['Gold'] = gold_data['Close']
SPY_yf_data['Silver'] = silver_data['Close']
SPY_yf_data['Copper'] = copper_data['Close']
SPY_yf_data['Wheat'] = wheat_data['Close']
SPY_yf_data['Natural_Gas'] = natural_gas_data['Close']
SPY_yf_data['Corn'] = corn_data['Close']
SPY_yf_data['Cotton'] = cotton_data['Close']
SPY_yf_data['Coffee'] = coffee_data['Close']
SPY_yf_data['Sugar'] = sugar_data['Close']

# Ensure all data is filled
SPY_yf_data = SPY_yf_data.fillna(0)

# Lets get weekly, quartly, and annual means
weekly_mean = SPY_yf_data.rolling(7).mean()
quarterly_mean = SPY_yf_data.rolling(90).mean()
annual_mean = SPY_yf_data.rolling(365).mean()

# Lets look at the weekly trend based on target
weekly_trend = SPY_yf_data.shift(1).rolling(7).mean()["Target"]

# Lets create ratios for weekly, quartly, and annual means compared to 
# the closing price
SPY_yf_data["Weekly Mean"] = weekly_mean["Close"] / SPY_yf_data["Close"]
SPY_yf_data["Quarterly Mean"] = quarterly_mean["Close"] / SPY_yf_data["Close"]
SPY_yf_data["Annual Mean"] = annual_mean["Close"] / SPY_yf_data["Close"]

# Lets create annual ratios between annual and weekly/quarterly 
SPY_yf_data["Annual Weekly Mean"] = SPY_yf_data["Annual Mean"] / SPY_yf_data["Weekly Mean"]
SPY_yf_data["Annual Quarterly Mean"] = SPY_yf_data["Annual Mean"] / SPY_yf_data["Quarterly Mean"]
SPY_yf_data["Weekly Trend"] = weekly_trend

# Lets get range of day and volatility of day
SPY_yf_data["Daily Range"] = SPY_yf_data["Close"] - SPY_yf_data["Open"]
SPY_yf_data["Daily Volatility"] = SPY_yf_data["High"] - SPY_yf_data["Low"]



#########################################################################################################################
# This is where we are going to use Alpha Vantage's api 

# Here we want to store SP500 tickers in csv
# Then convert this into a list
file_ticker_list = "ticker list.xlsx"
ticker_list = pd.read_excel(file_ticker_list)
tickers_list = ticker_list['Ticker'].tolist()

# Store daily earnings data into a dictionary
# We also want to count any missing companies
daily_earnings_data = {}
count = 0

# We have to request an API call, currently
# we have 500 per minute (unlimited per day)
# sleep two seconds each iteration
for ticker in tickers_list:
    
    # IMPORTANT: We need to pause every 2 seconds when 
    # making a request so that we can get all 500 companies
    # per minute
    time.sleep(2)
    url_earnings = f'https://www.alphavantage.co/query?function=EARNINGS&symbol={ticker}&apikey={alpha_vantage_key}'
    request = requests.get(url_earnings)
    request_data = request.json()

    # If the company has quarterly Earnings, add it to
    # earnings_data
    if 'quarterlyEarnings' in request_data:
        print(f"Getting EPS for {ticker}")
        eps_data = request_data['quarterlyEarnings']
    
    # If not, then count the number of companies that didnt 
    # have a quartlerly earnings data
    else:
        count += 1
        print(f"No earnings data available for {ticker}. Missing = {count}")
        continue

    # Convert the earnings data into a DataFrame type
    df_earnings_data = pd.DataFrame(eps_data)

    # We want convert the fiscalDateEnding to DateTime format 
    df_earnings_data['fiscalDateEnding'] = pd.to_datetime(df_earnings_data['fiscalDateEnding'])

    # We want to set the indext at fiscalDateEnding
    df_earnings_data.set_index('fiscalDateEnding', inplace=True)

    # Here we are adding a ticker column
    df_earnings_data['Ticker'] = ticker

    # We want to take our data and convert both reported and estimated 
    # to numeric values
    df_earnings_data['reportedEPS'] = pd.to_numeric(df_earnings_data['reportedEPS'].str.replace(',', ''), errors='coerce')
    df_earnings_data['estimatedEPS'] = pd.to_numeric(df_earnings_data['estimatedEPS'].str.replace(',', ''), errors='coerce')

    # Now we want to make the data daily and forward fill the missing values
    # to align with our stock price data
    df_earnings_data = df_earnings_data.resample('D').ffill()

    # Now we want to store our earnings data for specified ticket in
    # daily_earnings_data
    daily_earnings_data[ticker] = df_earnings_data

# After collecting everything, we want to combined our data into a DataFrame
df_combined_earnings = pd.concat(list(daily_earnings_data.values()))

# Here we want to create a pivot table so that we are tracking the mean EPS on a daily basis
# for each individual ticker. This will create a pivot table 
# Also lets separate both reported and estimated EPS into two different pivot tables
df_pivot_reported_earnings = df_combined_earnings.pivot_table(index=df_combined_earnings.index,
                                                                columns=df_combined_earnings['Ticker'],
                                                                values='reportedEPS',
                                                                aggfunc='mean')
df_pivot_estimated_earnings = df_combined_earnings.pivot_table(index=df_combined_earnings.index,
                                                                columns=df_combined_earnings['Ticker'],
                                                                values='estimatedEPS',
                                                                aggfunc='mean')

# Now we want to calculate the mean of all companies in one column 
# both for reported and estimated EPS 
df_pivot_reported_earnings['Mean Reported EPS'] = df_pivot_reported_earnings.mean(axis=1)
df_pivot_estimated_earnings['Mean Estimated EPS'] = df_pivot_estimated_earnings.mean(axis=1)

# Store data into the following Dataframes
df_pivot_reported_earnings = df_pivot_reported_earnings[['Mean Reported EPS']]
df_pivot_estimated_earnings = df_pivot_estimated_earnings[['Mean Estimated EPS']]

#################################################################################
# Let get income data

# Load tickers from Excel file
file_ticker_list = "ticker list.xlsx"
ticker_list = pd.read_excel(file_ticker_list)
tickers_list = ticker_list['Ticker'].tolist()

# Store earnings data in a dictionary
# We also want to count any missing companies
eps_data = {}
count = 0

# Go through the tickers and fetch income statement data
# pause for 2 seconds each iteration
for ticker in tickers_list:
    time.sleep(2)  
    url_earnings = f'https://www.alphavantage.co/query?function=INCOME_STATEMENT&symbol={ticker}&apikey={alpha_vantage_key}'
    response = requests.get(url_earnings)
    data = response.json()

    # Check if the data contains quarterlyReports
    if 'quarterlyReports' in data:
        income_data = pd.DataFrame(data['quarterlyReports'])
        if not income_data.empty and income_data['reportedCurrency'].values[0] == 'USD':
            print(f"Getting Income Statement for {ticker}")
            income_data = data['quarterlyReports']
        else:
            count += 1
            print(f"Company {ticker} does not report in USD. Missing = {count}")
    else:
        count += 1
        print(f"No income data available for {ticker}. Missing = {count}")

    # Convert the data into a DataFrame
    # Drop reportCurrency (All companies report in USD)
    # set datetime for fiscalDateEnding
    # place indext at fiscalDateEnding
    df_income_data = pd.DataFrame(income_data)
    df_income_data = df_income_data.drop(columns=['reportedCurrency'])
    df_income_data['fiscalDateEnding'] = pd.to_datetime(df_income_data['fiscalDateEnding'])
    df_income_data.set_index('fiscalDateEnding', inplace=True)

    # Get everything in the income statement
    numeric_cols = ['grossProfit', 'totalRevenue', 'costOfRevenue', 'costofGoodsAndServicesSold', 
                    'operatingIncome', 'sellingGeneralAndAdministrative', 'researchAndDevelopment',
                    'operatingExpenses', 'netInterestIncome', 'interestIncome', 'interestExpense',
                    'nonInterestIncome', 'otherNonOperatingIncome', 'depreciation', 'depreciationAndAmortization',
                    'incomeBeforeTax', 'incomeTaxExpense', 'interestAndDebtExpense', 'netIncomeFromContinuingOperations',
                    'comprehensiveIncomeNetOfTax', 'ebit', 'ebitda', 'netIncome'
                    ]
    
    # Since the income statement has a lot of missing data, its better to use DF and clean out
    # any missing values or objects that might be in the statements
    df_income_data[numeric_cols] = df_income_data[numeric_cols].replace(["None", "objects"], 0)
    df_income_data[numeric_cols] = df_income_data[numeric_cols].apply(pd.to_numeric, errors='coerce').fillna(0)

    # Store the DataFrame in the dictionary
    eps_data[ticker] = df_income_data

# Combine all DataFrames in the dictionary into a single DataFrame
df_combined_earnings = pd.concat(eps_data.values())

# Ensure we clean out data. When we resample and there is a non numeric, it will create error
df_combined_earnings[numeric_cols] = df_combined_earnings[numeric_cols].replace(["None", "objects"], 0)
df_combined_earnings = df_combined_earnings.apply(pd.to_numeric, errors='coerce')

# Resample to daily and calculate the mean for all columns
df_daily_averages = df_combined_earnings.resample('D').mean()

# fill in with forward fill
df_daily_averages.fillna(method='ffill', inplace=True)

# We need to take out these two columns since nothing was populating
#df_daily_averages = df_daily_averages.drop(columns=['interestIncome'])
#df_daily_averages = df_daily_averages.drop(columns=['depreciation'])

####################################

# Lets go ahead and merge everything into one excel sheet
# Lets start with earnings
df_reported_earnings = df_pivot_reported_earnings.index

# Create an empty DataFrame with the same index as data
df_reported_earnings = pd.DataFrame(index=SPY_yf_data.index)

# Go through the columns in df_pivot_reported_earnings and add them to df_reported_earnings
for column in df_pivot_reported_earnings.columns:
    df_reported_earnings[column] = df_pivot_reported_earnings[column]

# Here we want to merge both SPY_yf_data and df_reported_earnings
merged_data = SPY_yf_data.merge(df_reported_earnings, left_index=True, right_index=True, how='left')

# Fill missing values with 0 to ensure everything is filled
merged_data.fillna(0, inplace=True)

# Lets do the same for estimated_earnings_dates
estimated_earnings_dates = df_pivot_estimated_earnings.index

# Create an empty DataFrame with the same index as data
estimated_earnings_data = pd.DataFrame(index=merged_data.index)

# Go through the columns in df_pivot_reported_earnings and add them to df_reported_earnings
for column in df_pivot_estimated_earnings.columns:
    estimated_earnings_data[column] = df_pivot_estimated_earnings[column]

# Here we want to merge both merged_data and estimated_earnings_data
final_merged_data = merged_data.merge(estimated_earnings_data, left_index=True, right_index=True, how='left')

# Fill missing values with 0 to ensure everything is filled
final_merged_data.fillna(0, inplace=True)

# Export the final_merged_data DataFrame to a CSV file
output_final_merged_data_path = "final_merged_data.csv"
final_merged_data.to_csv(output_final_merged_data_path, index=True, sep=',')

print(f"Final merged data has been exported to {output_final_merged_data_path}")

# Reindex df_daily_averages to match the index of final_merged_data
df_daily_averages = df_daily_averages.reindex(final_merged_data.index)

# Merge DataFrames
final_merged_data = final_merged_data.merge(df_daily_averages, left_index=True, right_index=True, how='left')

# Fill missing values with 0
final_merged_data.fillna(0, inplace=True)

# Export the final_merged_data_with_income DataFrame to a CSV file
output_final_merged_data_path = "final_merged_data_with_income.csv"
final_merged_data.to_csv(output_final_merged_data_path, index=True, sep=',')

print(f"Final merged data with income has been exported to {output_final_merged_data_path}")







