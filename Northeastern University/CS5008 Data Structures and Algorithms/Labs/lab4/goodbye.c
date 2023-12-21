#include "user.h"
#include <stdio.h>


void InformalGoodbye(User*);
void FormalGoodbye(User*);


void InformalGoodbye(User *user) {
        printf("Goodbye %s\n", user->firstName);
}

void FormalGoodbye(User *user) {
        printf("Goodbye ID: %d\n", user->id);
        printf("Name: %s, %s\n", user->lastName, user->firstName);
}

