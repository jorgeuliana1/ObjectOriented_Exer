//
// Created by ulian on 28/06/19.
//

#ifndef T2_2019_1_ETAPA00_GENERICPUBLICATION_H
#define T2_2019_1_ETAPA00_GENERICPUBLICATION_H

#include "EditorialPublication.h"

namespace scienprod_stats {
class GenericPublication : public EditorialPublication {
public:
    /**
     * @param Publication's title
     * @param Publication's language
     * @param Publication's city
     * @param Publication's editor
     */
    GenericPublication(const std::string &, const std::string &, const std::string &, const std::string &);
    ~GenericPublication();

    /**
     * @return Publication's editor
     */
    std::string editor();

    // Details at Publication.h
    bool compare(Publication *) override;
};
}


#endif //T2_2019_1_ETAPA00_GENERICPUBLICATION_H
