//
// Created by ulian on 28/06/19.
//

#ifndef T2_2019_1_ETAPA00_BOOKPUBLICATION_H
#define T2_2019_1_ETAPA00_BOOKPUBLICATION_H

#include "EditorialPublication.h"

namespace scienprod_stats {
class BookPublication : EditorialPublication {
private:
    std::string i; // ISBN

public:
    /**
     * @param Publication's title
     * @param Publication's language
     * @param Publication's nature
     * @param Publication's city
     * @param Publication's editor
     * @param Publication's isbn
     */
    BookPublication(const std::string &, const std::string &, const std::string &, const std::string &,
                    const std::string &, const std::string &);
    ~BookPublication();

    /**
     * @return Publication's isbn
     */
    std::string isbn();

    /**
     * Explained at Publication.h
     */
    bool compare(Publication *) override;
};
}


#endif //T2_2019_1_ETAPA00_BOOKPUBLICATION_H
