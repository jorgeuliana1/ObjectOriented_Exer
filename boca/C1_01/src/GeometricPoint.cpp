//
// Created by ulian on 12/06/19.
//

#include "GeometricPoint.h"
#include <cmath>

 GeometricPoint::GeometricPoint(const double x, const double y) {
    this->x = x;
    this->y = y;
}

double GeometricPoint::distanceTo(const GeometricPoint* p) {
    float dx, dy;

    dx = this->x - p->x;
    dy = this->y - p->y;

    return sqrt(dx * dx + dy * dy);
}