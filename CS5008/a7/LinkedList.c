#include <stdio.h>
#include "LinkedList_easy.h"
#include <stdlib.h>



LinkedListPtr CreateLinkedList() {
    // Memory allocation for list
    // replace linkedlistptr with struct
    LinkedListPtr newlist = (LinkedListPtr)malloc(sizeof(struct ll_head)+10);
    // Set head, tail, and number of elements
    newlist->head = NULL;
    newlist->tail = NULL;
    newlist->num_elements = 0;
    // Check to see if list is null, null if there is an error
    if (newlist == NULL) {
        return NULL;
        // Return a LinkedList
        } else {
            return newlist;
        }
}

int addLeft(LinkedListPtr list, char* line) {
    // Create node
    LinkedListNode* x = CreateLinkedListNode(line);
    // If list head is empty (list is empty) enter in info
    if (list->head == NULL) {
        list->num_elements = 1;
        list->head = x;
        list->tail = x;
        // Return 0 for successful insertion
        return 0;
    // If there are elements, add Node to front of list
    } else if (list->num_elements > 0) {
        list->num_elements++;  // Add one more to element count
        x->next = list->head;  // State that x->next is equal to current head
        list->head->prev = x;  // Current list head prev is now x
        // State that list->head is x
        list->head = x;
        // Return 0 for successful insertion
        return 0;
    } else {
        // Return 1 for failure
            return 1;
    }
}



int DestroyLinkedListNode(LinkedListNode *node) {
    // If node is null, return 1 for unsuccessful (Node is already NULL)
    if (node == NULL) {
        return 1;
    // Else just free node
    } else {
        free(node);
        // Return 0 for successful destroy
        return 0;
    }
    return;
}

LinkedListNode* CreateLinkedListNode(char* line) {
    // Create new node by allocating data
    // change linkedlistnodeptr to struct
    LinkedListNode* x = (LinkedListNode*)malloc(sizeof(struct ll_node));

    // Set data into new node
    x->data= *line;
    // Return node
    return x;
}

int PrintLinkedList(LinkedListPtr list) {
    // Print to prompt to let user know list has been printed
    // If list is NULL, print "EMPTY" to let user know list is empty
    if (list == NULL) {
        printf("EMPTY\n");
        // Return 1 for unsuccesful print
        return 1;
    // If list head is NULL, list must be "EMPTY"
    // Print "EMPTY" to let user know list is empty
    } else if (list->head == NULL) {
        printf("EMPTY\n");
        // Return 1 for unsuccesful print
        return 1;
    // If list has 0 elements, it must be empty
    // Print "EMPTY" and return 1 for failure
    } else if (list->num_elements == 0) {
        printf("EMPTY\n");
        return 1;
    // Else print out the loop
    } else {
        // Use for loop to iterate through list
        // Get length (y) and set it as length
        // position node (x) to go through
        LinkedListNodePtr x = list->head;
        int i;
        for (i = 0; i <list->num_elements; i++) {
            printf("%c ", x->data);
            x = x->next;
        }
            // Return 0 for successful print
            return 0;
    }
}

void DestroyLinkedList(LinkedListPtr list) {
    // Set head and elements
    LinkedListNodePtr x = list->head;
    // If list is null, return nothing
    if (list == NULL) {
        return;
    // If list head is null, return nothing
    } else if (list->head == NULL) {
        return;
    } else if (list->num_elements == 0) {
        return;
    // Else, destroy the loop
    } else {
    // Use for loop to iterate throguh list
        int i;
        for (i = 0; i <list->num_elements; i++) {
            // Destroy each element in list
            DestroyLinkedListNode(x);
            x = x->next;
        }
        // List number of elements as 0
        list->num_elements = 0;
        // Set list to NULL
        list = NULL;
        // Free list
        free(list);
    }
        // Return nothing
        return;
}




