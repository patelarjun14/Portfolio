create: LinkedList_easy.h MainFinal.c
	gcc -g MainFinal.c LinkedList_easy.h -o program

createtest: LinkedList.c LinkedList_easy.h maintest.c
	gcc -g maintest.c LinkedList.c -o maintest

run: program
	./program

test: maintest
	./maintest


clean: 
	rm program *.~
	rm maintest*.~
