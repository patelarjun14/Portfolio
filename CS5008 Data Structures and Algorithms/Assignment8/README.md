Name:
Arjun Patel

Description of Directory:
This directory contains code to read a file with multiple threads.

You will find these files in the directory:
1. mt_search.c: This will have the main code that runs everything.
2. example.c: This was an extremely useful file that helped me make the
mt_search.c file.
3. Makefile.c: This is a makefile that helps you run different files quickly.
4. README.md: This is what you are reading right now

How to run it:
After you have downloaded the files, type these in the command prompt:
1. make example: compiles example
2. make run_example: runs example
3. make mt_search: complies mt_search.c
4. make run: Runs inputs/input1.txt with these inputs:
        a. Search number 5
        b. Create 2 threads
        c. Analyze all 10 lines in file
5. make run2: Runs inputs/input2.txt with these inputs:
        a. Search number 3
        b. Create 13 threads
        c. Analyze all 26 lines in file
6. make run3: Runs inputs/input2.txt with these inputs:
        a. Search number 26
        b. Create 50 threads
        c. Analyze all 1000 lines in file

The expected out should tell you what line numbers the number was found on.
However, please note if you enter more threads than number of lines, this will cause an error.
An ideal input should look like:
        ./mt_search inputs/input1.txt 5 2 10
This means we are searching for 5 (integer), 2 threads (not greater than 10), 10 lines. Notice
how if you divide 10/2 (lines/threads) there will be no remainders. If there are remainders, the
program will not run the remainders.

Please take a look at real output below for more information:

Summary:
Some obersations I had about this assignment was how the threads get created,
wait, then linked towards the end. Its great to be able to visually see the
delay in between threads to see how the process works. Also another observation
I had was how pthread_creates() only takes in 1 argument for the function that is entered.
This becomes tricky because originally I was creating a struct to pass through more arguments
but I was lucky to avoid that situation.

How many hours did this assignment take you?
40 hours

Did you collaborate with anyone? Name them.
N/A

Did you use external resources? List them.
https://hpc-tutorials.llnl.gov/posix/passing_args/
http://www.mathcs.emory.edu/~cheung/Courses/355/Syllabus/91-pthreads/common-prog-stru.html
https://courses.engr.illinois.edu/cs241/fa2010/ppt/10-pthread-examples.pdf
https://man7.org/linux/man-pages/man3/pthread_create.3.html



(Optional) What was your favorite part of the assignment?
The best part about this assignment was using threads. I believe
threads are a very useful concept and I will be using these more
often in the future to help process data much more quickly.

(Optional) How would you improve the assignment?
Overall, its a great assignment. I would recommend talking more about
the starter files. At first, I didnt recognize how valuable they were
and then I realized that using global variables was the best way to
tackle this assignment. I would reommend stating to use global variables.


Output (make run):

-bash-4.2$ make run
./mt_search inputs/input1.txt 5 2 10

Information:
Filename: inputs/input1.txt
Number to search for: 5
Number of threads: 2
Number of lines: 10
This is the array: 0 1 2 3 4 5 6 7 8 9
INSDIE MAKE THREADS: 0 1 2 3 4 5 6 7 8 9
About to spawn threads

Starting thread 0

Starting thread 1

THREAD IS WORKING
Thread 0 contains: 0 1 2 3 4

THREAD IS WORKING
Thread 1 contains: 5 6 7 8 9
NUMBER FOUND!

Threads have joined
Search these lines for number: 6,










