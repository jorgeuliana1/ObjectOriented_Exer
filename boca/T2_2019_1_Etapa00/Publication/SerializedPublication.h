//
// Created by ulian on 28/06/19.
//

#ifndef T2_2019_1_ETAPA00_SERIALIZEDPUBLICATION_H
#define T2_2019_1_ETAPA00_SERIALIZEDPUBLICATION_H


#include "EditorialPublication.h"

namespace scienprod_stats {
class SerializedPublication : public EditorialPublication {
private:
    std::string issn; // Publication's Serial

public:
    /**
     * @param Publication's title
     * @param Publication's language
     * @param Publication's city
     * @param Publication's editor
     * @param Publication's serial
     */
    SerializedPublication(const std::string &, const std::string &, const std::string &,
                          const std::string &, const std::string &);
    ~SerializedPublication();

    /**
     * @return Publication's serial.
     */
    std::string serial();

    /**
     * Explained at Publication.h
     */
    bool compare(Publication *) override;
};
}


#endif //T2_2019_1_ETAPA00_SERIALIZEDPUBLICATION_H
