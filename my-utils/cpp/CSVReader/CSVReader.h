//
// Created by jorgeuliana1 on 19/06/19.
//

#ifndef CSVREADER_CSVREADER_H
#define CSVREADER_CSVREADER_H

#include <map>
#include <fstream>
#include <regex>

namespace csv_reader {

class CSVReader {
private:
    std::ifstream input;               // File input stream.
    std::string cache;                 // Cached string.
    std::regex separator;              // CSV Separator. (regex)
    bool tiNext;                       // Is there a next line?
    bool tiIndex;                      // Is there a index line?
    std::map<std::string, int> header; // Header interpreter.

    std::vector<std::string> split(const std::string&, const std::regex&);

public:
    CSVReader(const std::string&, const std::string& , const bool&);
    ~CSVReader();
    void printIndexes();

};

}


#endif //CSVREADER_CSVREADER_H
