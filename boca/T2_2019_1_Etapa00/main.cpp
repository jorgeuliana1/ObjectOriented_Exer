#include <iostream>
#include "University/University.h"
#include "Command/Command.h"
#include "Exceptions/UnknownCommandException.h"
#include "CSVReader/CSVReader.h"
#include "Publication/PublicationType.h"
#include "Publication/BookPublication.h"

using namespace scienprod_stats;

// TODO: Organize the functions below in a class
void read_csv(csv_reader::CSVReader & csv, std::vector<University *> & u, std::vector<GradProgram *> & g,
              std::vector<Publication*> & p);
bool is_csv(const std::string & file_path);
std::string csv_type(const std::string & path);
PublicationType get_type(const std::string & type);
int to_int(const std::string & string);
bool is_editorial(const PublicationType & type);
std::string try_to_get(csv_reader::CSVReader & csv, const std::string & index);

// TODO: Implement insert_university
// TODO: Implement insert_gradprogram
// TODO: Implement insert_publication

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

void read_csv(csv_reader::CSVReader & csv, std::map<std::string, University *> & u, std::map<std::string, GradProgram *> & g,
              std::vector<Publication*> & p, const PublicationType & type)
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
                    instruments,    // Instrumental formation
                    translation;    // Translation

        int first, last;            // First and last pages.
        first = last = 0;           // Defining it as 0

        // Fundamental informations, every publication has it.
        nature   = try_to_get(csv, "DS_NATUREZA");
        title    = try_to_get(csv, "NM_TITULO");
        language = try_to_get(csv, "DS_IDIOMA");
        if(type == PublicationType::BOOK)
            city = try_to_get(csv, "NM_CIDADE_PAIS");
        else
            city = try_to_get(csv, "NM_CIDADE");
        uni_s = try_to_get(csv, "SG_ENTIDADE_ENSINO");
        uni_n = try_to_get(csv, "NM_ENTIDADE_ENSINO");
        g_id  = try_to_get(csv, "CD_PROGRAMA_IES");
        g_n   = try_to_get(csv, "NM_PROGRAMA_IES");


        // Getting data for editorials
        if(is_editorial(type))
            editor = try_to_get(csv, "NM_EDITORA");
        if(type == PublicationType::TRANSLATION)
            editor = try_to_get(csv, "NM_EDITORA_TRADUCAO");

        // Getting ISSN
        if(type == PublicationType::PERIODIC || type == PublicationType::MAGAZINE)
            serial = try_to_get(csv, "DS_ISSN");

        // Getting ISBN
        if(type == PublicationType::BOOK)
            serial = try_to_get(csv, "DS_ISBN");

        // Getting newspaper and magazine data
        if(type == PublicationType::MAGAZINE)
            p_date = try_to_get(csv, "DT_PUBLICACAO");

        // Getting periodic data
        if(type == PublicationType::PERIODIC) {

            volume   = try_to_get(csv, "NR_VOLUME");
            fascicle = try_to_get(csv, "DS_FASCICULO");
            series   = try_to_get(csv, "NR_SERIE");

            // Fixing the numbers
            volume   = std::to_string(to_int(volume));
            fascicle = std::to_string(to_int(fascicle));
            series   = std::to_string(to_int(series));

        }

        // Getting musical piece data
        if(type == PublicationType::MUSIC)
            instruments = try_to_get(csv, "DS_FORMACAO_INSTRUMENTAL");

        // Getting translated article data
        if(type == PublicationType::TRANSLATION)
            translation = try_to_get(csv, "DS_IDIOMA_TRADUCAO");

        // Getting annal publication data
        if(type == PublicationType::BOOK)
            annal = try_to_get(csv, "DS_EVENTO");

        // Getting pages data.

        if(type == PublicationType::BOOK)
            last = to_int(try_to_get(csv, "NR_PAGINAS_CONTRIBUICAO")) - 1;

        else if(type == PublicationType::MUSIC || type == PublicationType::GENERIC || type == PublicationType::TRANSLATION)
            last = to_int(try_to_get(csv, "NR_PAGINAS")) - 1;

        else {
            first = to_int(try_to_get(csv, "NR_PAGINA_INICIAL"));
            last  = to_int(try_to_get(csv, "NR_PAGINA_FINAL"));
        }

        // TODO: Create Publication

        University * university;
        university = new University(uni_n, uni_s);

        GradProgram * program;
        program = new GradProgram(g_id, g_n);

        // Key for the university
        std::string uni_key;

        // Key for the Graduation Program
        std::string gpr_key;

        uni_key = uni_n + uni_s;
        gpr_key = g_id;

        if(u.count(uni_key) > 0) {
            delete university;
            university = u[uni_key];
        } else
            u[uni_key] = university;

        if(g.count(gpr_key) > 0) {
            delete program;
            program = g[gpr_key];
        } else
            g[gpr_key] = program;

        university->add(program);
        // program->add(publication);

        // TODO: Finish this function.
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

    if (type == types[0])
        return PublicationType::ANNAL;
    if (type == types[1])
        return PublicationType::MAGAZINE;
    if (type == types[2])
        return PublicationType::PERIODIC;
    if (type == types[3])
        return PublicationType::BOOK;
    if (type == types[4])
        return PublicationType::MUSIC;
    if (type == types[5])
        return PublicationType::TRANSLATION;
    if (type == types[6])
        return PublicationType::GENERIC;

    return PublicationType::INVALID;
}

int to_int(const std::string & str) {
    if(str.find(".") != std::string::npos || str.find(",") != std::string::npos)
        return -1;

    std::istringstream iss(str);

    int n;

    iss >> n;

    return n;
}

bool is_editorial(const PublicationType & type) {
    if(type == PublicationType::BOOK || type == PublicationType::PERIODIC || type == PublicationType::MAGAZINE ||
      type == PublicationType::MUSIC || type == PublicationType::GENERIC)
        return true;

    return false;
}

std::string try_to_get(csv_reader::CSVReader & csv, const std::string & index) {
    try {
        return csv.getFromCachedLine(index);
    } catch (std::exception & e) {
        return nullptr;
    }
}