#ifndef TALUNO_H
#define TALUNO_H

typedef struct aluno tAluno;

tAluno *CriaAluno(char *nome, float nota);
tAluno *DeletaAluno(tAluno *aluno);
char *NomeAluno(tAluno *aluno);
float NotaAluno(tAluno *aluno);

#endif