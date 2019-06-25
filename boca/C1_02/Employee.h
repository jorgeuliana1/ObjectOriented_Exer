//
// Created by 2018102932 on 18/06/19.
//

#ifndef C1_02_EMPLOYEE_H
#define C1_02_EMPLOYEE_H

#include <string>

using namespace std;

class Employee {
private:
    string name;
    time_t admission_date;
    double salary;
public:
    Employee(const string&, const string&, const double&); // new
    string getName();
    int getAdmissionDay();
    int getAdmissionMonth();
    int getAdmissionYear();
    double getSalary();
    void changeSalary(const double&);
};

#endif //C1_02_EMPLOYEE_H
