//
// Created by ulian on 27/06/19.
//

#include <iostream>
#include "University.h"

using namespace std;
using namespace scienprod_stats;

University::University(const std::string & name, const std::string & short_name) {
    n = name;
    s = short_name;
    g.clear();
}

University::~University() {
    this->g.clear();
}

string University::name() {
    return n;
}

string University::short_name() {
    return s;
}

void University::add(GradProgram * p) {
    g.insert(g.end(), p);
}

long unsigned int University::size() {
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