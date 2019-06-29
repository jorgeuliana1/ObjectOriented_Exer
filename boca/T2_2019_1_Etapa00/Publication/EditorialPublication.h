//
// Created by ulian on 28/06/19.
//

#ifndef T2_2019_1_ETAPA00_EDITORIALPUBLICATION_H
#define T2_2019_1_ETAPA00_EDITORIALPUBLICATION_H

#include "Publication.h"

namespace scienprod_stats {
class EditorialPublication : public Publication {
private:
    std::string e; // Publication editor
public:
    /**
     * @param Publication's title
     * @param Publication's language
     * @param Publication's nature
     * @param Publication's city
     * @param Publication's editor
     */
    EditorialPublication(const std::string &, const std::string &, const std::string &, const std::string &,
            const std::string &);
    ~EditorialPublication();

    /**
     * @return Publication's editor
     */
    std::string editor();
};
}


#endif //T2_2019_1_ETAPA00_EDITORIALPUBLICATION_H
