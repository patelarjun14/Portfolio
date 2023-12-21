/*
 *  This is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  It is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  See <http://www.gnu.org/licenses/>.
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>


#ifndef LINKEDLIST_H
#define LINKEDLIST_H

// This struct represents an individual node within a linked list.  A node
// contains next and prev pointers as well as a customer-supplied payload
// pointer.
typedef struct ll_node {
    char          data;  // Pointer to a string, most likely on the heap
    struct ll_node *next;     // next node in list, or NULL
    struct ll_node *prev;     // prev node in list, or NULL
} LinkedListNode, *LinkedListNodePtr;

// This struct represents the entire linked list.  We provided a struct
// declaration (but not definition) in LinkedList.h; this is the associated
// definition.  This struct contains metadata about the linked list.
typedef struct ll_head {
    uint64_t          num_elements;  //  # elements in the list
    LinkedListNodePtr head;  // head of linked list, or NULL if empty
    LinkedListNodePtr tail;  // tail of linked list, or NULL if empty
} *LinkedListPtr;

// This struct represents the state of an iterator.  We expose the struct
// declaration in LinkedList.h, but not the definition, similar to what we did
// above for the linked list itself.
typedef struct ll_iter {
    LinkedListPtr     list;  // the list we're for
    LinkedListNode key;  // the node we are at, or NULL if broken
} LLIterSt;


// A LinkedList is a pointer to a ll_head struct.
// To hide the implementation of LinkedList, we declare the "struct ll_head"
// structure here, but we *define* the structure in the internal header
// LinkedList_priv.h. This lets us define a pointer to LinkedList as a new
// type while leaving the implementation details opaque to the customer.
typedef struct ll_head *LinkedList;


// Doing the same trick for LLIter that we did for LinkedList
struct ll_iter;
typedef struct ll_iter *LLIter;

struct pair {
    LinkedListPtr value;
    char key;
};



LinkedListPtr CreateLinkedList();

int addLeft(LinkedListPtr, char* line);

LinkedListNode* CreateLinkedListNode(char* line);

int PrintLinkedList(LinkedListPtr list);

void DestroyLinkedList(LinkedListPtr list);







#endif  // LINKEDLIST_H
