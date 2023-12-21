#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <signal.h>
#include <sys/wait.h>
#include <string.h>
#include "LinkedList.c"
#include "LinkedList_easy.h"


#define LINKEDLIST_H
int AnagramChecker(char *str, char *line) {
    int i;
    int x;
    char line2[100];
    strcpy(line2, line);
    // printf("Here is line2 = %s\n",line2);
    int num = 0;
    int lengthofstr = strlen(str) - 1;
    int lengthofline = strlen(line) - 1;

    for (i = 0; i < lengthofstr; i++) {
        // printf("NOW ANALYZING STRING %c\n", str[i]);
        for (x = 0; x < lengthofline; x++) {
            // printf("NOW ANALYZING LINE %c\n",line[x]);
            if (str[i] == line2[x]) {
            num++;
            memmove(&line2[x], &line2[x + 1], lengthofline - x);
            break;
            // printf("STRING %c and LINE %c MATCH\n",str[i],line[x]);
            // printf("Num = %u\n",num);
            }
        }
    }
    // printf("num = %d\n",num);
    // printf("Length = %d\n",length);
    if (num == lengthofstr) {
       // printf("Here is line2 = %s\n",line2);
        // printf("TRUE\n");
        // printf("num = %d\n",num);
        // printf("Length = %d\n",lengthofstr);
        // printf("STRING = %s\n",str);
        // printf("LINE = %s\n",line);


        return 1;
    } else {
        // printf("FALSE\n");
        return 0;
    }
}

// CreateAnagramList: This will create a linked list of anagrams based
// on the input
LinkedListPtr CreateAnagramList(FILE *file, char *str, int length) {
    char line[100];
    LinkedListPtr newlist;
    newlist = CreateLinkedList();
    while (fgets(line, 100, file)) {
        // printf("length of line = %d \n",strlen(line)-1);
        // printf("Here is the line: %s\n",line);
        int lengthOfLine = strlen(line) - 1;
        // printf("FIRST GATE\n");
        if ((lengthOfLine == length)) {
            if (AnagramChecker(str, line) == 1) {
                printf("%s\n", line);
                addLeft(newlist, line);
            }
        }
    }
    fclose(file);
    return newlist;
}

// Checks the hash table to see if value has already
// been entered
int checkHashTable(struct pair hash_table[], char str) {
    int i;
    for (i = 0; i < 100; i++) {
        if (hash_table[i].key == str) {
            printf("THIS HAS ALREADY BEEN STORED:\n");
            printf("%s \t", &hash_table[i].key);
            PrintLinkedList(hash_table[i].value);
            printf("\n");
            return 1;
        }
    }
}

// Creates a hash table
struct pair Create() {
    struct pair hash_table[100];
    return *hash_table;
}


// Destroys a hash key and value
int Destroy(struct pair hash_table[100], int index) {
    int i;
    for (i = 0; i < 100; i++) {
        hash_table[index].key = *"Deleted";
        DestroyLinkedList(hash_table[index].value);
    }
    return 1;
}

// Inserts a hash key and value
void Insert(LinkedListPtr list, char str,
    struct pair hash_table[100], int index) {
    hash_table[index].value = list;
    hash_table[index].key = str;
}

// Gets the value of a key (input)
void Get(struct pair hash_table[100], char str) {
    int i;
    for (i = 0; i < 100; i++) {
        if (hash_table[i].key == str) {
            printf("Here is your hash table:\n");
            printf("%s \t", &hash_table[i].key);
            PrintLinkedList(hash_table[i].value);
            printf("\n");
        }
    }
}

// Prints the entire hash table
void Print(struct pair hash_table[100], int programcount) {
    int i;
    for (i = 0; i < programcount + 1; i++) {
         printf("%s \t", &hash_table[i].key);
         PrintLinkedList(hash_table[i].value);
         printf("\n");
    }
}

// Here we are Testing our functions
void main() {
    // Store variables
    char str[100];
    char line[100];
    struct pair hash_table[100];
    int programcount = 0;
    int option;
    int index = 3;
    Create(hash_table);
    printf("Type in the following values for test\n");
    printf("iceman\n");
    printf("follow\n");
    printf("age\n");
    // Here we are getting inf(information from user)
    while (programcount < 2) {
        // Let user know program has started
        printf("The program has started \n");
        printf("Please select input: \n");
        // Store information
        fgets(str, 100, stdin);
        printf("Here is your input: %s\n", str);
        int length = strlen(str) - 1;
        printf("Length of word is: %u\n", length);
        int count = 0;
        FILE* file = fopen("/home/patelarjun1/a1/Patelarjun1_CS5008SPRING2022/a7/words.txt", "r");
        // Create list of Anagrams
        LinkedListPtr newlist = CreateAnagramList(file, str, length);
        Insert(newlist, *str, hash_table, programcount);
        Print(hash_table, programcount);
        // Test to see if values and linked list work
        if (hash_table[0].key == *"iceman") {
            printf("\nTRUE: Hash Key is correct (iceman)\n");
            if (hash_table[0].value->head->data == *"iceman") {
                printf("TRUE: Hash Value is correct (iceman)\n");
            }
                if (hash_table[0].value->head->next->data == *"cinema") {
                    printf("TRUE: Hash Value is correct (cinema)\n");
                }
                    if (hash_table[0].value->tail->data == *"anemic") {
                        printf("TRUE: Hash Value is correct (anemic)\n");
                        printf("Insert works\n");
                    }
        } else {
            programcount++;
            }
        }
    printf("Testing get function. Enter in iceman\n");
    fgets(str, 100, stdin);
    Get(hash_table, *str);
    printf("We will now delete iceman\n\n");
    Destroy(hash_table, 0);
    Print(hash_table, 3);
}











