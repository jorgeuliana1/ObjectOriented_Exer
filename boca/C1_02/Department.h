//
// Created by 2018102932 on 18/06/19.
//

#ifndef PROJECT_DEPARTMENT_H
#define PROJECT_DEPARTMENT_H

#include <list>
#include <vector>
#include "Employee.h"

class Department {
private:
    vector<Employee> emps;
    string name;
public:
    Department(const string&); // new
    ~Department(); // delete
    void addEmployee(Employee);
    string getName();
    Employee* popEmployee(); // Takes the last added employee and remove it from the list.
    Employee getEmployee(const int&);
    double getSalariesSum();
    int size();
    void increaseSalaryPercentage(const double&);
};

#endif //PROJECT_DEPARTMENT_H
