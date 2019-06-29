//
// Created by ulian on 28/06/19.
//

#ifndef T2_2019_1_ETAPA00_MAGAZINEPUBLICATION_H
#define T2_2019_1_ETAPA00_MAGAZINEPUBLICATION_H

#include "SerializedPublication.h"

namespace scienprod_stats {
class MagazinePublication : public SerializedPublication {
private:
    std::string pd; // Publishing date.
public:
    /**
     * @param Publication's title
     * @param Publication's language
     * @param Publication's nature
     * @param Publication's city
     * @param Publication's editor
     * @param Publication's serial
     * @param Publication's publishing date
     */
    MagazinePublication(const std::string &, const std::string &, const std::string &,
                        const std::string &, const std::string &, const std::string &, const std::string &);
    ~MagazinePublication();

    /**
     * @return Publication's publishing date
     */
    std::string date();

    // Details at Publication.h
    bool compare(Publication *) override;

};
}


#endif //T2_2019_1_ETAPA00_MAGAZINEPUBLICATION_H
