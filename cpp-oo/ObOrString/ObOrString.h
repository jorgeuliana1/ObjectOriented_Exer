/*
 * ObOrString.h
 *
 *  Created on: 15 de jun de 2019
 *      Author: Jorge Uliana (jorgeuliana1)
 */

#ifndef OBORSTRING_H_
#define OBORSTRING_H_

#include <iostream>

namespace string_utils {

class String {
	char *string;
	void setString(char *);
	void copyConst(char*, const std::string&);
public:
	String();
	String(char*);
	virtual ~String();
	void operator=(const std::string&);
	void operator=(char*);
	bool contains();
	char* toString();
	unsigned long int length();
	int compareTo(String&);
	unsigned int countOccurrences(String&);
	bool operator==(const String&);
	String substring(const unsigned int&, const unsigned int&);
	void append(const char&);
	void operator=(const char*);
	unsigned int countOccurrences(const char*);
	String(const char*);
};

std::ostream& operator<<(std::ostream&, String&);

} /* namespace String */

#endif /* OBORSTRING_H_ */
