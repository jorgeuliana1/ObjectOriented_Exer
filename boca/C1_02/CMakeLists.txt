cmake_minimum_required(VERSION 3.12.3)  # CMake version check
project(C1_02)               # Create project "simple_example"
set(CMAKE_CXX_STANDARD 14)            # Enable c++14 standard

# Add main.cpp file of project root directory as source file
set(SOURCE_FILES main.cpp Employee.cpp StringUtils.cpp DateUtils.cpp)

# Add executable target with source files listed in SOURCE_FILES variable
add_executable(simple_example ${SOURCE_FILES})