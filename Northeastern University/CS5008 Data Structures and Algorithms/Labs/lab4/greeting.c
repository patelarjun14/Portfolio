#include "user.h"
#include <stdio.h>

void StandardGreeting(User*);
void FormalGreeting(User*);



void StandardGreeting(User *user) {
        printf("Hello %s!\n",user->firstName);
}

void FormalGreeting(User *user) {
        printf("Greetings ID: %d\n", user->id);
        printf("Name: %s, %s\n", user->lastName, user->firstName);
}



