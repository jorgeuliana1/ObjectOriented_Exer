//
// Created by jorgeuliana1 on 19/06/19.
//

#include <iostream>
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
        this->input.open(filepath);               // Opening the file stream
        this->separator = separator;              // Setting up the separator.
        /*
         * NOTE:
         * As it can be noticed, this->cache hasn't received any value, the library must be implemented in a way that
         * we won't have troubles with this->cache being unassigned.
         */

        // TODO: Insert proper exceptions at this function.
        // TODO: Properly comment this function.
        // TODO: Finish this function by creating the header interpreter hash.

        if(!isThereIndex) {
            this->tiIndex = false; // Used to avoid problems in functions that call by index name.
            return;
        }

        this->tiIndex = true; // Allows the usage of index-related functions.

        string raw_header; // raw_header is the unmodified first line of the csv.
        getline(this->input, raw_header); // assigning the proper value to the string.
        vector<string> header_vals = split(raw_header, this->separator); // taking the separated values.

        long unsigned int limit = header_vals.size();
        for(long unsigned int i = 0; i < limit; i++) /* Walking through the vector and ... */{
            this->header[header_vals[i]] = i; // ... assigning the values to the a position on the map.
        }

    }

    // Debug function:
    void CSVReader::printIndexes() {
        cout << this->header.find("Name")->first << endl;
        cout << this->header.find("Age")->first << endl;
    }

    CSVReader::~CSVReader() {
        this->input.close();
    }

    vector<string> CSVReader::split(const string& str, const regex& spr) {
        /*
         * This functions works similarly to Java String.split(regex) function.
         */
        vector<string> vctr;
        sregex_token_iterator itr(str.begin(), str.end(), spr, -1);
        sregex_token_iterator end;
        for( ; itr!=end; ++itr)
            vctr.push_back(*itr);

        return vctr;
    }

}