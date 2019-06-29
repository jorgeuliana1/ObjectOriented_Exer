//
// Created by ulian on 27/06/19.
//

#include "GradProgram.h"

using namespace std;
using namespace scienprod_stats;

GradProgram::GradProgram(const std::string & name, const std::string & code) {
    n = name;
    c = code;
    p.clear();
}

GradProgram::~GradProgram() {
    p.clear();
}

string GradProgram::name() {
    return n;
}

string GradProgram::id() {
    return c;
}

void GradProgram::add(Publication * publication) {
    p.insert(p.end(), publication);
}

long unsigned int GradProgram::size() {
    return p.size();
}

Publication * GradProgram::get(const long unsigned int & index) {
    if(index >= size())
        return nullptr;

    return p[index];
}

void GradProgram::remove(const long unsigned int & index) {
    if(index >= size())
        return;

    p.erase(p.begin() + index);
}