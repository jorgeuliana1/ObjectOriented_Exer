//
// Created by 2018102932 on 18/06/19.
//

#include <iostream>
#include <iomanip>
#include <locale>
#include <cstdio>
#include "Employee.h"
#include "Department.h"

using namespace std;

string formatSalary(const double& salary) {
    setlocale(LC_NUMERIC, "pt_BR.utf8");
    char* str;
    sprintf(str, "R$ %.2f", salary);
    string s = str;
    return s;
}

int main() {
    Employee* j = new Employee("Jorge", "06/07/1999", 199.00);
    Department* d = new Department("TI");
    d->addEmployee(j);
    cout << formatSalary(d->getSalariesSum()) << endl;
    d->increaseSalaryPercentage(0.1);
    cout << formatSalary(d->getSalariesSum()) << endl;

    //delete j;
    //delete d;
    return 0;
}