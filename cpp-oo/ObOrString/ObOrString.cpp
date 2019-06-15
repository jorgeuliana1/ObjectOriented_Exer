/*
 * ObOrString.cpp
 *
 *  Created on: 15 de jun de 2019
 *      Author: Jorge Uliana (jorgeuliana1)
 */

#include "ObOrString.h"
#include <iostream>
#include <cstring>

using namespace std;

namespace string_utils {

ObOrString::ObOrString() {
	this->string = NULL;
}

ObOrString::~ObOrString() {
	free(this->string);
}

ObOrString::ObOrString(char* str) {
	setString(str);
}

void ObOrString::operator=(const std::string& str) {
	char* str1 = (char *)malloc((str.length() + 1)*sizeof(char));

	copyConst(str1, str);
	setString(str1);
	free(str1);
}

void ObOrString::operator=(char* str) {
	setString(str);
}

void ObOrString::copyConst(char* destiny, const std::string& origin) {
	for(long unsigned int i = 0; i < origin.length(); i++) {
		destiny[i] = origin[i];
	}
	destiny[origin.length()] = '\0';
}

void ObOrString::setString(char* str) {

	// Removing the pointer data, if it exists.
	if(contains())
		free(this->string);

	// Allocating memory for the string.
	this->string = (char *)malloc((strlen(str) + 1) * sizeof(char));

	// Copying to the string.
	for(unsigned int i = 0; i < strlen(str) + 1; i++) {
		this->string[i] = str[i];
	}

}

char* ObOrString::toString() {
	return this->string;
}

bool ObOrString::contains() {
	if(this->string == NULL)
		return false;
	return true;
}

std::ostream& operator<<(std::ostream& out, ObOrString& str) {
	out << str.toString();
	return out;
}

unsigned long int ObOrString::length() {
	return strlen(this->string);
}

int ObOrString::compareTo(ObOrString& str) {
	return strcmp(this->string, str.string);
}

} /* namespace ObOrString */
