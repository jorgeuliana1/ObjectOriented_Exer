//
// Created by ulian on 21/06/19.
//

#include "Department.h"
#include "StringUtils.h"

using namespace std;

Department::Department(const string& name) {
    this->name.clear();
    this->name.append(name);
    this->emps.clear();
}

Department::~Department() {
    this->emps.clear();
}

void Department::addEmployee(Employee* emp) {
    this->emps.push_back(*emp);
}

string Department::getName() {
    return this->name;
}

Employee* Department::popEmployee() {
    auto* emp = new Employee(this->emps.back());
    this->emps.pop_back();
    return emp;
}

Employee* Department::getEmployee(const string& name) {

    // Iterator of list
    list<Employee>::iterator i;

    // Iterating over the list
    for(i = this->emps.begin(); i != this->emps.end(); i++ ) {

        // Verifying if we found the wanted employee.
        Employee emp = *i;
        if(cpp_util::stringCompare(name, emp.getName())) {
            auto* e = new Employee(emp);
            return e;
        }
    }

    return nullptr;
}

double Department::getSalariesSum() {
    double sum = 0;

    list<Employee>::iterator i;

    for(i = this->emps.begin(); i != this->emps.end(); i++) {
        sum += i->getSalary();
    }

    return sum;
}

int Department::size() {
    return this->emps.size();
}

void Department::increaseSalaryPercentage(const double& percentage) {
    list<Employee>::iterator i;

    for(i = this->emps.begin(); i != this->emps.end(); i++) {
        i->changeSalary(i->getSalary() + i->getSalary() * percentage);
    }

}