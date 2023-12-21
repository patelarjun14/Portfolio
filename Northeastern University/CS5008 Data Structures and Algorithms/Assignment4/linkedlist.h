#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

#ifndef LINKEDLIST_H
#define LINKEDLIST_H



// ======================================================
// LinkedList: A Doubly-Linked List
//=======================================================

// STRUCT DEFINITIONS
//
// We have 2 structs: One is a LinkedListNode, and one is a LinkedListHead,
// which we create an alias for the pointer.
//
// This struct represents an individual node within a linked list.  A node
// contains next and prev pointers as well as a customer-supplied payload
// pointer.

typedef struct ll_node {
  int           data;       // Data this node holds
  struct ll_node *next;     // next node in list, or NULL
  struct ll_node *prev;     // prev node in list, or NULL
} LinkedListNode, *LinkedListNodePtr;



// This struct represents the entire linked list.  We provided a struct
// // declaration (but not definition) in LinkedList.h; this is the associated
// // definition.  This struct contains metadata about the linked list.


typedef struct ll_head {
  uint64_t          num_elements;  //  # elements in the list
  LinkedListNodePtr head;  // head of linked list, or NULL if empty
  LinkedListNodePtr tail;  // tail of linked list, or NULL if empty
} *LinkedListPtr;



LinkedListPtr CreateLinkedList();


int addLeft(LinkedListPtr, int);

int addRight(LinkedListPtr, int);

int removeLeft(LinkedListPtr list);

int removeRight(LinkedListPtr list);

int insertAt(LinkedListPtr, int data, int index);

int hasValue(LinkedListPtr list, int index);

LinkedListNode* CreateLinkedListNode(int data);

int PrintLinkedList(LinkedListPtr list);

void DestroyLinkedList(LinkedListPtr list);

int pushLeft(LinkedListPtr list, int i);

int peekLeft(LinkedListPtr list);

int popLeft(LinkedListPtr list);

int pushRight(LinkedListPtr, int i);

int peekRight(LinkedListPtr list);

int popRight(LinkedListPtr list);




#endif

