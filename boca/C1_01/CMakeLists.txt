cmake_minimum_required(VERSION 3.12)
project(C1_01)

set(CMAKE_CXX_STANDARD 14)

include_directories(src)

add_executable(C1_01
        src/C1_01.cpp
        src/GeometricPoint.cpp
        src/GeometricPoint.h
        src/Triangle.cpp
        src/Triangle.h)
