//
// Created by ulian on 12/06/19.
//
#include "Triangle.h"
#include <iostream>
#include <cstdio>

using namespace std;

int main() {

    float x1, x2, x3,
          y1, y2, y3;

    cin >> x1;
    cin >> y1;
    cin >> x2;
    cin >> y2;
    cin >> x3;
    cin >> y3;

    Triangle triangle(x1, y1, x2, y2, x3, y3);

    printf("%.5f\n", triangle.getPerimeter());

    return 0;
}
