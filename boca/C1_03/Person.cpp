//
// Created by ulian on 25/06/19.
//

#include <sstream>
#include <iomanip>
#include "Person.h"

using namespace std;

Person::Person() {
    this->name = "";
    this->age = 0;
    this->height = 0.0;
    this->index = 0;
}

Person::Person(const string& name, const unsigned int& age, const double & height, const long unsigned int & index) {
    this->name = name;
    this->age = age;
    this->height = height;
    this->index = index;
}

Person::~Person() {

}

string Person::toString() {
    stringstream ss;
    ss << index << ": ";
    ss << name << " (idade: ";
    ss << age << "; altura: ";

    // Defining the height string
    stringstream h_str;
    setlocale(LC_NUMERIC, "en_US.utf8");
    h_str << setprecision(3);
    h_str << height;

    // Finishing the printing
    ss << h_str.str() << ")";

    return ss.str();
}

string Person::getName() {
    return this->name;
}

unsigned int Person::getAge() {
    return this->age;
}

double Person::getHeight() {
    return this->height;
}

void Person::setID(const int& id) {
    this->index = id;
}