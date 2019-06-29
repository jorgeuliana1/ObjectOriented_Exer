//
// Created by ulian on 28/06/19.
//

#ifndef T2_2019_1_ETAPA00_TRANSLATEDPUBLICATION_H
#define T2_2019_1_ETAPA00_TRANSLATEDPUBLICATION_H


#include "EditorialPublication.h"

namespace scienprod_stats {
    class TranslatedPublication : EditorialPublication {
    private:
        std::string t; // Translation language

    public:
        /**
         * @param Publication's title
         * @param Publication's language
         * @param Publication's nature
         * @param Publication's city
         * @param Publication's editor
         * @param Publication's translation language
         */
        TranslatedPublication(const std::string &, const std::string &, const std::string &, const std::string &,
                              const std::string &, const std::string &);
        ~TranslatedPublication();

        /**
         * @return Publication's translation language
         */
        std::string translation_language();

        /**
         * Explained at Publication.h
         */
        bool compare(Publication *) override;
    };
}


#endif //T2_2019_1_ETAPA00_TRANSLATEDPUBLICATION_H
