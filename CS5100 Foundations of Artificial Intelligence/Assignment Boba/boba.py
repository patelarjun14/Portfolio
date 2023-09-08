"""
By Arjun Patel
"""



# Create Class for drink
class Drink:
    def __init__(self, Name_of_Drink, Usual_ingredients, Tea_type, Milk_type, Options, Exceptions):        
        self.Name_of_Drink = Name_of_Drink
        self.Usual_ingredients = Usual_ingredients
        self.Tea_type = Tea_type
        self.Milk_type = Milk_type
        self.Options = Options
        self.Exceptions = Exceptions

# Set Defaults
Default_tea = 'coffee'
Default_milk = 'milk'
Default_options = 'none'
Default_exceptions = 'none'


# Ingredients Dictionary
Ingredients_Dictionary = {
    "tapioca starch": True, 
    "brown sugar": True, 
    "water": True, 
    "brown sugar syrup": True, 
    "mint leaves": True, 
    "chocolate bits": True,
    "chocolate syrup": True,
    "honey": True,
    "strawberry syrup": True,
    "stawberries": True
}

# Tea Options
Options_Tea_Type_Dictionary = {
    'matcha': True,
    'chai': True,
    'coffee': True,
    'green tea': True
}

# Milk Options
Options_Milk_Type_Dictionary = {
    'soy': True,
    'coconut': True,
    'milk': True
}

# Options dictionary
Options_Dictionary = {
    'extra boba': True,
    'hot': True,
    'cold': True,
    "basil seeds": True,
    "none": True
}

# Exceptions dictionary
Exceptions_Dictionary = {
    'no foam': True,
    'no ice': True,
    'no sugar': True
}


# Create drinks
drink_name_1 = "arjun's special"
Usual_ingredients_1 = ["tapioca starch", "brown sugar", "water", "brown sugar syrup", "mint leaves", "chocolate bits"]
tea_type_1 = Options_Tea_Type_Dictionary
milk_type_1 = Options_Milk_Type_Dictionary
options_1 = Options_Dictionary
exceptions_1 = Exceptions_Dictionary
drink_1 = Drink(drink_name_1, Usual_ingredients_1, tea_type_1, milk_type_1, options_1, exceptions_1)

drink_name_2 = "chocolate special"
Usual_ingredients_2 = ["tapioca starch", "brown sugar", "water", "brown sugar syrup", "chocolate syrup"]
tea_type_2 = Options_Tea_Type_Dictionary
milk_type_2 = Options_Milk_Type_Dictionary
options_2 = Options_Dictionary
exceptions_2 = Exceptions_Dictionary
drink_2 = Drink(drink_name_2, Usual_ingredients_2, tea_type_2, milk_type_2, options_2, exceptions_2)
    

drink_name_3 = "mint special"
Usual_ingredients_3 = ["tapioca starch", "brown sugar", "water", "brown sugar syrup", "mint leaves"]
tea_type_3 = Options_Tea_Type_Dictionary
milk_type_3 = Options_Milk_Type_Dictionary
options_3 = Options_Dictionary
exceptions_3 = Exceptions_Dictionary
drink_3 = Drink(drink_name_3, Usual_ingredients_3, tea_type_3, milk_type_3, options_3, exceptions_3)



drink_name_4 = "siracha honey special"
Usual_ingredients_4 = ["tapioca starch", "brown sugar", "water", "brown sugar syrup", "siracha", "honey"]
tea_type_4 = Options_Tea_Type_Dictionary
milk_type_4 = Options_Milk_Type_Dictionary
options_4 = Options_Dictionary
exceptions_4 = Exceptions_Dictionary
drink_4 = Drink(drink_name_4, Usual_ingredients_4, tea_type_4, milk_type_4, options_4, exceptions_4)


drink_name_5 = "strawberry special"
Usual_ingredients_5 = ["tapioca starch", "brown sugar", "water", "brown sugar syrup", "mint leaves", "strawberry syrup", "stawberries"]
tea_type_5 = Options_Tea_Type_Dictionary
milk_type_5 = Options_Milk_Type_Dictionary
options_5 = Options_Dictionary
exceptions_5 = Exceptions_Dictionary
drink_5 = Drink(drink_name_5, Usual_ingredients_5, tea_type_5, milk_type_5, options_5, exceptions_5)

# Drink selection
keys_for_drink_name = {
    drink_1.Name_of_Drink.lower(): drink_1,
    drink_2.Name_of_Drink.lower(): drink_2,
    drink_3.Name_of_Drink.lower(): drink_3,
    drink_4.Name_of_Drink.lower(): drink_4,
    drink_5.Name_of_Drink.lower(): drink_5
    }



# All combinations that would activate order
keys_for_order = {
    "can i order ": True,
    "i would like to order ": True,
    "can i get ": True,
    "yes. can i get ": True,
    "hi. can i get ": True,
    "hi! can i get ": True,
    "i would like to get": True,
    "i want": True,
    "i would like": True

}

# Keys to activate menu
keys_for_menu = {
    "can i look at the menu": True,
    "menu": True,
    "whats on the menu?": True,
    "what's on the menu?": True,
    "what are the choices?": True,
}

# If a customer has something else that is not an order, record what their request
keys_for_request = {}

# Function to activiate Menu
def menu_activation_function(order_reponse):
    for key in keys_for_menu:
        if order_reponse.__contains__(key):
            return True
    return False

# Function to recognize quantities
def quantities_for_order_function(order_response):
    split_order_response = order_response.split(" ")
    quantities_list = []

    for word in split_order_response:
        if word.isnumeric():
            quantities_list.append(word)

    return quantities_list

# Items for order function
def items_for_order_function(order_response):
    item_list = []

    for key in keys_for_drink_name:
        if order_response.__contains__(key):
            item_list.append(key)

    return item_list

# Order activation function
def order_activation_function(order_response):
    for key in keys_for_order:
        if order_response.__contains__(key) and len(items_for_order_function(order_response))>0:
            return True
    return False

# Ingredients for order function
def ingredients_for_order_function(order_response):
    ingredients_list = []

    for key in Ingredients_Dictionary:
        if order_response.__contains__(key):
            ingredients_list.append(key)

    return ingredients_list

# Tea type function
def tea_type_function(order_response):
    tea_type_list = []

    for key in Options_Tea_Type_Dictionary:
        if order_response.__contains__(key):
            tea_type_list.append(key)

    return tea_type_list

# Milk type function
def milk_type_function(order_response):
    milk_type_list = []

    for key in Options_Milk_Type_Dictionary:
        if order_response.__contains__(key):
            milk_type_list.append(key)
    
    return milk_type_list

# Options functions
def options_fuctions(order_response):
    options_list = []

    for key in Options_Dictionary:
        if order_response.__contains__(key):
            options_list.append(key)
    
    return options_list

# Exceptions function
def exceptions_functions(order_response):
    exceptions_list = []

    for key in Exceptions_Dictionary:
        if order_response.__contains__(key):
            exceptions_list.append(key)
    
    return exceptions_list

# Record orders
Record_orders = {

}



def main():

        # Greet the customer and ask them what they want to have.
        print("Hi There!")
        print("What would you like to order today?")
    
        # Make program infinite loop
        while True:

            # Ask user to ask something
            order_response = input().lower()

            # If the order response contains a request for a menu,
            # then print the menu
            if menu_activation_function(order_response) == True:
                print("Here is our Menu: ")
                for key in keys_for_drink_name:
                    print(key)

            # If the order response has already been recorded,
            # print the last order that this response had
            if order_response in Record_orders:
                
                # Ask to confirm order with customer
                print("Does this look correct?")
            
                # Print last order using this response
                print("To make sure we have your order correct.")
                print("One ", Record_orders[order_response].Name_of_Drink)
                print("With", Record_orders[order_response].Usual_ingredients)
                print("Tea type for order is", Record_orders[order_response].Tea_type)
                print("Milk type for order", Record_orders[order_response].Milk_type)
                print("Options for order", Record_orders[order_response].Options)
                print("Exceptions for order",Record_orders[order_response].Exceptions)
                
                # Ask user to input response to question
                response_16 = input().lower()

                # If the response is yes, 
                # then process the order
                if response_16 == "yes":
                    print("Ok! Your order is being processed. Thank you for ordering!")
                    print("Please order another item")
                
                # If the answer is no, 
                # then dont process the order.
                # Make them submit a new order and delete this
                # order from the records
                if response_16 == "no":
                    print("Please rephrase your order and try again...")
                    print("If you are ordering multiple drinks, please try entering in one at a time")
                    del Record_orders[order_response]
  
            # If the order is an order and is not in the record orders,
            # then process the order

            if order_activation_function(order_response) == True and order_response not in Record_orders:

                # Process their order for items,
                # return list
                items_for_order = items_for_order_function(order_response)

                # Process their order for ingredients they dont want
                # return list
                ingredients_for_order = ingredients_for_order_function(order_response)
                
                # Process their order for tea type
                # return list
                tea_type_for_order = tea_type_function(order_response)

                # Process their order for milk type
                # return list
                milk_type_for_order = milk_type_function(order_response)

                # Process their order for options
                # return list
                options_for_order = options_fuctions(order_response)

                # Process their order for exceptions
                # return list
                exceptions_for_order = exceptions_functions(order_response)

                # For each item in the order,
                # NOTE: I was trying to process each order with quantities originally 
                # but could not figure this out
                for item in items_for_order:
                    
                    # If customer list no ingredients to take off, then request to go to
                    # default, which is all usual ingredients
                    # If they say no, 
                    # then ask them to list all the ingredients they dont want
                    # Once customer has listed all ingredients to be taken off,
                    # list the ingredients that have to be in the drink
                    if len(ingredients_for_order) == 0:
                        print("Just to make sure. Do you want all the usual ingredients listed below?")
                        for ingredients in keys_for_drink_name[item].Usual_ingredients:
                            print(ingredients)
                        response_1 = input().lower()
                        if response_1 == "no":
                            print("Can you input each ingredient you dont want (one by one)?")
                            while True:
                                response_2 = input().lower()
                                if response_2 in ingredients_for_order:
                                    print("Ingredient is already noted to be taken off")
                                elif response_2 in keys_for_drink_name[item].Usual_ingredients and response_2 not in ingredients_for_order:
                                    ingredients_for_order.append(response_2)
                                elif response_2 not in keys_for_drink_name[item].Usual_ingredients:
                                    print(response_2," is not in item's ingredients")
                                print("Is that all the ingredients you do not want?")
                                response_3 = input().lower()
                                if response_3 == "yes":
                                    new_list = keys_for_drink_name[item].Usual_ingredients
                                    for ingredient in ingredients_for_order:
                                        new_list.remove(ingredient)
                                    ingredients_for_order = new_list
                                    break
                                if response_3 == "no":
                                    print("Please continue to type in any other ingredients you dont want")
                                else:
                                    print("Sorry... I didnt get that. continue to type in any other ingredients you dont want")
                        if response_1 == "yes":
                            ingredients_for_order = keys_for_drink_name[item].Usual_ingredients
                    
                    # If customer list no tea type to take off, then request to go to
                    # default, which is coffee
                    # If they say no, 
                    # then ask them to choose one tea type 
                    if len(tea_type_for_order) == 0:
                        print("Just to make sure. Would you be ok if we placed in ", Default_tea,"?")
                        tea_type_for_order.append(Default_tea)
                        response_4 = input().lower()
                        if response_4 == "no":
                            print("Can you pick between these options?")
                            for tea_type in keys_for_drink_name[item].Tea_type:
                                print(tea_type)
                            while True:
                                response_5 = input().lower()
                                if response_5 in keys_for_drink_name[item].Tea_type:
                                    tea_type_for_order[0] = response_5
                                if response_5 not in keys_for_drink_name[item].Tea_type:
                                    print(response_5, "is not listed in milk type")
                                    if len(tea_type_for_order) == 0:
                                        tea_type_for_order[0] = Default_tea
                                print("Is this the milk type you want?, ",tea_type_for_order[0])
                                response_6 = input().lower()
                                if response_6 == "yes":
                                    break
                                if response_6 == "no":
                                    print("Try typing in your tea type again")
                                else:
                                    print("Sorry... I didnt get that. Please try typing in your tea type again")
                        if response_4 == "yes":
                            tea_type_for_order = Default_tea


                    # If customer list no milk type, then request to go to
                    # default, which is milk
                    # If they say no, 
                    # then ask them to choose one milk type 
                    if len(milk_type_for_order) == 0:
                        milk_type_for_order.append(Default_milk)
                        print("Just to make sure. Would you be ok if we placed in ", Default_milk,"?")
                        response_7 = input().lower()
                        if response_7 == "no":
                            print("Can you pick between these options?")
                            for milk_type in keys_for_drink_name[item].Milk_type:
                                print(milk_type)
                            while True:
                                response_8 = input().lower()
                                if response_8 in keys_for_drink_name[item].Milk_type:
                                    milk_type_for_order[0] = response_8
                                if response_8 not in keys_for_drink_name[item].Milk_type:
                                    print(response_8, "is not listed in milk type")
                                    if len(milk_type_for_order) == 0:
                                        milk_type_for_order[0] = Default_milk
                                print("Is this the milk type you want?, ",milk_type_for_order[0])
                                response_9 = input().lower()
                                if response_9 == "yes":
                                    break
                                if response_9 == "no":
                                    print("Try typing in your milk type again")
                                else:
                                    print("Sorry... I didnt get that. Please try typing in your milk type again")
                        if response_7 == "yes":
                            milk_type_for_order = Default_milk

                    # If customer list no option type, then request to go to
                    # default, which is none
                    # If they say no, 
                    # then ask them to choose one option type 
                    if len(options_for_order) == 0:
                        options_for_order.append(Default_options)
                        print("Just to make sure. Would you be ok if we placed in", Default_options,"for options?")
                        response_10 = input().lower()
                        if response_10 == "no":
                            print("Can you pick between these options?")
                            for options_type in keys_for_drink_name[item].Options:
                                print(options_type)
                            while True:
                                response_11 = input().lower()
                                if response_11 in keys_for_drink_name[item].Options:
                                    options_for_order[0] = response_11
                                if response_11 not in keys_for_drink_name[item].Options:
                                    print(response_11, "is not listed in option type")
                                    options_for_order[0] = Default_options  
                                print("Is this the option type you want?, ",options_for_order[0])
                                response_12 = input().lower()
                                if response_12 == "yes":
                                    break
                                if response_12 == "no":
                                    print("Try typing in your option type again")
                                else: 
                                    print("Sorry... I didnt get that. Try typing in your option type again")
                        
                        if response_10 == "yes":
                            options_for_order = Default_options                                    

                    # If customer list no exceptions, then request to go to
                    # default, which is none
                    # If they say no, 
                    # then ask them to choose one exception

                    if len(exceptions_for_order) == 0:
                        exceptions_for_order.append(Default_exceptions)
                        print("Just to make sure. Would you be ok if we placed in ", Default_exceptions,"for exceptions?")
                        response_13 = input().lower()
                        if response_13 == "no":
                            print("Can you pick between these exceptions?")
                            for exception_type in keys_for_drink_name[item].Exceptions:
                                print(exception_type)
                            while True:
                                response_14 = input().lower()
                                if response_14 in keys_for_drink_name[item].Exceptions:
                                    exceptions_for_order[0] = response_14
                                if response_14 not in keys_for_drink_name[item].Exceptions:
                                    print(response_11, "is not listed in option type")
                                    exceptions_for_order[0] = Default_exceptions 
                                print("Is this the option type you want?, ",exceptions_for_order[0])
                                response_15 = input().lower()
                                if response_15 == "yes":
                                    break
                                if response_15 == "no":
                                    print("Try typing in your option type again")    
                                else:
                                    print("Sorry... I didnt get that. Try typing in your option type again")
                        if response_13 == "yes":
                            exceptions_for_order = Default_exceptions                         
                
                # After everything is done, print out order for customer
                print("To make sure we have your order correct.")
                print("One ", items_for_order)
                print("With", ingredients_for_order)
                print("tea type for order is", tea_type_for_order)
                print("milk type for order", milk_type_for_order)
                print("options for order", options_for_order)
                print("exceptions for order",exceptions_for_order)
                

                Final_Drink = Drink(items_for_order[0],ingredients_for_order, tea_type_for_order, milk_type_for_order, options_for_order, exceptions_for_order)
    


                print("Does this look correct?")

                response_16 = input().lower()

                if response_16 == "yes":
                    print("Ok! Your order is being processed. Thank you for ordering!")
                    print("Please order another item")
                    Record_orders[order_response] = Final_Drink
                
                if response_16 == "no":
                    print("Please rephrase your order and try again...")


                    
            # If the system cant recgonize the order or menu request, 
            # then try to learn from the customer

            else:
                print("Sorry. I seem to by having issues understanding whether you want to order")
                print("Would you like to order? (yes or no) or would you like to see the menu (menu)")
                response_3 = input().lower()
                if response_3 == "yes":
                    keys_for_order[order_response] = True
                    print("Please type in your order again")
                if response_3 == "menu":
                    keys_for_menu[order_response] = True
                    print("Please type in your menu request")
                if response_3 == "no":
                    print("Thank you for chatting with me!")
                    break

                


        


if __name__ == '__main__':
    main()