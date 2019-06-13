//
// Created by ulian on 12/06/19.
//

#include "Triangle.h"
#include "GeometricPoint.h"

Triangle::Triangle(const double x1, const double y1, const double x2, const double y2, const double x3, const double y3)
          : p1(x1, y1), p2(x2, y2), p3(x3, y3) { }

double Triangle::getPerimeter() {
    return p1.distanceTo(&p2) + p2.distanceTo(&p3) + p3.distanceTo(&p1);
}