/*
 * C1_01.cpp
 *
 *  Created on: 14 de jun de 2019
 *      Author: ulian
 */
#include <iostream>
#include <cstdio>
#include "Triangle.h"

using namespace std;

int main() {
	double x1, x2, x3,
	       y1, y2, y3;
	cin >> x1; cin >> y1;
	cin >> x2; cin >> y2;
	cin >> x3; cin >> y3;

	Triangle t(x1, y1, x2, y2, x3, y3);

	double perimeter = t.getPerimeter();
	printf("%.5f", perimeter);
}




