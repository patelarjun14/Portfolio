#include <stdio.h>
#include <stdlib.h>
#include <time.h>


//Define all functions

////Prints Victory 3 times using for loop
void PrintVictory() 
{
	int a;
	for (a=0; a<3;a=a+1) 
	{
		printf("VICTORY!\n");
	}
}

//Prints Victory 3 times using 1 printf()
void PrintVictory_2()
{
	printf(
	"VICTORY!\n"
	"VICTORY!\n"
	"VICTORY!\n");

}


//Run main here. Main will request inputs and functions will create outputs in
//command prompt

char main() {

        PrintVictory();
        PrintVictory_2();

}
