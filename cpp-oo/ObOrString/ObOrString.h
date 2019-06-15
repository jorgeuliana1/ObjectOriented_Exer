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

class ObOrString {
	char *string;
	void setString(char *);
	void copyConst(char*, const std::string&);
public:
	ObOrString();
	ObOrString(char*);
	virtual ~ObOrString();
	void operator=(const std::string&);
	void operator=(char*);
	bool contains();
	char* toString();
	unsigned long int length();
	int compareTo(ObOrString&);
};

std::ostream& operator<<(std::ostream&, ObOrString&);

} /* namespace ObOrString */

#endif /* OBORSTRING_H_ */
