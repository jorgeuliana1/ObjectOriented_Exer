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

void Department::addEmployee(Employee emp) {
    this->emps.insert(this->emps.end(), emp);
}

string Department::getName() {
    return this->name;
}

Employee* Department::popEmployee() {
    auto* emp = new Employee(this->emps.back());
    this->emps.pop_back();
    return emp;
}

double Department::getSalariesSum() {
    double sum = 0;

    for(Employee e : this->emps) {
       sum += e.getSalary();
    }

    return sum;
}

int Department::size() {
    return this->emps.size();
}

void Department::increaseSalaryPercentage(const double& percentage) {

    for(int i = 0; i < this->emps.size(); i++) {
        this->emps[i].changeSalary(this->emps[i].getSalary() + this->emps[i].getSalary()*percentage);
    }

}

Employee Department::getEmployee(const int& index) {
    Employee ret = this->emps[index];
    this->emps.erase(this->emps.begin() + index);
    return ret;
}