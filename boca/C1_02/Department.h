//
// Created by 2018102932 on 18/06/19.
//

#ifndef PROJECT_DEPARTMENT_H
#define PROJECT_DEPARTMENT_H

class Department {
private:
    list<Employee> emps;
    string name;
public:
    Department(string&); // new
    ~Department(); // delete
    void addEmployee(Employee*);
    Employee* popEmployee(); // Takes the last added employee and remove it from the list.
    Employee* getEmployee(string&);
    double getSalariesSum();
};

#endif //PROJECT_DEPARTMENT_H
