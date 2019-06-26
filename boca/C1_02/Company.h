//
// Created by 2018102932 on 18/06/19.
//

#ifndef PROJECT_COMPANY_H
#define PROJECT_COMPANY_H

#include <vector>
#include "Department.h"

class Company {
private:
    string name;
    string regist;
    vector<Department> depart;
public:
    Company(const string&, const string&); // new
    ~Company(); // delete
    void addDepartment(Department);
    Department* popDepartment();
    Department getDepartment(const int&);
    void addToBegin(Department dept);
    void printSalaries();
    int size();

};

#endif //PROJECT_COMPANY_H
