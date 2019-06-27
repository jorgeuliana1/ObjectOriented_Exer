//
// Created by ulian on 26/06/19.
//

#ifndef C1_04_ATHLETE_H
#define C1_04_ATHLETE_H

#include "Person.h"

class Athlete : public Person {
private:
    std::string team;
public:
    Athlete();
    Athlete(const std::string&, const unsigned int&, const double&, const long unsigned int&, const std::string&);
    std::string toString();
    std::string getTeam();

};


#endif //C1_04_ATHLETE_H
