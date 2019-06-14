/*
 * Triangle.h
 *
 *  Created on: 14 de jun de 2019
 *      Author: ulian
 */

#ifndef TRIANGLE_H_
#define TRIANGLE_H_

#include "GeometricPoint.h"

class Triangle {
	GeometricPoint p1;
	GeometricPoint p2;
	GeometricPoint p3;

public:
	Triangle(double, double, double, double, double, double);
	double getPerimeter();
};

#endif /* TRIANGLE_H_ */
