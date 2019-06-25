//
// Created by 2018102932 on 18/06/19.
//

#ifndef PROJECT_COMPANY_H
#define PROJECT_COMPANY_H

#include "Department.h"

class Company {
private:
    string name;
    string regist;
    list<Department> depart;
public:
    Company(string&, string&); // new
    ~Company(); // delete
    void addDepartment(Department*);
    Department* popDepartment();
    void printSalaries();
    int size();
};

#endif //PROJECT_COMPANY_H
