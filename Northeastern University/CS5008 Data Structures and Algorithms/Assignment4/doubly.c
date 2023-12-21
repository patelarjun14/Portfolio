#include <stdio.h>
#include "linkedlist.h"



LinkedListPtr CreateLinkedList() {
    // Memory allocation for list
    LinkedListPtr newlist = (LinkedListPtr)malloc(sizeof(struct ll_head));
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

int addLeft(LinkedListPtr list, int data) {
    // Create node
    LinkedListNodePtr x = CreateLinkedListNode(data);
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

int addRight(LinkedListPtr list, int data) {
    // Create new node
    LinkedListNodePtr x = CreateLinkedListNode(data);
    // If list head is empty (list is empty) enter in info
    if (list->head == NULL) {
        list->num_elements = 1;
        list->head = x;
        list->tail = x;
        // Return 0 for successful insertion
        return 0;
    // If there are elements add node to end of list
    } else if (list->num_elements > 0) {
        list->num_elements++;  // add one more to element count
        x->prev = list->tail;  // changing current tail next as x
        list->tail->next = x;  // updating x prev as current tail
        list->tail = x;  // Change list tail as x
        // Return 0 for successful insertion
        return 0;
        } else {
            // Return 1 for unsuccessful insertion
            return 1;
            }
}

int removeLeft(LinkedListPtr list) {
    // If list head is empty (list is empty) enter in info
    if (list->head == NULL) {
        // Return 1 for failure
        return 1;
    // If there are elements add Node to front of list
    } else if (list->num_elements > 0) {
        // Store 2nd node as new_head
        LinkedListNodePtr new_head = list->head->next;
        list->head->next->prev = NULL;  // 2nd node is prev is now NULL
        LinkedListNodePtr x = list->head;  // set node (x) as head
        DestroyLinkedListNode(x);  // Destroy head
        list->head = new_head;  // Set new head as next (stored earlier
        list->num_elements--;  // Subtract 1 from element count
        // Return 0 for successful deletion
        return 0;
    } else {
            // Return 1 for failure
            return 1;
        }
            // Return 1 for failure
            return 1;
}

int removeRight(LinkedListPtr list) {
    // If list head is empty (list is empty) enter in info
    if (list->head == NULL) {
    // Return 1 for failure
    return 1;
    // If there are elements add Node to front of list
    } else if (list->num_elements > 0) {
        // store 2nd last as new_tail
        LinkedListNodePtr new_tail = list->tail->prev;
        list->tail->prev->next = NULL;  // 2nd last next is NULL
        LinkedListNodePtr x = list->tail;  // set node (x) as tail
        DestroyLinkedListNode(x);  // Destroy head
        list->tail = new_tail;  // set 2nd last as new tail
        list->num_elements--;  // Subtract 1 from elements
        // Return 0 for successful deletion
        return 0;
        } else {
            // Return 1 for failure
            return 1;
        }
}

int insertAt(LinkedListPtr list, int data, int index) {
    int x;
    LinkedListNodePtr y = list->head;
    int w = list->num_elements;
    LinkedListNodePtr node = CreateLinkedListNode(data);
    // If list is NULL, return 1 for failure
    if (list == NULL) {
        return 1;
    } else if (list->num_elements == 0) {
        return 1;
    // If index is 0, use add left
    } else if (index == 0) {
        addLeft(list, data);
        return 0;
    // If index is at very end, add to the end of list
    } else if (index == (w)) {
        addRight(list, data);
        return 0;
    // If index is right before end, add as 2nd to last
    } else if (index == (w-1)) {
        node->next = list->tail;
        node->prev = list->tail->prev;
        list->tail->prev->next = node;
        list->tail->prev= node;
        list->num_elements++;
    } else {
        x = 0;
        while (y->next != NULL) {
            if (x == index) {
            // Set Current Node
            node->next = y;
            node->prev = y->prev;
            y->prev->next = node;
            y->prev = node;
            // List->num_elements++;
            list->num_elements++;
            break;
        } else {
            y = y->next;
            x++;
        }
        }
    }
}

int removeAt(LinkedListPtr list, int index) {
    int x = 0;
    int w = list->num_elements;
    LinkedListNode* y = list->head;
    // If list is NULL, it will not run
    if (index == 0) {
        removeLeft(list);
        } else if (index == (w-1)) {
            removeRight(list);
        } else {
            while (y->next != NULL) {
                if (x == index) {
                    // Set links before destroying
                    y->prev->next = y->next;
                    y->next->prev = y->prev;
                    DestroyLinkedListNode(y);
                    return 0;
                } else {
                    y = y->next;
                    x++;
                }
            }
                // If list is NULL, return 1 for failure
                return 1;
        }
}

int hasValue(LinkedListPtr list, int index) {
    int x = 0;
    int w;
    LinkedListNode* y = list->head;
    w = list->num_elements;
    // If list is null, it will not run
    if (index == (w-1)) {
        printf("\nHere is your data: %d\n", list->tail->data);
        return 0;
    }
    while (y->next != NULL) {
        if (x == index) {
            printf("\nHere is your data: %d\n", y->data);
            return 0;
        } else {
            y = y->next;
            x++;
        }
    }
    // Return 1 or failure
    return 1;
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

LinkedListNode* CreateLinkedListNode(int newnode) {
    // Create new node by allocating data
    LinkedListNodePtr x = (LinkedListNodePtr)malloc(sizeof(LinkedListNode));
    // Set data into new node
    x->data = newnode;
    // Return node
    return x;
}
int PrintLinkedList(LinkedListPtr list) {
    // Print to prompt to let user know list has been printed
    printf("Here is your linked list: \n");
    // If list is NULL, print "EMPTY" to let user know list is empty
    if (list == NULL) {
        printf("EMPTY");
        // Return 1 for unsuccesful print
        return 1;
    // If list head is NULL, list must be "EMPTY"
    // Print "EMPTY" to let user know list is empty
    } else if (list->head == NULL) {
        printf("EMPTY");
        // Return 1 for unsuccesful print
        return 1;
    // If list has 0 elements, it must be empty
    // Print "EMPTY" and return 1 for failure
    } else if (list->num_elements == 0) {
        printf("EMPTY");
        return 1;
    // Else print out the loop
    } else {
        // Use for loop to iterate through list
        // Get length (y) and set it as length
        // position node (x) to go through
        LinkedListNodePtr x = list->head;
        int i;
        for (i = 0; i <list->num_elements; i++) {
            printf("%d \n", x->data);
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
