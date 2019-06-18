//
// Created by 2018102932 on 18/06/19.
//

#ifndef PROJECT_COMPANY_H
#define PROJECT_COMPANY_H

class Company {
private:
    string name;
    string regist;
    list<Department> depart;
public:
    Company(string&, string&); // new
    ~Company(); // delete
    void addCompany(Company*);
    Company* popCompany();
    Company* getCompany(string&);
    void printSalaries();
};

#endif //PROJECT_COMPANY_H
