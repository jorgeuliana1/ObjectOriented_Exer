#include <iostream>
#include "University/University.h"
#include "Command/Command.h"
#include "Exceptions/UnknownCommandException.h"
#include "CSVReader/CSVReader.h"
#include "Publication/PublicationType.h"

using namespace scienprod_stats;

// TODO: Organize the functions below in a class
void read_csv(csv_reader::CSVReader & csv, std::vector<University *> & u, std::vector<GradProgram *> & g,
              std::vector<Publication*> & p);
bool is_csv(const std::string & file_path);
std::string csv_type(const std::string & path);
PublicationType get_type(const std::string & type);
// TODO: Create a function to get numbers from the csv.

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

void read_csv(csv_reader::CSVReader & csv, std::vector<University *> & u, std::vector<GradProgram *> & g,
              std::vector<Publication*> & p, PublicationType type)
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
            if(type == PublicationType::BOOK)
                city = csv.getFromCachedLine("NM_CIDADE_PAIS");
            else
                city = csv.getFromCachedLine("NM_CIDADE");
            uni_s = csv.getFromCachedLine("SG_ENTIDADE_ENSINO");
            uni_n = csv.getFromCachedLine("NM_ENTIDADE_ENSINO");
            g_id  = csv.getFromCachedLine("CD_PROGRAMA_IES");
            g_n   = csv.getFromCachedLine("NM_PROGRAMA_IES");
        } catch (std::exception & e) {
            break;
        }

        // TODO: Get data to editorials
        // TODO: Get ISSN
        // TODO: Get ISBN
        // TODO: Get newspaper and magazine data
        // TODO: Get Periodic data
        // TODO; Get data for musical piece
        // TODO: Get translation data
        // TODO: Get data for annals
        // TODO: Get the pages
        // TODO: Insert the data in the lists.
    }
}

bool is_csv(const std::string & file_path) {

        // Using string.find() to search for the ".csv" extension in the file path.
        if(file_path.find(".csv") != std::string::npos)
            return true;

        else return false;

}

std::string csv_type(const std::string & path) {

    std::string types[] = {"anais", "artjr", "artpe", "livro", "partmu", "tradu", "outro"};

    // Iterating through the types vector.
    for(std::string type : types) {

        // Creating the identifier string, that identifies the type by the file name.
        // Ex.: "-anais."
        std::string identifier;
        identifier = "-";
        identifier.append(type);
        identifier.append(".");

        // If the file name contains the identifier...
        if(path.find(identifier) != std::string::npos)
            return type;

    }

    // If none of the identifiers have been found...
    return nullptr;
}

PublicationType get_type(const std::string & type) {
    std::string types[] = {"anais", "artjr", "artpe", "livro", "partmu", "tradu", "outro"};

    if(type == types[0])
        return PublicationType::ANNAL;
    if(type == types[1])
        return PublicationType::MAGAZINE;
    if(type == types[2])
        return PublicationType::PERIODIC;
    if(type == types[3])
        return PublicationType::BOOK;
    if(type == types[4])
        return PublicationType::MUSIC;
    if(type == types[5])
        return PublicationType::TRANSLATION;
    if(type == types[6])
        return PublicationType::GENERIC;

    return PublicationType::INVALID;
}