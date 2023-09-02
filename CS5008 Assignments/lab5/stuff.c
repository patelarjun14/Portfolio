/**
 * CS 5008: Spr 2022
 * Northeastern University, Seattle
 * Lab 5: Style and cLint
 * 
 **/
#include <stdio.h>
#include "stuff.h"

const kNumsToAverage = 3;
const ZERO = 0;

void DoStuff() {
  int i;
  int nums[kNumsToAverage];
  for (i = ZERO; i < kNumsToAverage; i++) {
    printf("Enter number %d of %d: ", i, kNumsToAverage);
    scanf("%d", &nums[i]);
  }

  int sum = ZERO;
  for (i = ZERO; i < kNumsToAverage; i++) {
    sum += nums[i];
  }
  printf("The average of the values you entered"
         " is %d, but don't take my word for it.\n",
         sum / kNumsToAverage);

  return;
}





































