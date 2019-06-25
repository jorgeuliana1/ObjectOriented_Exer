cmake_minimum_required(VERSION 3.14)
project(C1_02)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(C1_02
        C1_02.cpp
        Company.cpp
        Company.h
        DateUtils.cpp
        DateUtils.h
        Department.cpp
        Department.h
        Employee.cpp
        Employee.h
        StringUtils.cpp
        StringUtils.h)
