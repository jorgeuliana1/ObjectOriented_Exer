//
// Created by ulian on 27/06/19.
//

#ifndef T2_2019_1_ETAPA00_GRADPROGRAM_H
#define T2_2019_1_ETAPA00_GRADPROGRAM_H

#include "Publication.h"

namespace scienprod_stats {
/**
 * Represents a Graduation Program.
 */
class GradProgram {
public:
    /**
     * @param Graduation Program's name.
     * @param Graduation Program's code / id.
     */
    GradProgram(const std::string &, const std::string &);
    ~GradProgram();

    /**
     * @return Graduation Program's name.
     */
    std::string name();
    /**
     * @return Graduation Program's code / id.
     */
     std::string id();

     /**
      * @param New Graduation Program's publication.
      */
     void add(Publication *);
     /**
      * @return Number of Publications by the Graduation Program.
      */
     long unsigned int size();
     /**
      * @param Index of the wanted Publication.
      * @return Wanted Publication.
      */
     Publication * get(const long unsigned int &);

private:
    std::string n; // Graduation Program's name.
    std::string c; // Graduation Program's code / id.
    std::vector<Publication *> p; // Publications by this specific Graduation Program.
};
}


#endif //T2_2019_1_ETAPA00_GRADPROGRAM_H
