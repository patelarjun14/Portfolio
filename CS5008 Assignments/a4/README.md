By Arjun Patel

Description of Directory;
This is a directory for assignment 4. Below, I have
created a quick description of each file:

1. linkedlist.h: This is a header file for all the functions
	a. Struct for ll_node: This helps create the attributes of a linked list
	b. Struct for ll_head: This helps create the attributes of a linked list
	
	Part 1
	c. addLeft(): Add node to left side of list
	d. addRight(): Add node to the right side of list
	e. removeLeft(): Remove node from the left side of list
	f. removeRight(): Remove node from the right side of list
	g. insertAt(): Insert at given index
	h. hasValue(): Show data of given index
	
	i: CreateLinkedListNode(): Creates a linked list node
	j: PrintLinkedList(): Print linked list
	k: DestroyLinkedList(): Destroy Linked list
	
	Part 2
	l: pushLeft(): Push node to from left side
	m: peekLeft(): Look at data on left side
	n: popLeft(): Take data out from left side
	o: pushRight(): Push node to from right side
	p: peekRight(): Look at data on right side
	q: popRight(): Take data out from right side
	
	

2. doubly.c: This is a file for creating all functions related to a 
Doubly-Linked List
	Part 1
        a. addLeft(): Add node to left side of list
        b. addRight(): Add node to the right side of list
        c. removeLeft(): Remove node from the left side of list
        d. removeRight(): Remove node from the right side of list
        e. insertAt(): Insert at given index
        f. hasValue(): Show data of given index

        g: CreateLinkedListNode(): Creates a linked list node
        h: PrintLinkedList(): Print linked list
        i: DestroyLinkedList(): Destroy Linked list

3. deque.c: This is a file for creating all functions related to a
Deque
	Part 2
	a: pushLeft(): Push node to from left side
        b: peekLeft(): Look at data on left side
        c: popLeft(): Take data out from left side
        d: pushRight(): Push node to from right side
        e: peekRight(): Look at data on right side
        f: popRight(): Take data out from right side

4. main.c: This is the test to see whether the Doubly-Linked list 
is functioning correctly
5. main2.c: This is the test to see whether the deque functions are working

Summary Write Up:
What I learned from this assignment was more about linked lists and how
deques function. Something new I learned was inserting a node in the list
at a given index. This was the hardest part of the assignment because in order
to index a node, you need to update the node itself as well as the left and right
node. However, after having learned that, linked lists make a lot more sense as 
each node is connected through multiple attributes.



SUMMARY of Assignment:
what resources did you use?
N/A

About how much time did you spend on this assignment?
10 hours or more

What was the most challenging part of this assignment?
For me, it was making sure that I was updating all the linked list
nodes depending on which node I was modifying. For exmaple, if I modified
the first node, I need to update the next node and make that the head and 
change the prev to null. Also using valgrind. Since there are many moving
components its hard to fix every single data leak.

What did you like about this assignment?
It did help reinforce linked lists a lot better because I saw mistakes I made
from assignment 3 and I was able to fix them

How can the assignment be improved?
There isnt much directions or guidance with this homework. A lot can be misinterpreted.
Also I believe recieving homework 3 before this assigment would help students understand 
what they did wrong before doing this assignment. I would also recommend making this 
assignment due after the break as students usually have midterms or other big assignments
due at the start of the break.

Output of main.c
--------------------------------------
Creating linkedList
Here is your linked list:
EMPTY
Using addLeft method and entering in 2
Here is your linked list:
2

Using addLeft method and entering in 3
Here is your linked list:
3
2

Using addRight method and entering in 4
Here is your linked list:
3
2
4

Using addRight method and entering 5
Here is your linked list:
3
2
4
5

4 is number of elements
Using insertAt method and entering 6 at index 3

Here is your linked list:
3
2
4
6
5

Using removeLeft method
Here is your linked list:
2
4
6
5

Using removeRight method
Here is your linked list:
2
4
6

Using addLeft method and entering 7
Here is your linked list:
7
2
4
6

Using addRight method and entering 8
Here is your linked list:
7
2
4
6
8

Using removeAt method and at index 2
Here is your linked list:
7
2
6
8
2

Using hasvalue method and taking a look at index 2

Here is your data: 6

Now we are going to destroy the list
-bash-4.2$
----------------------------------------
Output of main2.c
Now we are going to test Deque functions
Lets start by creating a linkedlist
Here is your linked list:
EMPTY
We are now going to use the pushLeft method (inserting 2)
Here is your linked list:
2

We will use the pushLeft method again (inserting 3)
Here is your linked list:
3
2

We are now going to use the pushRight method (inserting 4)
Here is your linked list:
3
2
4

We will use the pushRight method again (inserting 5)
Here is your linked list:
3
2
4
5

Using peekLeft method
Here is your data: 3

Here is your linked list:
3
2
4
5

Using popLeft method
Here is your data: 3

Here is your linked list:
2
4
5

Using peekRight method
Here is your data: 5

Here is your linked list:
2
4
5

Using popRight method
Here is your data: 5

Here is your linked list:
2
4

Now we are going to destroy the list
-bash-4.2$



