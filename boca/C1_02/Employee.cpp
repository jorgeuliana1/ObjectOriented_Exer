//
// Created by 2018102932 on 18/06/19.
//

#include "DateUtils.h"
#include "Employee.h"
#include <sstream>
#include <iostream>

using namespace std;
using namespace cpp_util;

Employee::Employee(const string& name, const string& date, const double& salary) {
    this->name.clear();
    this->name.append(name);
    this->admission_date = parseDate(date, "%d/%m/%Y");
    this->salary = salary;
}

string Employee::getName() {
    return this->name;
}

const double Employee::getSalary() {
    const double& salary = this->salary;
    return salary;
}

void Employee::changeSalary(const double& newsalary) {
    this->salary = newsalary;
}

int parseNum(const string& num) {
    // A little work around to imitate the behavior of a stream.
    string n = num;
    n.append(" ");

    int number;
    istringstream iss(n);
    iss >> number;
    if(!iss.good()) {
        return -1;
    }
    return number;
}

int Employee::getAdmissionDay() {
    const string& date = formatDate(this->admission_date, "%d");
    return parseNum(date);
}

int Employee::getAdmissionMonth() {
    const string& date = formatDate(this->admission_date, "%m");
    return parseNum(date);
}

int Employee::getAdmissionYear() {
    const string& date = formatDate(this->admission_date, "%Y");
    return parseNum(date);
}