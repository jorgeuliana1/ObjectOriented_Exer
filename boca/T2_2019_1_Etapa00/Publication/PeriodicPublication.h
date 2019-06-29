//
// Created by ulian on 28/06/19.
//

#ifndef T2_2019_1_ETAPA00_PERIODICPUBLICATION_H
#define T2_2019_1_ETAPA00_PERIODICPUBLICATION_H


#include "SerializedPublication.h"

namespace scienprod_stats {
    class PeriodicPublication : public SerializedPublication {
    private:
        std::string v; // Volume
        std::string f; // Fascicle
        std::string s; // Series

    public:
        /**
         * @param Publication's title
         * @param Publication's language
         * @param Publication's city
         * @param Publication's editor
         * @param Publication's serial
         * @param Publication's volume
         * @param Publication's fascicle
         * @param Publication's series
         */
        PeriodicPublication(const std::string &, const std::string &, const std::string &, const std::string &,
                            const std::string &, const std::string &, const std::string &, const std::string &);
        ~PeriodicPublication();

        /**
         * @return Publication's series.
         */
        std::string series();
/**
         * @return Publication's volume.
         */
        std::string volume();
/**
         * @return Publication's fascicle.
         */
        std::string fascicle();

        /**
         * Explained at Publication.h
         */
        bool compare(Publication *) override;
    };
}


#endif //T2_2019_1_ETAPA00_PERIODICPUBLICATION_H
