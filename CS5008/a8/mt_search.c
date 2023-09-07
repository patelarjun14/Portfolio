#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <pthread.h>
#include <unistd.h>
#include <semaphore.h>

#include <string.h>
sem_t semaphore;


// ****************************
// This code is provided as an *optional* framework to use to
// write your multi-threaded search code for Assignment A8.
//
// Feel free to change anything you want to in this.
// ****************************


// ===================================================
// Global Variables
// ===================================================

#define MAX_NUM_RESULTS 100
// int num_data_points;
int section_size;

// Array of numbers to search
int* data;

// Array to store line numbers
int* data_store_line[100];

// Global Counter
int global_counter;


// Number to be found
int target;

// Array of indices of target number
// int results[MAX_NUM_RESULTS];
// Number of results we have so far
int num_results = 0;

// int next_value_to_print = 0;

// Used for synchronization.
// I encourage you to rename this something more meaningful.
// pthread_mutex_t lock;
// sem_t semaphore;

// All the threads (an array)
// pthread_t* threads;

// ===================================================
// Functions
// ===================================================

// The function that each thread will run
// to look for the target value in the array.
// The argument provided is a pointer to the array
// where this thread should start looking for the target.
// (This can be either the index OR the address. Your choice.)
// Each thread will look at a max of section_size elements.
void *DoSearch(void *arg) {
    int indent = *(int *)arg;

    int starting = indent*section_size;

    while (1) {
        sleep(1);
        sem_wait(&semaphore);
        if (num_results == indent) {
            break;
        }
        sem_post(&semaphore);
    }

    // printf("START = %d", start);
    printf("\nTHREAD IS WORKING\n");
    printf("Thread %d contains: ", indent);
    int z;
    for (z = 0; z < section_size; z++) {
        printf("%d ", data[starting+z]);
    }
    printf("\n");
    for (z = 0; z < section_size; z++) {
        if (data[starting + z] == target) {
            printf("NUMBER FOUND!\n");
            int linenumber = starting + z + 1;
            data_store_line[global_counter] = linenumber;
            global_counter++;
        }
    }
    num_results++;
    sem_post(&semaphore);
}


// Creates all the threads and starts them running.
// Makes sure the thread IDs are stored in the global threads array.
void MakeThreads(int num_threads) {
    // sem_init(&semaphore, 0, 1);
    pthread_t thread_id[num_threads];
    int args[num_threads];
    int i;
    int y;

    printf("\nINSDIE MAKE THREADS: ");
    for (i = 0; i < 10; i++) {
        printf("%d ", data[i]);
    }

    y = 0;
    printf("\nAbout to spawn threads\n");
    for (i = 0; i < num_threads; i++) {
        printf("\nStarting thread %d \n", i);
        args[i] = i;
        pthread_create(&thread_id[i], NULL, DoSearch, &args[i]);
    }
    for (i = 0; i < num_threads; i++) {
        pthread_join(thread_id[i], NULL);
    }
    printf("\nThreads have joined\n");
}

// Opens the file called filename.
// Reads line by line, adding each number to the
// global data array.
int ReadFile(char* filename) {
    char line[100];
    FILE* file = fopen(filename, "r");

    while (fgets(line, sizeof line, file)) {
        printf("%s", line);
    }
    fclose(file);
}


int main(int num_args, char* args[]) {
    char line[100];
    int counter;

    char* filename = args[1];
    target = atoi(args[2]);
    int number_of_threads = atoi(args[3]);
    int number_of_lines = atoi(args[4]);

    printf("\nInformation: \n");
    printf("Filename: %s\n", filename);
    printf("Number to search for: %d\n", target);
    printf("Number of threads: %d\n", number_of_threads);
    printf("Number of lines: %d\n", number_of_lines);
    sem_init(&semaphore, 0, 1);

    int array[number_of_lines];

    // printf("\nWe are going to read the file: \n");
    // ReadFile(filename);

    section_size = number_of_lines / number_of_threads;

    FILE* file = fopen(filename, "r");
    counter = 0;
    while (fgets(line, sizeof line, file)) {
        // printf("This is the line %s\n", line);
        array[counter] = atoi(line);
        counter++;
    }
    fclose(file);
    data = array;

    int i;
    printf("This is the array: ");
    for (i = 0; i < number_of_lines; i++) {
        printf("%d ", data[i]);
    }

    MakeThreads(number_of_threads);

    printf("Search these lines for number: ");
    for (i = 0; i < global_counter; i++) {
        printf("%d, ", data_store_line[i]);
    }
    printf("\n");
    sem_destroy(&semaphore);
    exit(0);
}


