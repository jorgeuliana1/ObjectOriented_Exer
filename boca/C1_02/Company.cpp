//
// Created by ulian on 22/06/19.
//

#include <iostream>
#include <cstring>
#include <sstream>
#include <clocale>
#include <iomanip>
#include <cmath>
#include "Company.h"

using namespace std;

Company::Company(const string& name, const string& regis) {
    this->name = name;
    this->regist = regis;
}

Company::~Company() {
    this->depart.clear();
}

void Company::addDepartment(Department dept) {
    this->depart.insert(this->depart.end(), dept);
}

Department* Company::popDepartment() {
    auto* dep = new Department(this->depart.back());
    this->depart.pop_back();
    return dep;
}

int getCases(const double& num) {
    int num_cpy = num;
    unsigned int cases;

    for(cases = 1; num_cpy >= 10; num_cpy %= 10) {
        cases++;
    }

    return cases;
}

string formatSalary(const double& salary) {

    string deci_separator = ",";
    int num_deci = 2;

    int integer_sal = (int)salary;
    int decimal_sal = (int)((salary - integer_sal) * pow(10, num_deci));

    stringstream ss;
    ss << integer_sal;
    ss << deci_separator;

    if(decimal_sal < 10)
        ss << "0";

    ss << decimal_sal;

    string s = "R$ ";
    s.append(ss.str());
    return s;
}

void Company::printSalaries() {
    for(Department i : this->depart) {
        cout << i.getName() << " " << formatSalary(i.getSalariesSum()) << endl;
    }
}

int Company::size() {
    return this->depart.size();
}

Department Company::getDepartment(const int& index) {
    Department ret = this->depart[index];
    this->depart.erase(this->depart.begin() + index);
    return ret;
}

void Company::addToBegin(Department dept) {
    this->depart.insert(this->depart.begin(), dept);
}