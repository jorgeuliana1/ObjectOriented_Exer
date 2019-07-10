//
// Created by ulian on 06/07/19.
//

#ifndef T2_2019_1_ETAPA00_STATS_H
#define T2_2019_1_ETAPA00_STATS_H

#include "../University/University.h"
#include "../CSVReader/CSVReader.h"
#include "../Publication/PublicationType.h"

namespace scienprod_stats {
class Stats {
private:
    std::string type;             // Publication type
    csv_reader::CSVReader csv;    // CSV to be read
    // TODO: Implement map instead of vector.
    std::map<std::string, University  *> u; // Universities vector
    std::map<std::string, GradProgram *> g; // Graduation Programs vector
    std::map<std::string, Publication *> p; // Publications vector

    /**
     * @param String with the name of the index the user is trying to get.
     * @return The information the user is trying to get or nullptr.
     */
    std::string try_to_get(const std::string &);

    /**
     * @return true if type is a subtype of editorial.
     */
    bool is_editorial();

    /**
     * @param university to be inserted in the list.
     */
    void add_university(University *);

    /**
     * @param graduation program to be inserted in the list.
     */
    void add_gradprogram(GradProgram *);

    /**
     * @param publication to be inserted in the list.
     */
    void add_publication(Publication *);

public:
    /**
     * @param Source's path. The source is the .csv file that follows the naming convention of this project.
     */
    explicit Stats(std::string &);
    ~Stats()=default;

    /**
     * Reads the data from the CSV located on the specified path.
     */
    void read();

    /**
     * Translates from string to PublicationType enum.
     */
     PublicationType get_type();
};
}

#endif //T2_2019_1_ETAPA00_STATS_H
