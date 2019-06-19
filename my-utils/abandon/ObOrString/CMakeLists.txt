cmake_minimum_required(VERSION 3.14)
project(ObOrString)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(ObOrString
        ObOrString.cpp
        ObOrString.h
        tester.cpp)
