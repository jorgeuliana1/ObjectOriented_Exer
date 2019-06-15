/*
 * tester.cpp
 *
 *  Created on: 15 de jun de 2019
 *      Author: Jorge Uliana (jorgeuliana1)
 */
#include <iostream>
#include "ObOrString.h"

using namespace std;
using namespace string_utils;

int main() {

	ObOrString str;
	str = (const string&)"Jorge Uliana did it!";
	cout << str << str.length() << endl;
	str = (const string&)"This is a good string lib!";
	cout << str << endl;
	ObOrString str1;
	str1 = (const string&)"String here";
	cout << str.compareTo(str1) << " String Comparison" << endl;

	return 0;
}

