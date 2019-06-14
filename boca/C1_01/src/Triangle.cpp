/*
 * Triangle.cpp
 *
 *  Created on: 14 de jun de 2019
 *      Author: ulian
 */

#include "Triangle.h"
#include "GeometricPoint.h"

Triangle::Triangle(double x1, double y1, double x2, double y2, double x3, double y3)
	: p1(x1, y1)
	, p2(x2, y2)
	, p3(x3, y3)
	{ }

double Triangle::getPerimeter() {
	return(p1.getDistanceTo(p2) + p2.getDistanceTo(p3) + p3.getDistanceTo(p1));
}
