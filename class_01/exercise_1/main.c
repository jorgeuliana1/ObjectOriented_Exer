#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define STRSIZ 64
#define true   1

/*
This program receives a text location as argument and prints it in the default output.
If there is no argument, the program must ask for the location.
*/

int main(int argc, char **argv) {
    char *location;

    if(argc <= 1) {

        //If there is no argument.
        char stdin_local[STRSIZ];

        //Asking for input location:
        printf("Please, tell me what is the location of the input file: ");
        scanf("%s", stdin_local);

        //Dinamically alocating string:
        location = (char *)malloc((strlen(stdin_local) + 1)*sizeof(char));
        strcpy(location, stdin_local);

    } else {

        //Dinamically alocating string:
        location = (char *)malloc((strlen(argv[1]) + 1)*sizeof(char));
        strcpy(location, argv[1]);

    }

    //Opening the file:
    FILE *inpFile;
    inpFile = fopen(location, "r");

    //Showing error message in case of invalid path:
    if(!inpFile) {
        printf("Error: Invalid path.\n");
    } else {
        //Printing the content of the file in the standard output:

        char toPrint;

        //Printing the whole file:
        while((toPrint = fgetc(inpFile)) != EOF) {

            printf("%c", toPrint);

        }

    }

    //Freeing memory from heap:
    free(location);

    //Closing the file, if it is open.
    if(inpFile)
        fclose(inpFile);

    return 0;
}