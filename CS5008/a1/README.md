Description of Directory
This is a directory for assignment 1, which we created 3 different 
functions listed below (all in separate files):
1. Print Victory
2. Print Rectangles
3. Print Fancy Rectangles

This file (README.MD) is a short summary of all functions.

warmup.c has the warmup problem with Print Victory Function
rectangle.c has the Print Rectangles Function
fancy_rectangle.c has the Print Fancy Rectangles Function

All of these files were requested to be created on the grading Criteria.

#################################################################
Print Victory Function
This function runs automatically so there is no need
to enter anything. This function prints "VICTORY!" three
times in 2 different ways. One using a for loop and the other
is a mannual process by using the printf() built in function.


-bash-4.2$ gcc warmup.c
-bash-4.2$ ./a.out
VICTORY!
VICTORY!
VICTORY!
VICTORY!
VICTORY!
VICTORY!
-bash-4.2$

##################################################################
Print Rectangles Function
This function runs through main() and will request for the width
and height of the rectangle you are trying to print. It is important
to note that the rectangle that is being printed is a hollow rectangle.
The function uses for loops for both the width and length then prints
"-" in the necessary spots.


-bash-4.2$ gcc rectangle.c
-bash-4.2$ ./a.out
Enter width: 10
Enter height: 4
----------
-        -
-        -
----------
-bash-4.2$




##################################################################
Print Fancy Rectangles
This function runs through main() as well and will request multiple parameters.
This function after running the Print Rectangles Function will request the
width, height, symbol, and fill. If you type in 0 in fill, you will get a hollow
rectangle and if you type in 1 in fill, you will get a filled rectangle

-bash-4.2$ gcc fancy_rectangle.c
-bash-4.2$ ./a.out
Enter width: 10
Enter height: 4
Enter symbol: $
Enter fill: 0
$$$$$$$$$$
$        $
$        $
$$$$$$$$$$
-bash-4.2$ ./a.out
Enter width: 8
Enter height: 5
Enter symbol: @
Enter fill: 1
@@@@@@@@
@@@@@@@@
@@@@@@@@
@@@@@@@@
@@@@@@@@
-bash-4.2$

##################################################################

References
https://www.youtube.com/watch?v=gisY-IZZ2ts



###################################################################
Overall Summary
The assignment overall was pretty good. The first part with printing
victory went smooth, but the logic for printing a hollow rectange was
the trickiest part of the assignment. Also using VIM and writing some of
my first C functions were difficult because of the user interface and 
understanding errors along the way. It took me about 6 hours or more hours 
to complete due to the learning curve for C and understanding how to use VIM.

Also one aspect I would change is to update the directions for the homework. Unfortunately,
the grading criteria and directions do not match one antoher.

Also to add to this assignmment. I submitted it late because I had issues 
with github. For some reason my github directory was cloned in file a1,
which caused a lot of issues when submitting. Also some files were deleted, but
luckily, I saved my work on a word document. Please contact Professor Drew about
late pentalty. 


