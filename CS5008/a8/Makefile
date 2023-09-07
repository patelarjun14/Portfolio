all: mt_search

example: example.c
	gcc -pthread -o example example.c

run_example: example
	./example

mt_search: mt_search.c
	gcc -pthread -o mt_search mt_search.c

run: mt_search
	./mt_search inputs/input1.txt 5 2 10

run2: mt_search
	./mt_search inputs/input2.txt 3 13 26

run3: mt_search
	./mt_search inputs/nums10000.txt 26 50 1000

clean:
	rm example



