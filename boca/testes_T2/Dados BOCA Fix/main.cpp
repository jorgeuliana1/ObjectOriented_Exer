/*
 * main.cpp
 *
 *  Created on: Jun 25, 2019
 *      Author: vitor
 */

#include <fstream>
#include <iostream>
#include <regex>
#include <stdexcept>
#include <string>
#include <vector>
#include "util/Tokenizer.h"

using namespace std;
using namespace cpp_util;

long parsePositiveLong(string s) {
	try {
		if (regex_match (s, regex("^\\d+"))) return stol(s);
		else return -1;
	}
	catch (exception& e) {
		return -1;
	}
}

int main(int argc, char **argv) {
	ifstream in("/Users/vitor/Temp/boca/br-colsucup-prod-detalhe-bibliografica-2017-2019-02-01-anais.csv");

	string linha;
	if (getline(in, linha));

	int count = 0;
	while(getline(in, linha)) {
		Tokenizer tok(linha, ';');
		vector<string> dados = tok.remaining();
		long inicial = parsePositiveLong(dados[14]);
		long final = parsePositiveLong(dados[13]);

		if (inicial != -1 && final != -1) {
			long tamanho = final - inicial + 1;
			if (tamanho > 0 && tamanho < 2000) count += tamanho;
		}
	}

	cout << "Quantidade de paginas publicadas em anais: " << count << endl;
}
