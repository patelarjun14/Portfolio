[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=9227664&assignment_repo_type=AssignmentRepo)
# Boba 🧋🫧🥛🍵🍡

You are the owner of the best bubble tea shop in South Lake Union and you want to make it easy for your customers to order by speaking in natural language. Before working up to voice-to-text you decide to start with just text for your boba ordering system.

The system you develop will accept a typed customer order, engage in a dialog with the customer to clarify details, and then print out the complete order. For simplicity we will ignore details about cost and it does not need to actually make the beverage ... yet.

## Background

The goal of this assignment is to create a dialog system that does something useful. And importantly, during this process, to get an idea of the issues involved in understanding natural language. Chatbots are becoming common in such situations. For example:

* [https://www.linkedin.com/pulse/5-ways-grow-revenue-using-chatbots-sales-tool-alexandre-debecker/](https://www.linkedin.com/pulse/5-ways-grow-revenue-using-chatbots-sales-tool-alexandre-debecker/)
* [https://www.salesforce.com/eu/blog/2019/04/what-is-a-chatbot.html](https://www.salesforce.com/eu/blog/2019/04/what-is-a-chatbot.html)

However, our emphasis is not on the highly polished natural language interface you may see with a chatbot. Instead, our goal is to have you concentrate on the logic behind such systems, finding out what information is available in the customer's order and what is not, and ensuring you get all the required information from the customer by asking specific questions. Of course, in theory, you could create a fine chatbot using the information you put together in this assignment.

You may program in either Python or SWI-Prolog.

## Instructions

1. Decide on the menu: the drinks, toppings, and options you offer. Customers can only order the specials you offer. They cannot create a completely new boba tea from scratch. However, they can modify any of the bubble teas by choosing a (different) type of tea or milk. They may also customize with topics or exceptions (examples below) to their boba order.

    * Your menu must include at least 4 types of drink speicals, one of which has your name in it, such as "Grace's Taro Special".
    * You should decide what ingredients usually go into each drink, but you can leave the temperature or sugar level unspecified in some types of drinks. Use this information to make up a description for each drink you offer. For example, you may describe "Grace's Taro Special", as a "Drink with jasmine tea and taro milk topped with pudding, lychee jelly, boba, and foam with normal sweetness."
    * The menu must offer at least 3 options each for tea-base and milk-base with at least 3 additional toppings, and at least 3 exceptions you can leave out.

2. For inspiration, see something like the [Gong cha](https://gongchausa.com/) or [TSAoCAA](https://www.tsaocaatea.com/). Their websites will give you some ideas. Get creative, but don't make things too complicated! Decide on what you offer, including:

    * The kinds of drinks you offer (e.g., Brown Sugar Milk Tea, Honey Lemon Yogurt Green Tea, etc.)
    * The usual ingredients of each drink (e.g., tea, milk, and boba for a Milk Tea)
    * The kinds of base drink options available (e.g., matcha, chai, coffee, etc.)
    * The milk options available (e.g., soy, coconut, latose-free, etc.)
    * Additional options that are possible (e.g., hot or cold, "extra boba", "basil seeds", etc.), and
    * What exceptions are possible ("no foam", "hold the ice", etc.)

    Complete the "My Drinks" section below.

3. Decide on the logic of the system. In this step, you interact with the customer to get complete details of the drink they want. From each initial customer request, you have to figure out what's specified. If some details are not specified by the customer (e.g., they did not specify the drink base they want), you should tell the customer what detais you're looking for, what the options are, and what the default is. You should then ask the customer to specify the details you require. To get these details right, imagine you are using the customer input to fill out a form (or data structure) with something like the following details:

    * Name of Drink:
    * Usual ingredients:
    * Tea-type:
    * Milk-type:
    * Options:
    * Exceptions:

    Of these, the name, tea, and milk are required to be confirmed by the customer.

    Customers may specify additional options or exceptions as optional information; often they may specify neither. The usual ingredients are known to the program from the name of the drink.

4. Your program should:

    * Greet the customer and ask them what they want to have.
    * If the customer asks for the menu with a request like "What are the choices?" , "What's on the menu?" etc., display a menu with the drink choices and a description of each. Ask them what they would like to have.
    * The customer should come up with an (initial) request that looks something similar to one of these (these are only some examples; you can think of so many variations of these):
        * Grace's Taro Special please with no jelly.
        * I want the Brown-Sugar Milk Tea, skim milk, with cheese foam.
        * I'd like the Boba Lover's with green tea please, oreo, hold the sugar.
    * Remember that customers can only order the drinks you offer, but they have a choice of bases, milks, toppings, & exceptions, and they can ask for any of these choices with any drink they order. For example, if a customer just asks for "Grace's Taro with chai please, another boba, and without sweetness", you  can imagine the form or data structure you saw above filled-in with the following details:
        * Name of drink: Grace's Taro Special
        * Usual ingredients: jasmine tea, taro milk, pudding, lychee jelly, boba, foam, and normal sweetness
        * Tea: Chai
        * Milk: Taro
        * Options: boba
        * Exceptions: normal sweetness

        In this case, the customer has completely specified what they want. No other details are required.
    * If some details are not specified in the customer's initial request, you must get them to clarify their choice for each detail that is required. For example, if the customer does not specify any particular milk for a drink, you may say "This drink usually comes with coconut milk. Is that alright or would you like: almond milk, oat milk ..."
    * Take the customer's input and fill in the details provided. Decide also how you will respond if the customer specifies irrelevant options, for example, asking for "No pudding please" even when the drink they order does not have pudding.
5. Complete the My Text Processing section.
6. Demo your program with a TA. Visit office hours or make an appointment.

Programming notes:

* Some terms are equivalent ("bubble" and "boba", "matcha" and "green tea", ...) and you must treat each element in a of these terms the same as the other elements in the set.
* Ignore un-needed words like "please", "thank you", "I'd like a", etc. for simplicity.
* Phrases like "Hold the sugar" and "I don't want the dragonfruit" mean to put sweetness and dragonfruit in the exceptions liks.
* Confirm the drink order once complete.
* Allow the user to see the drinks and descriptions at any time.
* Clarify any missing item.
* Name the main program `boba.py` or `boba.pl` as appropriate. Create addtional files as needed.
* Do *NOT* request numbers from the user (enter 1. for green tea, 2 for sakura tea, etc.) the point is to be as natural language possible.
* Do *NOT* use any chatbot package or a bot framework. You may use any regex package to identify relevant words in the customer's input.
* Do *NOT* create a fancy UI. Simple text input / output only.
* Do *NOT* use any natural language library such as nltk nor spaCy.

## My Drinks

[Drink Bases]

[Milk Options]

[Additional Options]

[Possible Exceptions]

[At Least 4 Named Drinks with descriptions]

## My Text Processing

[The list of terms you treat as equivalent]

[The list of terms like "Please" etc. that you will ignore.]

[The different ways you will allow customers to specify exceptions like "Hold the rose"]

## Screenshots or Notebook

Include 3 screenshot examples or a jupyter notebook where the boba ordering system takes customer input and creates something for the customer based on incomplete specifications for the boba. At least 2 of  these examples should be incomplete specifications requiring the system to check with the customer to get additional details. Add a 4th example where the boba ordering system takes customer input, and fails to create an order for the customer, because the logic of the system does not support something the customer is requesting.

## Reflection

1. Explain in two scentences what you felt was the easiest part of the assignment and why.
I think the easiest part was setting up all of the data strctures because the README gave majority of what we needed. I also think creating the print statements was easy too.
2. Explain in two scentences what you felt was the hardest part of the assignment and why.
I think the hardest part of this assigment is how to approach this problem. One aspect I spent a lot of time on was figuring out how to include multiple orders. For example, if someone says they want 3 Arjun's Specials how do I create 3 different drinks?
3. Explain how your last example causes your ordering system to fail.
If a customer does not have a phrase that activates an order or does not have an item in their description, the sytem will fail the order, however, if a customer entered in something they believed should activate an order (such as just listing an item), the program will ask it to confirm whatever they said was an order and add it to the keys that activate orders. The program takes a key phrase and a item for the order to activate. If it doesnt have both (shown in 5th example), then it will keep asking the customer to reorder till it activates. At some point the customer will most likey say no to ordering, which will end the program.

4. Would it be possible to create a chatbot that pretends to be the customer? Explain why or why not.
Yes as long as the chatbot has data and a specific goal. For example, my program actually records responses so that if people enter in the same response my program will generate the last order from that response. If I collected enough data, I could create a chatbot that is a customer, however, it wouldnt be useful besides for testing purposes.


5. How easy / difficult would it be to add another drink as well additional teas/milks/toppings to your program?
It was extremely difficult. The issue is with the language because if someone says "I want 3 Arjun's Specials with no ice and 2 Chocolate Specials with no boba", the way to connect no ice to Arjun's special and no boba to chocolate specials is difficult. You can use specific conjuctions to indicate separations, but once again, this is difficult.  



Examples from code:
Input 1 = I would like an Arjun's Special with no brown sugar, matcha, soy, extra boba, and no ice
arjunpatel@arjuns-mbp Homework5 % /usr/bin/python3 "/Users/arjunpatel/Desktop/Code/Python Code/Running Code/CS 5100
/Homework5/boba-patelarjun14/new_boba.py"
Hi There!
What would you like to order today?
I would like an Arjun's Special with no brown sugar, matcha, soy, extra boba, and no ice
To make sure we have your order correct.
One  ["arjun's special"]
With ['brown sugar']
tea type for order is ['matcha']
milk type for order ['soy']
options for order ['extra boba']
exceptions for order ['no ice']
Does this look correct?
yes
Ok! Your order is being processed. Thank you for ordering!
Please order another item



Input 2 = Can I get a chocolate special with no brown sugar, matcha, and no ice
arjunpatel@arjuns-mbp Homework5 % /usr/bin/python3 "/Users/arjunpatel/Desktop/Code/Python Code/Running Code/CS 5100
/Homework5/boba-patelarjun14/new_boba.py"
Hi There!
What would you like to order today?
Can I get a chocolate special with no brown sugar, matcha, and no ice
Just to make sure. Would you be ok if we placed in  milk ?
no
Can you pick between these options?
soy
coconut
milk
soy
Is this the milk type you want?,  soy
yes
Just to make sure. Would you be ok if we placed in none for options?
no
Can you pick between these options?
extra boba
hot
cold
basil seeds
none
none
Is this the option type you want?,  none
yes
To make sure we have your order correct.
One  ['chocolate special']
With ['brown sugar']
tea type for order is ['matcha']
milk type for order ['soy']
options for order ['none']
exceptions for order ['no ice']
Does this look correct?
yes
Ok! Your order is being processed. Thank you for ordering!
Please order another item

Input 3 = Hi. Can I get a mint special
arjunpatel@arjuns-mbp Homework5 % /usr/bin/python3 "/Users/arjunpatel/Desktop/Code/Python Code/Running Code/CS 5100
/Homework5/boba-patelarjun14/new_boba.py"
Hi There!
What would you like to order today?
Hi. Can I get a mint special
Just to make sure. Do you want all the usual ingredients listed below?
tapioca starch
brown sugar
water
brown sugar syrup
mint leaves
no
Can you input each ingredient you dont want (one by one)?
brown sugar
Is that all the ingredients you do not want?
no
Please continue to type in any other ingredients you dont want
mint leaves
Is that all the ingredients you do not want?
yes
Just to make sure. Would you be ok if we placed in  coffee ?
no
Can you pick between these options?
matcha
chai
coffee
green tea
matcha
Is this the milk type you want?,  matcha
yes
Just to make sure. Would you be ok if we placed in  milk ?
no
Can you pick between these options?
soy
coconut
milk
soy
Is this the milk type you want?,  soy
no 
Try typing in your milk type again
milk
Is this the milk type you want?,  milk
yes
Just to make sure. Would you be ok if we placed in none for options?
no
Can you pick between these options?
extra boba
hot
cold
basil seeds
none
cold
Is this the option type you want?,  cold
yes
Just to make sure. Would you be ok if we placed in  none for exceptions?
no
Can you pick between these exceptions?
no foam
no ice
no sugar
no foam
Is this the option type you want?,  no foam
no
Try typing in your option type again
no sugar
Is this the option type you want?,  no sugar
yes
To make sure we have your order correct.
One  ['mint special']
With ['tapioca starch', 'water', 'brown sugar syrup']
tea type for order is ['matcha']
milk type for order ['milk']
options for order ['cold']
exceptions for order ['no sugar']
Does this look correct?
yes
Ok! Your order is being processed. Thank you for ordering!
Please order another item


Example of machine learning 
Input 4 = Arjun’s special
arjunpatel@arjuns-mbp Homework5 % /usr/bin/python3 "/Users/arjunpatel/Desktop/Code/Python Code/Running Code/CS 5100
/Homework5/boba-patelarjun14/new_boba.py"
Hi There!
What would you like to order today?
arjun's special
Sorry. I seem to by having issues understanding whether you want to order
Would you like to order? (yes or no) or would you like to see the menu (menu)
yes
Please type in your order again
arjun's special
Just to make sure. Do you want all the usual ingredients listed below?
tapioca starch
brown sugar
water
brown sugar syrup
mint leaves
chocolate bits
…

Example of complete failure
Input 5 = I would like to order nothing
arjunpatel@arjuns-mbp Homework5 % /usr/bin/python3 "/Users/arjunpatel/Desktop/Code/Python Code/Running Code/CS 5100
/Homework5/boba-patelarjun14/new_boba.py"
Hi There!
What would you like to order today?
I would like to order nothing
Sorry. I seem to by having issues understanding whether you want to order
Would you like to order? (yes or no) or would you like to see the menu (menu)
yes
Please type in your order again
I would like to order nothing
Sorry. I seem to by having issues understanding whether you want to order
Would you like to order? (yes or no) or would you like to see the menu (menu)
