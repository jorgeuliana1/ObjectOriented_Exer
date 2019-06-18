//
// Created by 2018102932 on 18/06/19.
//

#include "DateUtils.h"
#include "Employee.h"
#include <sstream>

using namespace std;
using namespace cpp_util;

Employee::Employee(string& name, string& date, const double& salary) {
    this->name = name;
    this->admission_date = parseDate(date, "%d/%m/%Y");
    this->salary = salary;
}

string Employee::getName() {
    return this->name;
}

double Employee::getSalary() {
    return this->salary;
}

void Employee::changeSalary(const double& newsalary) {
    this->salary = newsalary;
}

int parseNum(const string& num) {
    int number;
    istringstream iss(num);
    iss >> number;
    if(!iss.good()) {
        return -1;
    }
    return number;
}

int Employee::getAdmissionDay() {
    string date = formatDate(this->admission_date, "%d/%m/%Y");
    return parseNum(date);
}