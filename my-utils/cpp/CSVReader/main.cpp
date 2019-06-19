//
// Created by ulian on 19/06/19.
//

#include "CSVReader.h"
#include <iostream>

using namespace csv_reader;

int main() {
    // TESTING THE LIB
    CSVReader csv("input1.csv", ",", true);
    while(!csv.eof()) {
        csv.next();
        std::cout << csv.getFromCachedLine("Tile") << " " << csv.getFromCachedLine("Genre") << std::endl;
    }
    return 0;
}