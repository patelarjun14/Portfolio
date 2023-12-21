ort: sort.h sort.c linkedlist.c  main.c
	gcc -g main.c sort.c linkedlist.c -o sort

test: linkedlist.c main.c maintest.c
	gcc -g maintest.c linkedlist.c -o maintest

run: sort
	./sort

clean: 
	rm sort *.~
