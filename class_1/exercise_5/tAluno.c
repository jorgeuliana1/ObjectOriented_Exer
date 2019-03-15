#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "tAluno.h"

struct aluno {
    char *nome;
    float nota;
};

tAluno *CriaAluno(char *nome, float nota) {
    tAluno *novo;

    novo = (tAluno *)malloc(sizeof(tAluno));
    novo->nome = (char *)malloc(sizeof(char)*(strlen(nome) + 1));
    strcpy(novo->nome, nome);
    novo->nota = nota;

    return novo;
}

tAluno *DeletaAluno(tAluno *aluno) {
    if(aluno) {
        if(aluno->nome)
            free(aluno->nome);
        free(aluno);
    }

    return NULL;
}

char *NomeAluno(tAluno *aluno) {
    if(aluno && aluno->nome)
        return aluno->nome;
    return NULL;
}

float NotaAluno(tAluno *aluno) {
    if(aluno)
        return aluno->nota;
    return 0.0;
}