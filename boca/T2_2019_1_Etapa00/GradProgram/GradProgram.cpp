//
// Created by ulian on 27/06/19.
//

#include "GradProgram.h"

using namespace std;

namespace scienprod_stats {

GradProgram::GradProgram(const std::string &name, const std::string &code) {
    n = name;
    c = code;
    p.clear();
}

GradProgram::~GradProgram() {
    p.clear();
}

string GradProgram::name() const {
    return n;
}

string GradProgram::id() const {
    return c;
}

void GradProgram::add(Publication *publication) {
    p.insert(p.end(), publication);
}

long unsigned int GradProgram::size() const {
    return p.size();
}

Publication *GradProgram::get(const long unsigned int &index) const {
    if (index >= size())
        return nullptr;

    return p[index];
}

void GradProgram::remove(const long unsigned int &index) {
    if (index >= size())
        return;

    p.erase(p.begin() + index);
}

// Auxiliar function.
int compareGP(const GradProgram * gradprogram1, const GradProgram & gradprogram2) {

    if(gradprogram1->name() > gradprogram2.name())
        return 1;
    else
    if(gradprogram1->name() < gradprogram2.name())
        return -1;

    // else ...
    if(gradprogram1->id() > gradprogram2.id())
        return 1;
    else
    if(gradprogram1->id() < gradprogram2.id())
        return -1;
    else
        return 0;

}

bool GradProgram::operator==(const GradProgram & gp) const {
    return compareGP(this, gp) == 0;
}

ostream & operator<<(ostream & out, const GradProgram & gp) {
    string code = gp.c;
    string name = gp.n;

    out << code;

    string sep = ": ";

    out << sep;
    out << name;

    return out;
}

string GradProgram::hash() const {
    return c;
}

}