#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>
#include <signal.h>
#define MAXARGS 5
#define MAXLINE 80
#include <sys/wait.h>


// CD: Change Directory
void* cd(char* input) {
    // printf("CD FUNCTION WORKING\n");
     char path[100];
     chdir(input);
     printf("File path: %s\n", getcwd(path, 100));
}

// Help: Lists all commands
void* help() {
    // printf("HELPER FUNCTION WORKING \n");
    printf("Hello. Here are the commands: \n");
    printf("- cd \n- help \n- exit\n- game\n");
}

// Game: Plays a game that makes you guess between 0 and 10
void* game() {
    printf("Guess a number between 0 and 10:\n");
    int random = rand() % 11;
    int guess = 0;
    int n;
    // printf("Random number: %d \n",random);
    while (1) {
        scanf("%d", &n);
        guess++;
        // printf("Number picked is %d\n",n);
        if (n == random) {
            printf("CONGRATS! YOU WIN!\n");
            printf("The number is %d\n", random);
            break;
        } else {
            printf("Didnt guess correctly\n");
            printf("Number was %d\n", random);
            printf("Please run the game again\n");
            break;
     }
  }
}

// Exit: Leave program
void* commandExit(char* input) {
    printf("You have exited the program \n");
    exit(0);
}

// Command names here
void *commands[4] = {"cd", "help", "commandExit", "game"};

// Command function pointers here
void *command_functions[4]= {cd, help, commandExit, game};


/***
 **  Wrapper of fork(). Checks for fork errors, quits on error. 
 **/
pid_t Fork(void) {
    pid_t pid;
    if ((pid = fork()) < 0) {
        fprintf(stderr, "%s: %s\n", "fork error", strerror(errno));
        exit(0);
    }
    return pid;
}

/***
 **  Wrapper of fgets. Checks and quits on Unix error. 
 **/
char* Fgets(char *ptr, int n, FILE *stream) {
    char *rptr;
    if (((rptr = fgets(ptr, n, stream)) == NULL) && ferror(stream)) {
        fprintf(stderr, "%s\n", "fgets error");
        exit(0);
    }
    return rptr;
}

// Is the command one built into the shell?
// That is, that the *shell* has implemented?
// If so, execute it here
int builtin_command(char** argv) {
    // printf("Here is argv: %s\n",argv[0]);
    // printf("Here is argv: %s\n",argv[1]);
    // printf("RUNNING THROUGH 1\n");

    // Check to see if argv has cd
    // Return 0 for true
    if (strcmp(argv[0], "cd") == 0) {
        cd(argv[1]);
        return 0;
    }

    // Check to see if argv has help
    // Return 0 for true
    if (strcmp(argv[0], "help") == 0) {
        help();
        return 0;
    }

    // Check to see if argv has cd
    // Return 0 for true
    if (strcmp(argv[0], "exit") == 0) {
        commandExit(argv[1]);
        return 0;
    }

    // Check to see if argv has cd
    // Return 0 for true
    if (strcmp(argv[0], "game") == 0) {
        game();
        return 0;
    }
    // If argv has none of these commands
    // return 1 for false
    return 1;
}



void eval(char *cmdline) {
    char *argv[MAXARGS+1] = {NULL}; /* Argument list execve() */
    char buf[MAXLINE]; /* Holds modified command line */
    pid_t pid; /* Process id */
    strcpy(buf, cmdline);

    // Split buf into args
    int i = 0;
    int length = 0;
    char *list = strtok(buf, " \n\t");
    while (list != NULL) {
        argv[i++] = list;
        length++;
        list = strtok(NULL, " \n\t");
    }

    // printf("length = %d\n",length);
    // for (i=0; i<length; ++i){
    // printf("Array: %s\n", argv[i]);
    // }
    // printf("Before first gate\n");

    // If argv is NULL, return nothing
    if (argv[0] == NULL) {
    // printf("First Gate accessed");
        return; /* Ignore empty lines */
    }
    // printf("Before second gate\n");

    // If argv has a built in command, run it
    if (builtin_command(argv) ==0) {
        // printf("Second Gate accessed\n");
        return;
    }
    // If argv does not have a built in command,
    // create a fork and run execve
    if (builtin_command(argv) == 1) {
     // printf("NEW COMMAND IS WORKING! 1\n");
        if (Fork() == 0) {
        char file[100] = "/bin/";
        // printf("NEW COMMAND IS WORKING! 2\n");
        int exec = execve(strcat(file, argv[0]), argv, NULL);
            if (exec == -1) {
                printf("Command not found--Did you mean something else?\n");
            }
        exit(1);
        } else {
            // printf("COMMAND HAS TO WAIT\n");
            wait(NULL);
        }
    // If anything else, run error message
    } else {
        printf("Command not found--Did you mean something else?\n");
    }
}

int main() {
  char cmdline[MAXLINE]; /* command line buffer */
  while (1) {
    // Print command prompt
    printf("k-sea-shell> ");
    // Read input from user
    Fgets(cmdline, MAXLINE, stdin);
    // If we get the eof, quit the program/shell
    if (feof(stdin))
      exit(0);

    // Otherwise, evaluate the input and execute.
    // printf("Value of cmdline: %s \n",cmdline);
    eval(cmdline);
  }
}

// compile with gcc -std=gnu99 shell.c -o shell.o
