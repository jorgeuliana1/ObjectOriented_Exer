//
// Created by ulian on 28/06/19.
//

#ifndef T2_2019_1_ETAPA00_ANNALPUBLICATION_H
#define T2_2019_1_ETAPA00_ANNALPUBLICATION_H


#include "Publication.h"

namespace scienprod_stats {
class AnnalPublication : public Publication {
private:
    std::string annal;

public:
    /**
     * @param Publication's title
     * @param Publication's language
     * @param Publication's annal
     * @param Publication's city
     */
    AnnalPublication(const std::string &, const std::string &, const std::string &, const std::string &);
    ~AnnalPublication();

    /**
     * @return Publication's editor
     */
    std::string editor();

    /**
     * Explained at Publication.h
     */
     bool compare(Publication *) override;
};
}

#endif //T2_2019_1_ETAPA00_ANNALPUBLICATION_H
