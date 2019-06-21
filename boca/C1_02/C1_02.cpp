//
// Created by 2018102932 on 18/06/19.
//

#include <iostream>
#include "Employee.h"

using namespace std;

int main() {
    Employee* j = new Employee((string&)"Jorge", (string&)"06/07/1999", 199.00);
    cout << j->getAdmissionDay() << endl;

    return 0;
}