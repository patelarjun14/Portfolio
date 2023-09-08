#include <stdio.h>
#include "linkedlist.h"



int pushLeft(LinkedListPtr list, int i) {
    addLeft(list, i);
}

int peekLeft(LinkedListPtr list) {
    hasValue(list, 0);
}

int popLeft(LinkedListPtr list) {
    hasValue(list, 0);
    removeLeft(list);
}

int pushRight(LinkedListPtr list, int i) {
    addRight(list, i);
}

int peekRight(LinkedListPtr list) {
    int x;
    x = list->num_elements - 1;
    hasValue(list, x);
}

int popRight(LinkedListPtr list) {
    int x;
    x = list->num_elements -1;
    hasValue(list, x);
    removeRight(list);
}






