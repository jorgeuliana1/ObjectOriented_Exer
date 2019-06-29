//
// Created by ulian on 27/06/19.
//

#ifndef T2_2019_1_ETAPA00_UNIVERSITY_H
#define T2_2019_1_ETAPA00_UNIVERSITY_H

#include "../GradProgram/GradProgram.h"

namespace scienprod_stats {
class University {
public:
    /**
    * @param University's name.
    * @param University's short name.
    */
    University(const std::string &, const std::string &);
    ~University();

    /**
    * @return University's name.
    */
    std::string name();
    /**
    * @return University's short name.
    */
    std::string short_name();
    /**
    * @param New University's Graduation Program.
    */
    void add(GradProgram *);
    /**
    * @return Number of Graduation Programs in that specific University.
    */
    long unsigned int size();
    /**
    * @param Index of the Graduation Program that belongs to the University.
    * @return Pointer to the wanted Graduation Program.
    */
    GradProgram * get(const long unsigned int &);
    /**
    * Use this method before deleting the Graduation Program from the memory.
    * @param Index of the Graduation Program to be removed.
    */
    void remove(const long unsigned int &);
    /**
    * @param Graduate Program's ID.
    * @return True if the Graduate Program of the given ID exists in this University.
    */
    bool contains_program(const std::string &);

private:
    std::string n; // University's name.
    std::string s; // University's short name.
    std::vector<GradProgram *> g; // Graduation Programs that belong to this specific University.
};
}

#endif //T2_2019_1_ETAPA00_UNIVERSITY_H
