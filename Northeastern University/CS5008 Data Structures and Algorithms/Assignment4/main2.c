#include <stdio.h>
#include <stdlib.h>
#include "linkedlist.h"

int main() {
        printf("Now we are going to test Deque functions \n");
        printf("Lets start by creating a linkedlist");
        LinkedListPtr y = CreateLinkedList();
        printf("\n");
        PrintLinkedList(y);
        printf("\n");

        printf("We are now going to use the pushLeft method (inserting 2) \n");
        pushLeft(y, 2);
        PrintLinkedList(y);
        printf("\n");

        printf("We will use the pushLeft method again (inserting 3) \n");
        pushLeft(y, 3);
        PrintLinkedList(y);
        printf("\n");

        printf("We are now going to use the pushRight method (inserting 4) \n");
        pushRight(y, 4);
        PrintLinkedList(y);
        printf("\n");

        printf("We will use the pushRight method again (inserting 5) \n");
        pushRight(y, 5);
        PrintLinkedList(y);
        printf("\n");

        printf("Using peekLeft method");
        peekLeft(y);
        printf("\n");
        PrintLinkedList(y);
        printf("\n");

        printf("Using popLeft method");
        popLeft(y);
        printf("\n");
        PrintLinkedList(y);
        printf("\n");

        printf("Using peekRight method");
        peekRight(y);
        printf("\n");
        PrintLinkedList(y);
        printf("\n");

        printf("Using popRight method");
        popRight(y);
        printf("\n");
        PrintLinkedList(y);
        printf("\n");

        printf("Now we are going to destroy the list");
        DestroyLinkedList(y);
        printf("\n");
}
