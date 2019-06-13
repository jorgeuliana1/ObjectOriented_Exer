//
// Created by ulian on 12/06/19.
//

#include "GeometricPoint.h"

#ifndef C1_01_TRIANGLE_H
#define C1_01_TRIANGLE_H


class Triangle {
private:
    GeometricPoint p1, p2, p3;
public:
    Triangle(const double, const double, const double, const double, const double, const double);
    double getPerimeter();
};


#endif //C1_01_TRIANGLE_H
