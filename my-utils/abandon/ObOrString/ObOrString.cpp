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
    // TODO: Create remove function.
}

String::String(char* str) {
    this->string = NULL;
	setString(str);
}

String::String(const char *str) {
    this->string = NULL;
	char* temp = new char[strlen(str) + 1];
	for(unsigned int i = 0; i <= strlen(str); i++) {
	    temp[i] = str[i];
	}
	setString(temp);
	free(temp);
}

String::String(const String& str) {
    this->string = new char[strlen(str.string) + 1];
    strcpy(this->string, str.string);
}
/*
String& String::operator=(const std::string& str) {
	char* str1 = new char[str.length() + 1];

	copyConst(str1, str);
	setString(str1);
	free(str1);
}

String& String::operator=(char* str) {
	setString(str);
}

String& String::operator=(const char* str) {
	char* temp = new char[strlen(str) + 1];
	strcpy(temp, str);
	*this = temp;
	free(temp);
}

void String::copyConst(char* destiny, const std::string& origin) {
	for(long unsigned int i = 0; i < origin.length(); i++) {
		destiny[i] = origin[i];
	}
	destiny[origin.length()] = '\0';
}
*/
void String::setString(char* str) {

    // Verifying if str isn't null
    if(!str)
        return;

	// Removing the pointer data, if it exists.
    if(this->string)
        delete this->string;

	// Allocating memory for the string.
	this->string = new char[strlen(str) + 1];

	// Copying to the string.
	for(unsigned int i = 0; i < strlen(str) + 1; i++) {
		this->string[i] = str[i];
	}

}
/*
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
	if(strcmp(this->string, str.string))
		return true;
	else return false; 
}

bool String::exists() {
    if(this->string)
        return true;
    return false;
}

void String::append(const char& c) {
	if(!contains()) {
		char *temp = new char[2];
		temp[1] = '\0';
		temp[0] = c;
		setString(temp);
		free(temp);
		return;
	}

	// Creating a copy of the string.
	String temp = this->string;
	delete this->string;

	this->string = new char[temp.length() + 2];
	// One space for the new char and another for the \0.

	strcpy(this->string, temp.string);
	this->string[temp.length()] = c;
	this->string[temp.length() + 1] = '\0';

	// Deleting the temporary string.
	//free(temp.string);

}

String& String::operator+(const char& c) {
    String str = *this;
    str.append(c);
    return str;
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
*/
} /* namespace String */
