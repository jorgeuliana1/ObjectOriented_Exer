//
// Created by ulian on 27/06/19.
//

#ifndef T2_2019_1_ETAPA00_GRADPROGRAM_H
#define T2_2019_1_ETAPA00_GRADPROGRAM_H

#include "../Publication/Publication.h"

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
    std::string name() const;
    /**
    * @return Graduation Program's code / id.
    */
    std::string id() const;
    /**
    * @param New Graduation Program's publication.
    */
    void add(Publication *);
    /**
    * @return Number of Publications by the Graduation Program.
    */
    long unsigned int size() const;
    /**
    * @param Index of the wanted Publication.
    * @return Wanted Publication.
    */
    Publication * get(const long unsigned int &) const;
    /**
    * Use this method before deleting the Publication from the memory.
    * @param Index of the Publication to be removed.
    */
    void remove(const long unsigned int &);
    /**
     * Overrides operator ==.
     */
    bool operator==(const GradProgram &) const;
    /**
     * Overrides operator <<.
     */
    friend std::ostream & operator<<(std::ostream &, const GradProgram &);
    /**
     * @return The hash key for this specific graduation program.
     */
    std::string hash() const;

private:
    std::string n; // Graduation Program's name.
    std::string c; // Graduation Program's code / id.
    std::vector<Publication *> p; // Publications by this specific Graduation Program.
};
}


#endif //T2_2019_1_ETAPA00_GRADPROGRAM_H
