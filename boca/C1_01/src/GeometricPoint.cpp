/*
 * GeometricPoint.cpp
 *
 *  Created on: 14 de jun de 2019
 *      Author: ulian
 */

#include "GeometricPoint.h"
#include <cmath>

GeometricPoint::GeometricPoint(const double& x, const double& y) {
	this->x = x;
	this->y = y;
}

double GeometricPoint::getDistanceTo(GeometricPoint point) {
	double dx, dy;
	dx = point.x - this->x;
	dy = point.y - this->y;

	return sqrt((dx * dx + dy * dy));
}
