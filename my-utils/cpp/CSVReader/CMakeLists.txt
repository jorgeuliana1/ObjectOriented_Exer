cmake_minimum_required(VERSION 3.14)
project(CSVReader)

set(CMAKE_CXX_STANDARD 14)

include_directories(.)

add_executable(CSVReader
        CSVReader.cpp
        CSVReader.h
        main.cpp)
