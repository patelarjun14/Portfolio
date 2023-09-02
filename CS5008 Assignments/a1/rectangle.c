#include <stdio.h>
#include <stdlib.h>
#include <time.h>

//Prints hollow Rectangle

void PrintRectangle(int width, int height)
{
        int a, b;
 
        //Iterate height
        for (a=1; a<=height; a++)
        {
                //Iterate width
                for (b=1; b<=width; b++)
                {
                        //Conditions for height and width
                        //Height we want to print "-" on bottom and top
                        //Width we want to print in the start and end                                               
                        if(a==1 || a==height || b==1 || b==width)
                        {
                                printf("-");
                        }
                        //Everything else we want empty
                        else
                        {
                                printf(" ");
                        }
                }
                //Leave space for next line
                printf("\n");
        }

}





//Run main here. Main will request inputs and functions will create outputs in
////command prompt

char main() 
{
        int width, height;
        printf("Enter width: ");
        scanf("%d",&width);

        printf("Enter height: ");
        scanf("%d",&height);

        PrintRectangle(width, height);
}


