#include <iostream>
#include "University/University.h"
#include "Command/Command.h"
#include "Exceptions/UnknownCommandException.h"
#include "CSVReader/CSVReader.h"

using namespace scienprod_stats;

void read_csv(csv_reader::CSVReader & csv, std::vector<University *> & u, std::vector<GradProgram *> & g,
              std::vector<Publication*> & p);
bool is_csv(const std::string & line);
std::string csv_type(const std::string & path);
// TODO: Implement read_csv
// TODO: Implement is_csv
// TODO: Implement csv_type

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
0

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

void read_csv(csv_reader::CSVReader & csv, std::vector<University *> & u, std::vector<GradProgram *> & g,
              std::vector<Publication*> & p)
{
    while(!csv.eof()) /* while csv file hasn't ended */{
        csv.next();

        // Defining variables (many)
        std::string nature,         // Publication nature
                    title,          // Publication title
                    language,       // Publication language
                    city,           // Publication city
                    uni_n,          // University name
                    uni_s,          // University short name
                    g_id,           // Graduation Program ID
                    g_n,            // Graduation Program name
                    annal,          // Annal name
                    serial,         // ISSN/ISBN
                    editor,         // Editor
                    p_date,         // Publishing date
                    volume,         // Volume
                    fascicle,       // Fascicle
                    series,         // Series
                    intruments,     // Instrumental formation
                    translation;    // Translation

        int first, last;            // First and last pages.
        first = last = 0;           // Defining it as 0

        try {
            // Fundamental informations, every publication has it.
            nature   = csv.getFromCachedLine("DS_NATUREZA");
            title    = csv.getFromCachedLine("NM_TITULO");
            language = csv.getFromCachedLine("DS_IDIOMA");
            // TODO: FINISH THIS FUNCTION FROM HERE (CSV_TYPE IMPLEMENTATION NEEDED) (See T1 code for details.)
            // TODO: USE THE CSV_TYPE HERE
        } catch (std::exception & e) {
            break;
        }
    }
}