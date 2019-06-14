/*
 * GeometricPoint.h
 *
 *  Created on: 14 de jun de 2019
 *      Author: ulian
 */

#ifndef GEOMETRICPOINT_H_
#define GEOMETRICPOINT_H_

class GeometricPoint {
	double x;
	double y;
public:
	GeometricPoint(const double&, const double&);
	double getDistanceTo(GeometricPoint);
};

#endif /* GEOMETRICPOINT_H_ */
