Name: Arjun Patel
How many hours did it take you to complete this assignment?
I did not keep track of time, however, took the assignment 
took me 3-4 whole days. Potentially, over 30 hours.

Did you collaborate with any other students/TAs/Professors?
N/A

Did you use any external resources? (Cite them below)
https://stackoverflow.com/questions/56031104/the-cd-command-in-c-and-use-of-chdir


(Optional) What was your favorite part of the assignment?
This was a difficult assignment, however, it was a fun assignment
because it allowed us to develop our own shell that we can use
later on in the future

(Optional) How would you improve the assignment?
One aspect I would suggest is to clean up the starter file
because it had a lot of errors and missguided me in creating
this program. I had to change a lot of the starter code, which
I wasnt sure if I should have been doing. I would suggest
going over the starter code with the class before handing it over.

Command Name: cd
Synopsis: Changes directory
Description: This command changes the directory of the current directory
the program is on. Depending on the file location entered, it can move to
a different file location. It also prints the file location name.
Notes: I implemented this by using the chdir function. The great part about
this function is that it takes in .., which can go back one directory. If other
commands are needed, execve will execute it. This also prints the file path after
the change has been made. Writing cd into the shell can also give you the current
file address.

Command Name: help
Synopsis: prints functions that can be used
Description: This function prints all the functions that were built into
this shell program
Notes: I implemented this by using a simple print and formatted it accordingly.
I decided not to write descriptions for each command within this function
as I figured a more simple look was appealing. Also each command is self explanatory.

Command Name: exit
Synopsis: Exits the program
Description: When exit is typed into the shell, the exit program will shut down
the shell program
Notes: I implemented this by using a simple exit function. When it is exit(0), this
will shut down the entire shell. Also there is no parameter needed for the function
that runs exit.

Command Name: game
Synopsis: Guess the number between 0 and 10
Description: It is a game that allows the user to guess a number between
0 and 10 with 1 try
Notes: I implemented this by using a while loop and a rand() function to generate
the number that needs to be guessed. The user has one try to see if they can guess 
the number correctly. At the end, there will be a message that congratulates the user
for guessing the right number or tells the user to run the program again. Originally,
I had this function loop through multiple times, but if the user didnt enter in a
number, the while loop would run an error or infinite loop. I have modified this to 
avoid any errors.

