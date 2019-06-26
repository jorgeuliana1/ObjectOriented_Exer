//
// Created by 2018102932 on 18/06/19.
//

#include <iostream>
#include <iomanip>
#include <locale>
#include <cstdio>
#include <cstring>
#include "Employee.h"
#include "Department.h"
#include "Company.h"

using namespace std;



int main() {
    string coname, cocode;
    cin >> coname;
    cin >> cocode;

    int num_dep;
    cin >> num_dep;
    Company company(coname, cocode);
    for(int i = 0; i < num_dep; i++) {
        string dp_name;
        cin >> dp_name;
        int nf;
        cin >> nf;
        Department dept(dp_name);
        for(int j = 0; j < nf; j++) {
            string ename;
            cin >> ename;
            double salary;
            cin >> salary;
            string admission;
            cin >> admission;
            Employee e(ename, admission, salary);
            dept.addEmployee(e);
        }
        company.addDepartment(dept);
    }


    // Datebase creation finished

    // STEP 1: INCREASE THE SALARY OF EVERY EMPLOYEE OF THE FIRST DEPT IN 10%

    // STEP 1.1: GETTING THE FIRST AND SECOND DEPARTMENT
    Department d2 = company.getDepartment(1);

    Department d1 = company.getDepartment(0);
    d1.increaseSalaryPercentage(0.1);

    // STEP 2: TRANSFER THE FIRST EMPLOYEE OF THE FIRST DEPARTMENT TO THE SECOND DPT.

    // STEP 2.1: GETTING THE FIRST EMPLOYEE
    Employee e = d1.getEmployee(0);

    // STEP 2.3: ADDING THE FIRST EMPLOYEE OF D1 IN D2
    d2.addEmployee(e);

    // FINISHING
    company.addToBegin(d2);
    company.addToBegin(d1);

    company.printSalaries();

    return 0;
}