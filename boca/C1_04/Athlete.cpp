//
// Created by ulian on 26/06/19.
//

#include "Athlete.h"

using namespace std;

Athlete::Athlete() : Person() {

}

Athlete::Athlete(const std::string & name, const unsigned int & age, const double & height, const long unsigned int & id,
                 const std::string & team) : Person(name, age, height, id) {
    this->team = team;
}

string Athlete::toString() {
    return Person::toString() + " - " + this->team;
}

string Athlete::getTeam() {
    return this->team;
}