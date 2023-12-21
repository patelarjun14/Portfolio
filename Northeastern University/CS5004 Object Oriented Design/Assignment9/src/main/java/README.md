## A9 - Todo Application

### Group 6 - By Matthew Fox, Arjun Patel, Trenton Creamer

CommandLine module is in charge of handling the creation of a CommandLineParser. ParserArguments help CommandLineParser determine if an argument needs a value and the value passed was valid.

Functionalities module is in charge of creating and running functionalities for the TodoApp to run. Each Functionality takes the processed arguments the CommandLineParser generated and gets all the relevant information and performs their delegated task.

TodoApp runs the whole app by creating the CommandLineParser and running the appropriate functionality based on user inputs.

