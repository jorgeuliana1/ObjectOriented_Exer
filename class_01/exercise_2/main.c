#include <stdio.h>
#include <string.h>
#include "tAluno.h"

int main(int argc, char ** argv) {
    //Programa testador

    tAluno *aluno;
    aluno = CriaAluno("Joao", 7.8);
    printf("%s\n%.2f\n", NomeAluno(aluno), NotaAluno(aluno));

    //Testes com aluno deletado
    aluno = DeletaAluno(aluno);
    printf("%s\n%.2f\n", NomeAluno(aluno), NotaAluno(aluno));

    return 0;
}