#include <string.h>
#include <stdio.h>




int main() {
    char character[80];
    char *argv[5];
    printf("Enter your line\n");
    fgets(character, sizeof character, stdin);

    char *line = strtok(character," ");

    int count = 0;
    while(line != NULL){
        printf("%s \n", line);
        argv[count] = line;
        count++;
        line = strtok(NULL, " ");
    }

    for(int i=0; i<count;i++){
        printf("Array: %s\n", argv[i]);
    }
    printf("My command is the first: %s\n",argv[0]);
    printf("My executable is the second: %s\n",argv[1]);
    return 0;
}



// compile with gcc -std=gnu99 parse.c -o parse.o




// https://www.codingame.com/playgrounds/14213/how-to-play-with-strings-in-c/string-split
// https://stackoverflow.com/questions/46821605/how-to-seperate-user-input-word-delimiter-as-space-using-strtok
