by Arjun Patel

Description of Directory:
This directory contains code to run a hash map that
stores anagrams of specific words. For example, if you
type in "iceman", this program will hold all the anagrams
of "iceman" in a hash map (key= Iceman, Value= list of anagrams)

You will find these files in the directory:
1. MainFinal.c: This will hold functions such as 
	a. AnagramChecker(): Checks to see if a word is an anagram
	b. CreateAnagramList(): Creates a linked list of nodes that 
	store the anagrams
	c. CheckHashTable(): Checks to see if key is within hash table
	d. Create(): Creates a hash table
	e. Destroy(): Destroys value of key and list
	f. Insert(): Inserts a keu and list into hash table
	g. get(): Returns value of key
	h. Print(): Prints the entire hash table
2. LinkedList_easy.h: This is the header file for structs
and summarize helper functions
3. LinkedList.c: This holds all the helper functions such as
	a. CreateLinkedList(): Creates a linked list
	b. addLeft(): Add node to the left side of linked list
	c. DestroyLinkedListNode(): Destroys linked list node
	d. CreateLinkedListNode(): Creates linked list node
	e. PrintLinkedList(): Prints linked list
	g. DestroyLinkedList(): Destroys linked list


Summary of Assigment:
This program runs by taking the input from the user, searching it up in the txt file, and
stores the input as a value and the list of anagrams generated as a list into the hash map.
As the user enters in more data, the hash map will grow. If the user enters in a old input,
the program will get the information from the hash map rather than iterating throught the txt
file.

What Resources Did you use?
https://stackoverflow.com/questions/229012/getting-absolute-path-of-a-file
https://stackoverflow.com/questions/5457608/how-to-remove-the-character-at-a-given-index-from-a-string-in-c
https://www.tutorialspoint.com/data_structures_algorithms/hash_table_program_in_c.htm
https://www.youtube.com/watch?v=1_mnhZ20Vus
https://www.tutorialspoint.com/cprogramming/c_file_io.htm

About how much time did you spend on this assignment
40 hours+

What was the most challenging part of this assignment?
It was creating the hash map because there are many different ways
of creating a hash map and creating a design that makes sense. For example,
you can preload the hash map or create the hash map while the user is entering
in values.

what did you like about the assignment?
I think its a great assignment for learning hash maps and dealing with big data.
So far in the program, this is the largest dataset I have used, which is great
practice.

How can the assignment be improved?
I think giving more guidance could have helped. However, I do like the idea that
there are multiple way of implementing a hash map. 


Note to Grader:
My program would work, however, there are a lot of issues with mallocing and pointers.
The main issue could be with the structs. Also printing out my program is almost impossible
due to the small bugs that are caused by storing memory and pointers. I can only print
out 1 character because printing it as a string causes segmentation issues. Also another issue
in this program is if there are any words that have h in them, for some reason the program will
create a segmentation issue or will not read the data correctly. Please avoid typing in any
words with h to see that the hash map is being generated


Output
The program has started
Please select input:
iceman
Here is your input: iceman

Length of word is: 6
anemic

cinema

iceman

i       i c a
The program has started
Please select input:
create
Here is your input: create

Length of word is: 6
cerate

cetera

create

i       i c a
c       c c c
The program has started
Please select input:
drop
Here is your input: drop

Length of word is: 4
dorp

drop

prod

i       i c a
c       c c c
d       p d d
The program has started
Please select input:
alter
Here is your input: alter

Length of word is: 5
alert

alter

artel

later

ratel

retal

taler

telar

i       i c a
c       c c c
d       p d d
a       t t r r l a a a
