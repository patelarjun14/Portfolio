#include <stdio.h>
#include <stdlib.h>
#include "linkedlist.h"


int main() {
    printf("Creating linkedList \n");
    LinkedListPtr x = CreateLinkedList();
    PrintLinkedList(x);
    printf("\n");
    printf("Using addLeft method and entering in 2 \n");
    addLeft(x, 2);
    PrintLinkedList(x);
    printf("\n");
    printf("Using addLeft method and entering in 3 \n");
    addLeft(x, 3);
    PrintLinkedList(x);
    printf("\n");
    printf("Using addRight method and entering in 4 \n");
    addRight(x, 4);
    PrintLinkedList(x);
    printf("\n");
    printf("Using addRight method and entering 5 \n");
    addRight(x, 5);
    PrintLinkedList(x);
    printf("\n");
    printf("%d is number of elements\n", x->num_elements);
    printf("Using insertAt method and entering 6 at index 3\n");
    insertAt(x, 6, 3);
    printf("\n");
    PrintLinkedList(x);
    printf("\n");
    printf("Using removeLeft method \n");
    removeLeft(x);
    PrintLinkedList(x);
    printf("\n");
    printf("Using removeRight method \n");
    removeRight(x);
    PrintLinkedList(x);
    printf("\n");
    printf("Using addLeft method and entering 7 \n");
    addLeft(x, 7);
    PrintLinkedList(x);
    printf("\n");
    printf("Using addRight method and entering 8 \n");
    addRight(x, 8);
    PrintLinkedList(x);
    printf("\n");
    printf("Using removeAt method and at index 2 \n");
    removeAt(x, 2);
    PrintLinkedList(x);
    printf("\n");
    printf("Using hasvalue method and taking a look at index 2 \n");
    hasValue(x, 2);
    printf("\n");
    printf("Now we are going to destroy the list");
    DestroyLinkedList(x);
    printf("\n");
}













