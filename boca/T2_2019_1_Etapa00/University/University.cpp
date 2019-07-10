//
// Created by ulian on 27/06/19.
//

#include <iostream>
#include "University.h"

using namespace std;

namespace scienprod_stats {

University::University(const std::string & name, const std::string & short_name) {
    n = name;
    s = short_name;
    g.clear();
}

University::~University() {
    this->g.clear();
}

string University::name() const {
    return n;
}

string University::short_name() const {
    return s;
}

void University::add(GradProgram * p) {
    g.insert(g.end(), p);
}

long unsigned int University::size() const {
    return g.size();
}

GradProgram * University::get(const long unsigned int & index) {
    if(index >= size())
        return nullptr;

    return g[index];
}

void University::remove(const long unsigned int & index) {
    if(index >= size())
        return;

    g.erase(g.begin() + index);
}

bool University::contains_program(const std::string & id) {
    for(GradProgram * p : g) {
        if(p->id() == id)
            return true;
    }
    return false;
}


// Auxiliar function.
int compareUni(const University * university1, const University & university2) {

    if(university1->short_name() > university2.short_name())
        return 1;
    else
    if(university1->short_name() < university2.short_name())
        return -1;

    // else ...
    if(university1->name() > university2.name())
        return 1;
    else
    if(university1->name() < university2.name())
        return -1;
    else
        return 0;

}

bool University::operator==(const University & university) const {
    return compareUni(this, university) == 0;
}

std::ostream &operator<<(std::ostream &out, const University &uni) {
    string name, sname;
    name = uni.name();
    sname = uni.short_name();

    out << sname << " (" << name << ")";

    return out;
}

string University::hash() const {
    string ss;

    ss.clear();
    ss.append("_");
    ss.append(s);
    ss.append("_");
    ss.append(n);

    // Will return something like "_Ufes_Universidade Federal do Espirito Santo"

    return ss;
}

}