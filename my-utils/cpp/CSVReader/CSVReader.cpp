//
// Created by jorgeuliana1 on 19/06/19.
//

#include "CSVReader.h"

using namespace std;

namespace csv_reader {

    /**
     * @author J. Jorge Moutinho Uliana (GitHub: jorgeuliana1)
     * @name CSVReader
     * @class CSVReader
     * @namespace csv_reader
     * @param filepath
     * @param separator
     * @param isThereIndex
     */
    CSVReader::CSVReader(const string& filepath, const string& separator, const bool& isThereIndex) {
        this->input.open(filepath, ios::in);      // Opening the file stream
        this->separator = separator;              // Setting up the separator.
        this->cache.assign(nullptr);              // assigning NULL to string value.

        // TODO: Insert proper exceptions at this function.
        // TODO: Properly comment this function.
        // TODO: Finish this function by creating the header interpreter hash.
    }

    CSVReader::~CSVReader() {
        this->input.close();
        // TODO: Finish this function.
    }

}