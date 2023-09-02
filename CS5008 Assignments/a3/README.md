
By Arjun Patel

Description of Directory:
This is a directory for assignment 3. Below, I have
created a quick description of each file:

1. Makefile: This was a modified file that allows to compile
files together (edited file for better functionality)

2. linkedlist.c: This file contains all the written functions
for the linked list. The written functions are written below:
	a. CreateLinkedList(): Creates a linked list
	b. DestroyLinkedList(): This function destroys a linked list
	c. NumElemntsInLinkedList(): Returns number of elements in linked list
	d. InsertLinkedList(): Adds an element to the head of a linked list
	e. AppendLinkedList(): Adds an element to the tail of a linked list
	f. PrintLinkedList(): Prints linked list
	g. CreateLinkedListNode(): Creates a new linked list node
	h. DestroyLinkedListNode(): Destroys a linked list node
	i. RemoveLLElem(): Removes an element in linked list

3. linkedlist.h: This is a header file for linkedlist.c. This also contains the 
struct for the linked list

4. sort.c: This file contains all the written functions for part 1 and part 2. 
Below is the breakdown of the file:

	PART 1: Implement a Sort
	a. SwapFunction(): Designed for Sort(). It will swap the current and selected node.
	b**. Sort(): This is a function using the Selection Sort method. This function is 
	being used for my sort function for part one and it is being used for my algorithm
	for part 2.
	
	PART 2: Implement at least 2 sort algorithms (1 of which needs to be a Quicksort algorithm)
	c. Typedef struct AList: Used from class. This will define a list
	d. printAll(): Takes an array and prints it out
	e. swap(): Will swap the left and right of an array
	f*. quicksort(): This is the quicksort method for part 2. This is a classic
	quick sort using the first element in an array as a pivot. This was used in class
	g. add(): Adds a value to an array
	h. create(): Creates an array
	
	PrintReport: We discovered in lab (3/7/2022) I was facing a segmention fault, which was 
	being caused by an unusual bug related to allocating/free memory. We were unable to solve
	the issue.

	Note: For easier understanding, here are the functions that complete the requirements
	Part 1: Sort() is my sort function that completes part 1
	Part 2: Sort() is my first algorithm. quicksort() is my second algorithm and is a quicksort.


	

5. sort.h: This is the header file for the sort.c file.

6. main.c: This is where we are running main.

7. maintest.c: This is where we run our test.

8. README.md: This is the current file you are reading. This summarizes the whole directory.

SUMMARY:
What resources did you use?
https://www.geeksforgeeks.org/how-to-measure-time-taken-by-a-program-in-c/#:~:text=h.,%23include%20%3Ctime.
https://visualgo.net/en/sorting
http://cslibrary.stanford.edu/102/PointersAndMemory.pdf
http://www.cs.yale.edu/homes/aspnes/classes/223/notes.html#pointers
https://stackoverflow.com/questions/1190870/i-need-to-generate-random-numbers-in-c

About how much time you spent on this assignment?
I did not keep track of time but it took me a couple of days.

What was the most challenging part of this assignment?
For me it was the print report because I was having a very strange issue with allocating and freeing
data within the program because there are many moving components.

What did you like about this assignment?
I believe this was the best way to learn more about algorithms, arrays, and linkedlist.
It was challenging enough and helped me master these 3 topics. 

How can the assignment be improved?
Part 2 was somewhat confusing. Printing the timer was dificult because I am not sure 
if we went through it in class. Maybe adding a description about how to use the timer
function would have been useful. I would make sure that file such as the operationtest files are taken 
off and to make surethe test file is working with the requested files.



