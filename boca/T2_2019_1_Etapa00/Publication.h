//
// Created by ulian on 27/06/19.
//

#ifndef T2_2019_1_ETAPA00_PUBLICATION_H
#define T2_2019_1_ETAPA00_PUBLICATION_H

#include <string>
#include <vector>

namespace scienprod_stats {
class Publication {
public:
    // Abstract class / Interface
    /**
     * @param Publication's title
     * @param Publication's language
     * @param Publication's nature
     */
    Publication(const std::string &, const std::string &, const std::string &);
    virtual ~Publication();
    /**
     *
     * @return The publication's title.
     */
    std::string title();
    /**
     *
     * @return The publication's language
     */
    std::string language();
    /**
     *
     * @return The publication's nature.
     */
    std::string nature();

private:
    std::string t; // Article title
    std::string l; // Article language
    std::string n; // Article nature
};
}


#endif //T2_2019_1_ETAPA00_PUBLICATION_H
