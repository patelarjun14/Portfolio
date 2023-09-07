#include <stdio.h>
#include <stdlib.h>
#include "sort.h"
#include "linkedlist.h"

//include "sort.c"
//#include "linkedlist.c"
typedef struct AList{
        int* list;
        int length;
}AList, *AListPtr;


int main() {
	printf("Checking Selection Sort \n");
	LinkedListPtr x = CreateLinkedList();
	int i = 0;
	while(i < 50) {
		int y = random() % 100 + 1;
		AppendLinkedList(x,y);
		i++;
	}
	
	PrintLinkedList(x);
	Sort(x);
	PrintLinkedList(x);
	DestroyLinkedList(x);
	
	printf("__________________________________________________________ \n");

	printf("Checking Quick Sort \n");
	AList* alist=create(0);
	i=0;
       	while(i < 50) {
                int y = random() % 100 + 1;
		add(alist,y);
                i++;
        }
	printf("Here is the original list: ");
	printAll(alist);
	printf("Here is the new list:      ");
        quicksort(alist, 0, alist->length - 1);
	printAll(alist);


 	free(alist->list);
  	free(alist);
        printf("__________________________________________________________ \n");

	printf("Checking all Linked List Functions \n");
	printf("Created a linked list \n");
	LinkedListPtr newlist = CreateLinkedList();
	int z = NumElementsInLinkedList(newlist);
	printf("There is %d elements in new list \n", z);
	printf("We are going to insert new element (1) \n");
	InsertLinkedList(newlist,1);
        int w = NumElementsInLinkedList(newlist);
        printf("There is %d element in new list \n",w);
	printf("We are going to appened another element (2) \n");
	AppendLinkedList(newlist,2);
	int n = NumElementsInLinkedList(newlist);
        printf("There is %d elements in new list \n",n);
	printf("We are going to insert another element (3) \n");
	InsertLinkedList(newlist,3);
	PrintLinkedList(newlist);
	printf("We are going to append elements (3), (4), (3) \n");
	AppendLinkedList(newlist,3);
	AppendLinkedList(newlist,4);
	AppendLinkedList(newlist,3);
	PrintLinkedList(newlist);
	printf("We are going to remove the third node \n");
	RemoveLLELem(newlist,newlist->head->next->next);
	PrintLinkedList(newlist);
	printf("We are going to destroy this linked list \n");
	DestroyLinkedList(newlist);
	PrintLinkedList(newlist);


	
	

} 

//	a. CreateLinkedList(): Creates a linked list (tested)
//      b. DestroyLinkedList(): This function destroys a linked list (tested)
//      c. NumElemntsInLinkedList(): Reutnrs number of elements in linked list (tested)
//      d. InsertLinkedList(): Adds an element to the head of a linked list (tested)
//      e. AppendLinkedList(): Adds an element to the tail of a linked list (tested)
//      f. PrintLinkedList(): Prints linked list (tested)
//      g. CreateLinkedListNode(): Creates a new linked list node (tested)
//      h. DestroyLinkedListNode(): Destroys a linked list node (tested)
//      i. RemoveLLElem(): Removes an element in linked list (tested)

















