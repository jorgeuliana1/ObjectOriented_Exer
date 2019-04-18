#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "tAluno.h"

#define STRSIZ 64
#define VCTSIZ 64
#define true   1

tAluno **LeAlunos(FILE *f);
void ImprimeAlunos(tAluno **vetorDeAlunos, int numElems);
tAluno **DeletaAlunos(tAluno **vetorDeAlunos, int numElems);
void ImprimeAlunosAcima(tAluno **vetorDeAlunos, int numElems);

//I am sorry.
int numElementos;

int main(int argc, char **argv) {
    char *location;

    if(argc <= 1) {

        char stdin_local[STRSIZ];

        printf("Please, tell me what is the location of the input file: ");
        scanf("%s", stdin_local);

        location = (char *)malloc((strlen(stdin_local) + 1)*sizeof(char));
        strcpy(location, stdin_local);

    } else {

        location = (char *)malloc((strlen(argv[1]) + 1)*sizeof(char));
        strcpy(location, argv[1]);

    }

    FILE *inpFile;
    inpFile = fopen(location, "r");

    if(!inpFile) {
        printf("Error: Invalid path.\n");
    } else {

        tAluno **vetorDeAlunos = LeAlunos(inpFile);
        //Imprimindo os alunos acima da media:
        ImprimeAlunosAcima(vetorDeAlunos, numElementos);
        
        DeletaAlunos(vetorDeAlunos, numElementos);

    }

    free(location);

    if(inpFile)
        fclose(inpFile);

    return 0;
}

tAluno **LeAlunos(FILE *f) {
    tAluno *vetorDeAlunosTemp[VCTSIZ];

    int i;
    char nome[STRSIZ];
    float nota;
    
    for(i = 0; i < VCTSIZ; i++) {
        fscanf(f, "%s %f", nome, &nota);

        vetorDeAlunosTemp[i] = CriaAluno(nome, nota);

        if(fgetc(f) == EOF)
            break;
    }
    
    tAluno **vetorDeAlunos;
    vetorDeAlunos = (tAluno **)malloc(sizeof(tAluno *)*i);

    int j;
    
    for(j = 0; j < i; j++) {
        vetorDeAlunos[j] = vetorDeAlunosTemp[j];
    }

    numElementos = i;
    return vetorDeAlunos;
}

void ImprimeAlunos(tAluno **vetorDeAlunos, int numElems) {
    int i;

    for(i = 0; i < numElems; i++)
        printf("O aluno %s tirou a nota %.1f\n", NomeAluno(vetorDeAlunos[i]), NotaAluno(vetorDeAlunos[i]));
    
    return;
} 

tAluno **DeletaAlunos(tAluno **vetorDeAlunos, int numElems) {
    int i;

    for(i = numElems - 1; i >= 0; i--)
        DeletaAluno(vetorDeAlunos[i]);

    free(vetorDeAlunos);
    
    return NULL;
}

float _CalculaMedia(tAluno **vetorDeAlunos, int numElems) {
    int i;
    float soma;
    //Somando todos os elementos:
    soma = 0;
    for(i = 0; i < numElems; i++) {
        soma += NotaAluno(vetorDeAlunos[i]);
    }

    //Divindo:
    
    return soma/numElems;
}

void ImprimeAlunosAcima(tAluno **vetorDeAlunos, int numElems) {
    int i;

    float media = _CalculaMedia(vetorDeAlunos, numElems);

    for(i = 0; i < numElems; i++)
        if(NotaAluno(vetorDeAlunos[i]) > media)
            printf("O aluno %s tirou a nota %.1f\n", NomeAluno(vetorDeAlunos[i]), NotaAluno(vetorDeAlunos[i]));
    
    return;
} 