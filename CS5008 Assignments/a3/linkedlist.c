#include <stdio.h>
#include "linkedlist.h"



// Creates a LinkedList.
// The customer is responsible for calling DestroyLinkedList()
// to destroy the LinkedList when done.
//
// Returns a LinkedList; NULL if there's an error.

LinkedListPtr CreateLinkedList(){

	// Memory allocation for list
	LinkedListPtr newlist = (LinkedListPtr)malloc(sizeof(struct ll_head));

	// Set head, tail, and number of elements
	newlist->head = NULL;
	newlist->tail = NULL;
	newlist->num_elements = 0;
	
	// Check to see if list is null, null if there is an error
	if(newlist == NULL){
		return NULL;
	}

        // Return a LinkedList
	else{
		return newlist;
	}
}


// Destroys a LinkedList.
// All structs associated with a LinkedList will be
// released and freed.
// 
// INPUT: A pointer to a LinkedList.

void DestroyLinkedList(LinkedListPtr list) {

	// Set head and elements
	LinkedListNodePtr x = list->head;
	LinkedListPtr y = list->num_elements;
	
	// If list is null, return nothing
	if(list == NULL) {
		return;
	}

	// If list head is null, return nothing
	else if(list->head == NULL) {
		return;
	}
	// Else, destroy the loop
	else {

		// Use for loop to iterate throguh list
		int length = y;
		int i;
		for (i=0; i <length; i++){

			// Destroy each element in list
			DestroyLinkedListNode(x);
			x = x->next;
		}
		// Free list
		free(list);

		// Set list to NULL
		list=NULL;	
		
		}
	// Return nothing
	return;

}


// Returns the number of elements in the linked list.
//
// INPUT: A LinkedList
//
// Returns the number of elements in the list.

unsigned int NumElementsInLinkedList(LinkedListPtr list){

	// Check to see if list is null, return NULL
	if(list == NULL) {
		return NULL;
	}

	// Check to see if list head is null, return null
	else if(list->head ==NULL) {
		return NULL;
	}

	else {	

		// Just use attribute to pull length	
		return list-> num_elements;	
	}
	//Return 0 if something went wrong (nothing in list)
	return 0;
}



// Adds an element to the head of a LinkedList, with the given value
//
// INPUT: A pointer to the LinkedList that will be added to,
// INPUT: A value for a node in the linkedList.
//
// Returns 0 if the insertion was successful; non-zero for failure.

int InsertLinkedList(LinkedListPtr list, int data_new)
{
	// Create node
	LinkedListNodePtr x = CreateLinkedListNode(data_new);
	
	// If list head is empty (list is empty) enter in info
	if(list->head == NULL) {
		list->num_elements = 1;
		list->head = x;
		list->tail = x;

		// Return 0 for successful insertion
		return 0;
	}
	// If there are elements add Node to front of list
	else if(list->num_elements > 0){
		list->num_elements++; //add one more to element count
		x->next = list->head; //current list head is now 2nd in line
		list->head = x; //list head is now equal to new node
		
		// Return 0 for successful insertion
		return 0;
	}
	else{
		// Return 1 for failure
		return 1;
	}
}


// Adds an element to the tail of a LinkedList, with the given value.
//
// INPUT: A pointer to the LinkedList that will be added to,
// INPUT: A value for a node in the linkedList.
//
// Returns 0 if the insertion was successful; non-zero for failure.

int AppendLinkedList(LinkedListPtr list, int data_new) 
{

	// Create new node
        LinkedListNodePtr x = CreateLinkedListNode(data_new);
        
	// If list head is empty (list is empty) enter in info
	if(list->head == NULL) {
                list->num_elements = 1;
                list->head = x;
                list->tail = x;

		//Return 0 for successful insertion
		return 0;
        }
	// If there are elements add node to end of list
        else if(list->num_elements > 0) {
                list->num_elements++; // add one more to element count
		list->tail->next = x; // add node behind tail
                x->prev = list->tail; // change tail as the previous to new node
		list->tail = x; // set node as new tail

		// Return 0 for successful insertion
		return 0;

        }
	else{
		// Return 1 for unsuccessful insertion
        	return 1;
	}

}

// Prints out the given LinkedListPtr.
//
// INPUT: A pointer to the LinkedList that will be printed out.
//
// Returns 0 if the insertion was successful; non-zero for failure.

int PrintLinkedList(LinkedListPtr list){

	// Print to prompt to let user know list has been printed
	printf("Here is your linked list: \n");
	
	// If list is NULL, print "EMPTY" to let user know list is empty
	if(list == NULL) {
		printf("EMPTY");
		// Return 1 for unsuccesful print
		return 1;
	}
	// If list head is NULL, list must be "EMPTY"
	// Print "EMPTY" to let user know list is empty
	else if(list->head == NULL) {
		printf("EMPTY");
		// Return 1 for unsuccesful print
		return 1;
	}
	// Else print out the loop
	else{

	// Use for loop to iterate through list
	// Get length (y) and set it as length
	// position node (x) to go through
	LinkedListNodePtr x = list->head;
	LinkedListPtr y = list->num_elements;
	int length = y;
	int i;
	for (i = 0; i <length; i++){
		printf("%d \n", x->data);
		x = x->next;
	}
		// Return 0 for successful print
		return 0;
	}


}


// Creates a LinkedListNode by malloc'ing the space.
//
// INPUT: A pointer that the payload of the returned LLNode will point to.
//
// Returns a pointer to the new LinkedListNode.

LinkedListNode* CreateLinkedListNode(int newnode)
{
	// Create new node by allocating data
	LinkedListNodePtr x = (LinkedListNodePtr)malloc(sizeof(LinkedListNode));
	
	// Set data into new node
	x->data = newnode;
	
	// Return node
	return x;

}

// Destroys and free's a provided LLNode.
//
// INPUT: A pointer to the node to destroy.
//
// Returns 0 if the destroy was successful.

int DestroyLinkedListNode(LinkedListNode *node){

	// If node is null, return 1 for unsuccessful (Node is already NULL)
	if(node == NULL) {
		return 1;
	}
	// Else just free node
	else{
		free(node);
		//return 0 for successful destroy
		return 0;
	}
	return;
}

	

// Removes a given element from a linkedList.
//
// INPUT: A pointer to a linked list.
// INPUT: A ListNodePtr that points to a LLNode to be removed from the list.
//
// Returns 0 if the destroy was successful
// (primarily that the provide Ptr is in the list and could be free'd).

int RemoveLLELem(LinkedListPtr list, LinkedListNodePtr ptr){
	// Set x as head and get number of elements
	LinkedListNodePtr x = list->head;
	LinkedListPtr y = list->num_elements;
	
	// If list is empty, return nothing
	// Return 1 for unsuccessful (Node head is NULL or list is empty)
	if(list->head == NULL) {
		return 1;
	}
	
	// If head of list is equal to point data, remove element
	else if(x = ptr){
		DestroyLinkedListNode(x);

		// Return 0 for successful destroy
		return 0;
	}
	else{
		// Iterate through entire list
		// Destroy the specific node
		int length = y;
		int i;
	
		for (i = 0; i <length; i++){
			if(x = ptr){
				DestroyLinkedListNode(x);
				x = x->next;
			}
			else{
				x=x->next;
			}	
		}
		// Return 0 for successful
		return 0;	
	}
}
//look into the return for this
	
// Run Main here:
//int main() {
//
//        LinkedListPtr x = CreateLinkedList();
//        InsertLinkedList(x,2);
//	InsertLinkedList(x,3);
//	InsertLinkedList(x,4);
//	AppendLinkedList(x,20);
//	NumElementsInLinkedList(x);
//	//DestroyLinkedList(x);
//	PrintLinkedList(x);
//}


