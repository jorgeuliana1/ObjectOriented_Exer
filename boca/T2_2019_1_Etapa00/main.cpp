#include <iostream>
#include "University/University.h"
#include "Command/Command.h"
#include "Exceptions/UnknownCommandException.h"
#include "CSVReader/CSVReader.h"
#include "Publication/PublicationType.h"
#include "Publication/BookPublication.h"

using namespace scienprod_stats;

int main() {

    /*

    csv_reader::CSVReader * csv;
    std::string folder_path;
    std::string line;
    std::vector<University  *> u;
    std::vector<GradProgram *> g;
    std::vector<Publication *> p;

    std::cin >> folder_path; // Getting the folder path.

    while(true) {

        std::cin >> line; // Getting the file name or command.
        std::string sc1, sc2; // To store sub-commands.

        if(is_csv(line)) {

            // Building the path string.
            std::string path = folder_path.append("/");
            path.append(line);

            // Reading the file and filling the lists.
            csv = new csv_reader::CSVReader(path, ",", true);
            read_csv(*csv, u, g, p);
￼

            // We won't use this file anymore.
            delete csv;

        }

        else {

            // Getting sub-command(s).
            std::cin >> sc1;
            if(line == "csv") { // csv command has 2 arguments.
                std::cin >> sc2;
            } else sc2 = "";

            // Executing the commands.
            Command * c;
            try {

                c = new Command(line, sc1, sc2);

            } catch (UnknownCommandException & e) {

                // Exception handling.
                std::cout << e.what();
                break;

            }

            c->execute(u, g, p);

            delete c;

            break;

        }

    }
    */

    // TODO: Uncomment the main function.


    return 0;
}











