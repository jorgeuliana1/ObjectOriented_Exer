//
// Created by ulian on 25/06/19.
//

#ifndef C1_02_PERSON_H
#define C1_02_PERSON_H

#include <string>

class Person {
private:
    std::string name;
    long unsigned int index;
    unsigned int age;
    double height;
public:
    Person();

    /**
     * @param name
     * @param age
     * @param height
     * @param id
     */
    Person(const std::string&, const unsigned int&, const double&, const long unsigned int&);

    ~Person();
    std::string toString();
    std::string getName();
    unsigned int getAge();
    double getHeight();
    void setID(const int&);
};


#endif //C1_02_PERSON_H
