#include <stdio.h>
#include <stdlib.h>
#include <time.h>


// Prints hollow or filled rectangle
void PrintFancyRectangle(int width, int height, char symbol, int fill) {
        // if user enters 0, this will run hollow rectangle
        if (fill == 0) {
                int c, d;
                // Iterate height
                for (c = 1; c <= height; c++) {
                        // Iterate width
                        for (d = 1; d <= width; d++) {
                                // Conditions for height and width
                                // Height we want to print
                                // symbol on bottom and top
                                // width we want to print in
                                // the start and end
                                if (c == 1 || c == height||
                                   d == 1 || d == width) {
                                        printf("%c", symbol);
                                // Everything else we want empty
                                } else {
                                        printf(" ");
                                }
                        }
                        // Leave space for next line
                        printf("\n");
                }
        }
        // If user enters 1, this will run filled rectangle
        if (fill == 1) {
                int e, f;
                // Iterate height
                for (e = 0; e < height; e++) {
                        // Iterate width
                        for (f = 0; f < width; f++) {
                        // No conditions. Just print symbol
                                printf("%c", symbol);
                        }
                        // Leave space for next line
                        printf("\n");
                }
        }
}

// Run main here. Main will request inputs and functions will create outputs in
// command prompt

char main() {
        int width, height, fill;
        char symbol;
        printf("Enter width: ");
        scanf("%d", &width);


        printf("Enter height: ");
        scanf("%d", &height);

        printf("Enter symbol: ");
        scanf(" %c", &symbol);

        printf("Enter fill: ");
        scanf("%d", &fill);

        PrintFancyRectangle(width, height, symbol, fill);
}






























