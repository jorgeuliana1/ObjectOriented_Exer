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

	String str;
	str = "Jorge Uliana did it!";
	cout << str << str.length() << endl;
	str = "This is a good string lib!";
	cout << str << endl;
	String str1;
	str1 = "String here";
	cout << str.compareTo(str1) << " String Comparison" << endl;
	cout << str.countOccurrences(" ");

	return 0;
}

