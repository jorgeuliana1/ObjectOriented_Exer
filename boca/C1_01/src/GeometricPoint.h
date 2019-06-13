//
// Created by ulian on 12/06/19.
//

#ifndef C1_01_GEOMETRICPOINT_H
#define C1_01_GEOMETRICPOINT_H

class GeometricPoint {
private:
    double x, y;
public:
    GeometricPoint(const double, const double);
    double distanceTo(const GeometricPoint*);
};


#endif //C1_01_GEOMETRICPOINT_H
