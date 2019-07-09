//
// Created by ulian on 06/07/19.
//

#include "Stats.h"
#include "../Publication/PublicationType.h"

// TODO: Implement insert_university
// TODO: Implement insert_gradprogram
// TODO: Implement insert_publication

using namespace std;

namespace scienprod_stats {

// Auxiliar functions.
bool is_csv(const string & file_path);

/**
 * @param Path of the file
 * @return Type of the data contained in the CSV.
*/
string csv_type(const string & path);

/**
 * @param string containing the number to be translated.
 * @return int contained on the string
 */
int to_int(const string & string);
bool is_editorial(const PublicationType & type);

Stats::Stats(string & file_path) : csv(file_path, ",", true) /* CSV file has header */{
    type = csv_type(file_path);
}

string csv_type(const string & path) {

    string types[] = {"anais", "artjr", "artpe", "livro", "partmu", "tradu", "outro"};

    // Iterating through the types vector.
    for(string type : types) {

        // Creating the identifier string, that identifies the type by the file name.
        // Ex.: "-anais."
        string identifier;
        identifier = "-";
        identifier.append(type);
        identifier.append(".");

        // If the file name contains the identifier...
        if(path.find(identifier) != string::npos)
            return type;

    }

    // If none of the identifiers have been found...
    return nullptr;
}

int to_int(const std::string & str) {
    if(str.find(".") != std::string::npos || str.find(",") != std::string::npos)
        return -1;

    std::istringstream iss(str);

    int n;

    iss >> n;

    return n;
}

bool Stats::is_editorial() {

    PublicationType type = get_type();

    // Using an array to search for the wanted element.
    PublicationType editorials[] = {PublicationType::BOOK,  PublicationType::PERIODIC, PublicationType::MAGAZINE,
                                    PublicationType::MUSIC, PublicationType::GENERIC};

    auto found = find(begin(editorials), end(editorials), type);

    // If the type is in the editorial types array, return true.
    if(found != end(editorials))
        return true;

    return false;
}

string Stats::try_to_get(const string & index) {
    try {
        return csv.getFromCachedLine(index);
    } catch (exception & e) {
        return nullptr;
    }
}

PublicationType Stats::get_type() {
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

bool is_csv(const std::string & file_path) {

    // Using string.find() to search for the ".csv" extension in the file path.
    if(file_path.find(".csv") != std::string::npos)
        return true;

    else return false;

}

void Stats::read() {

    // Translating from string to enum.
    PublicationType type = get_type();

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
        nature   = try_to_get("DS_NATUREZA");
        title    = try_to_get("NM_TITULO");
        language = try_to_get("DS_IDIOMA");
        if(type == PublicationType::BOOK)
            city = try_to_get("NM_CIDADE_PAIS");
        else
            city = try_to_get("NM_CIDADE");
        uni_s = try_to_get("SG_ENTIDADE_ENSINO");
        uni_n = try_to_get("NM_ENTIDADE_ENSINO");
        g_id  = try_to_get("CD_PROGRAMA_IES");
        g_n   = try_to_get("NM_PROGRAMA_IES");


        // Getting data for editorials
        if(is_editorial())
            editor = try_to_get("NM_EDITORA");
        if(type == PublicationType::TRANSLATION)
            editor = try_to_get("NM_EDITORA_TRADUCAO");

        // Getting ISSN
        if(type == PublicationType::PERIODIC || type == PublicationType::MAGAZINE)
            serial = try_to_get("DS_ISSN");

        // Getting ISBN
        if(type == PublicationType::BOOK)
            serial = try_to_get("DS_ISBN");

        // Getting newspaper and magazine data
        if(type == PublicationType::MAGAZINE)
            p_date = try_to_get("DT_PUBLICACAO");

        // Getting periodic data
        if(type == PublicationType::PERIODIC) {

            volume   = try_to_get("NR_VOLUME");
            fascicle = try_to_get("DS_FASCICULO");
            series   = try_to_get("NR_SERIE");

            // Fixing the numbers
            volume   = std::to_string(to_int(volume));
            fascicle = std::to_string(to_int(fascicle));
            series   = std::to_string(to_int(series));

        }

        // Getting musical piece data
        if(type == PublicationType::MUSIC)
            instruments = try_to_get("DS_FORMACAO_INSTRUMENTAL");

        // Getting translated article data
        if(type == PublicationType::TRANSLATION)
            translation = try_to_get("DS_IDIOMA_TRADUCAO");

        // Getting annal publication data
        if(type == PublicationType::BOOK)
            annal = try_to_get("DS_EVENTO");

        // Getting pages data.

        if(type == PublicationType::BOOK)
            last = to_int(try_to_get("NR_PAGINAS_CONTRIBUICAO")) - 1;

        else if(type == PublicationType::MUSIC || type == PublicationType::GENERIC || type == PublicationType::TRANSLATION)
            last = to_int(try_to_get("NR_PAGINAS")) - 1;

        else {
            first = to_int(try_to_get("NR_PAGINA_INICIAL"));
            last  = to_int(try_to_get("NR_PAGINA_FINAL"));
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

        // TODO: Add University and Graduation Program here.

        university->add(program);
        // program->add(publication);

        // TODO: Finish this function.
    }
}

void Stats::add_gradprogram(GradProgram * gradprogram) {
    // TODO: Implement
}

void Stats::add_university(University * university) {
    // TODO: Implement
}

}