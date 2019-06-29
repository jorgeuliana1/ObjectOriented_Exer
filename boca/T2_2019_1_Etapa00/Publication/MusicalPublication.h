//
// Created by ulian on 28/06/19.
//

#ifndef T2_2019_1_ETAPA00_MUSICALPUBLICATION_H
#define T2_2019_1_ETAPA00_MUSICALPUBLICATION_H


#include "EditorialPublication.h"

namespace scienprod_stats {
class MusicalPublication : public EditorialPublication {
private:
    std::string i; // Instrumental formation
public:
    /**
     * @param Publication's title
     * @param Publication's language
     * @param Publication's city
     * @param Publication's editor
     * @param Instrumental formation
     */
     MusicalPublication(const std::string &, const std::string &, const std::string &, const std::string &,
                        const std::string &);
    ~MusicalPublication();

    /**
     * @return Instrumental formation
     */
    std::string instrumental();

    /**
     * Explained at Publication.h
     */
    bool compare(Publication *) override;
};
}


#endif //T2_2019_1_ETAPA00_MUSICALPUBLICATION_H
