#include <stdio.h>
#include "user.h"


//void StandardGreeting(User*);
//void FormalGreeting(User*);
//void InformalGoodbye(User*);
//void FormalGoodbye(User*);

int main() {
  User user = {"Big", "Lebowski", 42};
  StandardGreeting(&user);
  FormalGreeting(&user);
  InformalGoodbye(&user);
  FormalGoodbye(&user);

  return 0;
}

//void StandardGreeting(User *user) {
//	printf("Hello %s!\n",user->firstName);
//}

//void FormalGreeting(User *user) {
//	printf("Greetings ID: %d\n", user->id);
//	printf("Name: %s, %s\n", user->lastName, user->firstName);
//}

//void InformalGoodbye(User *user) {
//	printf("Goodbye ID: %d\n", user->firstName);
//}

//void FormalGoodbye(User *user) {
//	printf("Goodbye ID: %d\n", user->id);
//	printf("%s, %s\n", user->lastName, user->firstName);
//}

	


