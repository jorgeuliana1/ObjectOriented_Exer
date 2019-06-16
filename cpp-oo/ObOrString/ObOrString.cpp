/*
 * String.cpp
 *
 *  Created on: 15 de jun de 2019
 *      Author: Jorge Uliana (jorgeuliana1)
 */

#include "ObOrString.h"
#include <iostream>
#include <cstring>

using namespace std;

namespace string_utils {

String::String() {
	this->string = NULL;
}

String::~String() {
	free(this->string);
}

String::String(char* str) {
	setString(str);
}

String::String(const char *str) {
	char* temp = (char *)malloc(sizeof(char)*(strlen(str) + 1));
	strcpy(temp, str);
	setString(temp);
	free(temp);
}

void String::operator=(const std::string& str) {
	char* str1 = (char *)malloc((str.length() + 1)*sizeof(char));

	copyConst(str1, str);
	setString(str1);
	free(str1);
}

void String::operator=(char* str) {
	setString(str);
}

void String::operator=(const char* str) {
	char* temp = (char *)malloc(sizeof(char)*(strlen(str) + 1));
	strcpy(temp, str);
	setString(temp);
	free(temp);
}

void String::copyConst(char* destiny, const std::string& origin) {
	for(long unsigned int i = 0; i < origin.length(); i++) {
		destiny[i] = origin[i];
	}
	destiny[origin.length()] = '\0';
}

void String::setString(char* str) {

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

char* String::toString() {
	return this->string;
}

bool String::contains() {
	if(this->string == NULL)
		return false;
	return true;
}

std::ostream& operator<<(std::ostream& out, String& str) {
	out << str.toString();
	return out;
}

unsigned long int String::length() {
	return strlen(this->string);
}

int String::compareTo(String& str) {
	return strcmp(this->string, str.string);
}

bool String::operator==(const String& str) {
	if(strcmp(this->string, str.string) == 0)
		return true;
	else return false; 
}

void String::append(const char& c) {
	if(!contains()) {
		char *temp = (char *)malloc(sizeof(char) * 2);
		temp[1] = '\0';
		temp[0] = c;
		setString(temp);
		free(temp);
		return;
	}

	// Creating a copy of the string.
	String temp = this->string;
	free(this->string);

	this->string = (char *)malloc(sizeof(char) + (temp.length() + 2));
	// One space for the new char and another for the \0.

	strcpy(this->string, temp.string);
	this->string[temp.length()] = c;
	this->string[temp.length() + 1] = '\0';

	// Deleting the temporary string.
	free(temp.string);

}

String String::substring(const unsigned int& s, const unsigned int& f) {

	// If it is out of bounds, return null
	if(length() < f) {
		String empty;
		return empty;
	}

	String str;
	for(int i = s; i <= f; i++) {
		str.append(this->string[i]);
	}

	return str;

}

unsigned int String::countOccurrences(String& text) {
	if(text.length() > this->length())
		return 0;
	else if(text.length() == this->length()) {
		// There is only occurrence if this is text.
		if(this->compareTo(text) == 0) return 1;
		return 0;
	}

	unsigned int size = text.length();
	unsigned int occurrences = 0;

	for(unsigned int i = 0; i < length() - size; i++) {
		// Analyzing every bit of the string.
		String temp = substring(i, i + size);
		if(temp == text)
			occurrences++;
	}

	return occurrences;
}

unsigned int String::countOccurrences(const char* text) {
	String temp = text;
	unsigned int occurrences = countOccurrences(temp);
	free(temp.string);
	return occurrences;
}

} /* namespace String */
