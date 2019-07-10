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
     * @param Publication's city
     */
    Publication(const std::string &, const std::string &, const std::string &, const std::string &);
    virtual ~Publication();
    /**
     *
     * @return The publication's title.
     */
    std::string title() const;
    /**
     *
     * @return The publication's language
     */
    std::string language() const;
    /**
     *
     * @return The publication's nature.
     */
    std::string nature() const;
    /**
     *
     * @return The publication's city.
     */
    std::string city() const;

    /**
     * @param Initial page.
     * @param Final page.
     */
    void set_pages(const int &, const int &);

    /**
     * @return Number of pages in the Publication.
     */
    int size() const;

    /**
     * @param Publication to be compared.
     * @return True if this is greater than param. Else it returns False.
     */
    virtual bool compare(Publication *);
    /**
     * @return The hash key for this specific publication.
     */
    std::string hash() const;

private:
    std::string t; // Article title
    std::string l; // Article language
    std::string n; // Article nature
    std::string c; // Article city

    struct Pages { // Struct that contains pages infos.
        bool has_page = false;
        int begin; // Initial page
        int end; // Final page
    };

    Pages p;
};
}


#endif //T2_2019_1_ETAPA00_PUBLICATION_H
