#include<stdio.h>

// CONSTANTS

#define STUDENT 100
#define ZERO 0
#define ONE 1

int main() {
  float marks[STUDENT], sum = ZERO;
  int i;

  for (i = ZERO; i < STUDENT; i++) {
    printf("Enter marks for %d student: ", i+ONE);
    scanf("%f", &marks[i]);
  }

  // calculate sum
     for (i = ZERO; i < STUDENT; i++) {
         sum += marks[i];
           }
             printf("\nAverage marks = %.2f\n", sum/STUDENT);
               // signal to operating system everything works fine
                 return ZERO;
}
