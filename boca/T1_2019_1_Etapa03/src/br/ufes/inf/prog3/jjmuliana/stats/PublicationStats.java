package br.ufes.inf.prog3.jjmuliana.stats;

import java.io.*;
import java.util.*;
import br.ufes.inf.prog3.jjmuliana.csvreader.CSVReader;
import br.ufes.inf.prog3.jjmuliana.publication.*;
import br.ufes.inf.prog3.jjmuliana.university.University;
import br.ufes.inf.prog3.jjmuliana.gradprogram.GradProgram;
import br.ufes.inf.prog3.jjmuliana.university.UniversityComparator;

/**
 * @author J. Jorge M. Uliana
 * @version 1.4
 */

public class PublicationStats {

    private UniversityList u_list;
    private PublicationList p_list;
    private GradProgramList g_list;

    public PublicationStats() {
        // Creating the lists of items.
        u_list = new UniversityList();
        p_list = new PublicationList();
        g_list = new GradProgramList();
    }

    public void followCommand(StatsCommand c) {

        // This function is responsible for the interpretation of the command.

        if(c.equals(StatsCommand.REDE)) {
            printNetworks();
        } else if(c.equals(StatsCommand.PPG)) {
            printProgramData(c.getSubCommand());
        } else if(c.equals(StatsCommand.IES)) {
            printUniversityData(c.getSubCommand());
        } else if(c.equals(StatsCommand.CSV)) {
            generateCSV(c.getSubCommand(0), c.getSubCommand(1));
        }
    }

    public void generateCSV(String gpid /* grad program id */, String prodtype /* production type */) {

        // Printing the header
        if(prodtype.equals(PublicationConst.MUSIC.toString())) {
            System.out.println("Natureza;Editora;Cidade;Formacao;Paginas");
            GradProgram g = g_list.get(gpid);
            g.printCSVStyleTable(";", prodtype);
            return;
        }
        if(!prodtype.equals(PublicationConst.MAGAZINE.toString()))
            System.out.print("Natureza;");
        if(!prodtype.equals(PublicationConst.PERIODIC.toString()))
            System.out.print("Titulo;");
        System.out.print("Idioma;");
        if(prodtype.equals(PublicationConst.ANNAL.toString())) {
            System.out.print("Evento;Cidade;");
        } else {
            if(!prodtype.equals(PublicationConst.MAGAZINE.toString()))
                System.out.print("Editora;");
            System.out.print("Cidade;");
            if(prodtype.equals(PublicationConst.MAGAZINE.toString())) {
                System.out.print("Data;ISSN;");
            } else if(prodtype.equals(PublicationConst.PERIODIC.toString())) {
                System.out.print("Volume;Fasciculo;Serie;ISSN;");
            } else if(prodtype.equals(PublicationConst.BOOK.toString())) {
                System.out.print("ISBN;");
            } else if(prodtype.equals(PublicationConst.TRANSLATION.toString())) {
                System.out.print("Idioma traducao;");
            }
        }
        System.out.println("Paginas");

       // Getting GradProgram
       GradProgram g = g_list.get(gpid);
       g.printCSVStyleTable(";", prodtype);


    }

    public void printUniversityData(String university_sn) {

        Set<University> unilist = u_list.getFromShortName(university_sn);

        Iterator<University> iterator = unilist.iterator();

        while(iterator.hasNext())
            iterator.next().printData();
    }

    public void printProgramData(String program_id) {
        g_list.printProgramData(program_id);
    }

    public void printAnnalsStats() {

        int itPIA, ptPIA, amountPIA, amountPages;
        double avePages;

        // Getting the amount of institutions that published in annals.
        itPIA = u_list.size();
        // Getting the amount of project that were published in annals.
        amountPIA = p_list.size();
        // Getting the amount of graduate programs that published in annals.
        ptPIA = g_list.size();
        // Getting the ave pages.
        avePages = p_list.getAveragePagesNum();
        // Getting the amount of pages published.
        amountPages = p_list.getValidPagesSum();

        //Printing the stats as requested:
        System.out.printf(new Locale("pt", "BR"),
                "Instituicoes que publicaram em anais: %d\nPPGs que publicaram em anais: %d\n" +
                        "Quantidade de producoes em anais: %d\nQuantidade de paginas publicadas em anais: %d\n" +
                        "Media de paginas por publicacao: %.1f\n",
                itPIA, ptPIA, amountPIA, amountPages, avePages
        );

    }

    public void printNetworks() {
        g_list.printNetworks();
    }

    public void fromCSV(File f, String type) {

        /*
        INDEXES TABLE:
        INDEX | INFO                          | UTIL PARA O PROGRAMA?
        0     | CD_PROGRAMA_IES               | br.ufes.inf.prog3.jjmuliana.gradprogram.GradProgram
        1     | NM_PROGRAMA_IES               | br.ufes.inf.prog3.jjmuliana.gradprogram.GradProgram
        2     | SG_ENTIDADE_ENSINO            | University
        3     | NM_ENTINDADE_ENSINO           | University
        4     | AN_BASE_PRODUCAO              |
        5     | ID_ADD_PRODUCAO_INTELECTUAL   |
        6     | ID_TIPO_PRODUCAO              |
        7     | ID_SUBTIPO_PRODUCAO           |
        8     | DS_NATUREZA                   |
        9     | NM_TITULO                     | br.ufes.inf.prog3.jjmuliana.publication.Publication / Annal
        10    | NR_VOLUME                     |
        11    | DS_FASCICULO                  |
        12    | NR_SERIE                      |
        13    | NR_PAGINA_FINAL               | br.ufes.inf.prog3.jjmuliana.publication.Publication
        14    | NR_PAGINA_INICIAL             | br.ufes.inf.prog3.jjmuliana.publication.Publication
        15    | DS_EVENTO                     |
        16    | NM_CIDADE                     |
        17    | NM_PAIS                       |
        18    | DS_IDIOMA                     |
        19    | DS_DIVULGACAO                 |
        20    | DS_URL                        |
        21    | DS_OBSERVACOES                |
        22    | NR_EDICAO                     |
        23    | DS_ISBN_ISSN                  |
        24    | IN_GLOSA                      |
         */

        if(type == null)
            return;

        CSVReader csv =
                new CSVReader(f, ";(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)",false, true);

        while (true) {

            // Defining the university name.
            csv.nextLine();
            if(!csv.hasNextLine())
                break;

            String natur_ar; // Article nature
            String title_ar; // Article title
            String langu_ar; // Article language
            String cityn_ar; // Article city

            String uni_name; // University name
            String sho_name; // Short name of university

            String grd_code; // GradProgram name
            String grd_name; // GradProgram code

            String ana_name; // Event name

            String iss_isbn; // ISSN or ISBN
            String editor_a; // Editorial editor

            String publi_dt; // Publishing date

            String volume_a; // Periodic volume
            String fascic_a; // Periodic fascicle
            String series_a; // Periodic series

            String instrume; // Instrumental formation

            String translat; // Translated language

            int first_page = 0;
            int last_page = 0;
            boolean has_pages = false;

            // Inserting some default values:
            editor_a = null;
            iss_isbn = null;
            ana_name = null;
            publi_dt = null;
            volume_a = null;
            fascic_a = null;
            series_a = null;
            instrume = null;
            translat = null;

            // Getting the data

            try {
                natur_ar = csv.getCachedLineContent("DS_NATUREZA");
                title_ar = csv.getCachedLineContent("NM_TITULO");
                langu_ar = csv.getCachedLineContent("DS_IDIOMA");
                cityn_ar = csv.getCachedLineContent("NM_CIDADE");
                sho_name = csv.getCachedLineContent(2);
                uni_name = csv.getCachedLineContent(3);
                grd_code = csv.getCachedLineContent(0);
                grd_name = csv.getCachedLineContent(1);
            } catch(Exception e) {
                break;
            }

            // Getting the data for editorials
            if(type.equals(PublicationConst.BOOK.toString()) || type.equals(PublicationConst.PERIODIC.toString()) ||
                    type.equals(PublicationConst.MAGAZINE.toString()) || type.equals(PublicationConst.MUSIC.toString())
                    || type.equals(PublicationConst.TRANSLATION.toString())
                    || type.equals(PublicationConst.GENERIC.toString()) )
            {
                try {
                    editor_a = csv.getCachedLineContent("NM_EDITORA");
                } catch(Exception e) {
                    editor_a = null;
                }
            }

            // Getting ISSN
            if(type.equals(PublicationConst.PERIODIC.toString()) || type.equals(PublicationConst.MAGAZINE.toString())) {
                try {
                    iss_isbn = csv.getCachedLineContent("DS_ISSN");
                } catch(Exception e) {
                    iss_isbn = null;
                }
            }

            // Getting ISBN
            if(type.equals(PublicationConst.BOOK.toString())) {
                try {
                    iss_isbn = csv.getCachedLineContent("DS_ISBN");
                } catch(Exception e) {
                    iss_isbn = null;
                }
            }

            // Getting newspaper and magazine data
            if(type.equals(PublicationConst.MAGAZINE.toString())) {
                try {
                    publi_dt = csv.getCachedLineContent("DT_PUBLICACAO");
                } catch(Exception e) {
                    publi_dt = null;
                }
            }

            // Getting periodic data
            if(type.equals(PublicationConst.PERIODIC.toString())) {
                try {
                    volume_a = csv.getCachedLineContent("NR_VOLUME");
                    fascic_a = csv.getCachedLineContent("DS_FASCICULO");
                    series_a = csv.getCachedLineContent("NR_SERIE");
                } catch(Exception e) {
                    volume_a = null;
                    fascic_a = null;
                    series_a = null;
                }

                /* Fixing the numbers problem:
                RESOLUTION LOGIC:
                try to convert in integer and then in string again.
                if it fails, null the value.
                 */
                try {
                    volume_a = String.valueOf(Integer.parseInt(volume_a));
                } catch(Exception e) {
                    volume_a = null;
                }
                try {
                    fascic_a = String.valueOf(Integer.parseInt(fascic_a));
                } catch(Exception e) {
                    fascic_a = null;
                }
                try {
                    series_a = String.valueOf(Integer.parseInt(series_a));
                } catch (Exception e) {
                    series_a = null;
                }
            }

            // Getting data for musical piece
            if(type.equals(PublicationConst.MUSIC.toString())) {
                try {
                    instrume = csv.getCachedLineContent("DS_FORMACAO_INSTRUMENTAL");
                } catch (Exception e) {
                    instrume = null;
                }
            }

            // Getting translated article data
            if(type.equals(PublicationConst.TRANSLATION.toString())) {
                try {
                    translat = csv.getCachedLineContent("DS_IDIOMA_TRADUCAO");
                } catch(Exception e) {
                    translat = null;
                }
            }

            // Getting data for annal
            if(type.equals(PublicationConst.ANNAL.toString())) {
                try {
                    ana_name = csv.getCachedLineContent("DS_EVENTO");
                } catch (Exception e) {

                }
            }

            try {
                if(type.equals(PublicationConst.BOOK.toString())) {
                    last_page = Integer.parseInt(csv.getCachedLineContent("NR_PAGINAS_CONTRIBUICAO")) - 1;
                } else if(type.equals(PublicationConst.MUSIC.toString()) ||
                        type.equals(PublicationConst.GENERIC.toString()) ||
                        type.equals(PublicationConst.TRANSLATION.toString())) {
                    last_page = Integer.parseInt(csv.getCachedLineContent("NR_PAGINAS")) - 1;
                } else {
                    first_page = Integer.parseInt(csv.getCachedLineContent("NR_PAGINA_INICIAL"));
                    last_page = Integer.parseInt(csv.getCachedLineContent("NR_PAGINA_FINAL"));
                }
                has_pages = true;
            } catch (NumberFormatException e) {
                first_page = last_page = 0;
                has_pages = false;
            }

            // Creating the data.
            University uni;
            GradProgram gp;

            uni = new University(uni_name, sho_name);
            gp  = new GradProgram(grd_code, grd_name);

            /*
             * Pages must only be considered if:
             * 1. They are integer positive numbers.
             * 2. If the initial page is smaller than the final page.
             * 3. If the difference between them is below 2000 pages.
             * */

            if (first_page < 0 || last_page < 0 || last_page - first_page >= 2000 || last_page - first_page < 0)
                has_pages = false;

            Publication publi;

            if(type.equals(PublicationConst.BOOK.toString()))
                publi = new BookPublication(title_ar, langu_ar, cityn_ar, has_pages, first_page, last_page, editor_a, iss_isbn);

            else if(type.equals(PublicationConst.ANNAL.toString()))
                publi = new AnnalPublication(title_ar, langu_ar, cityn_ar, has_pages, first_page, last_page, ana_name);

            else if(type.equals(PublicationConst.MAGAZINE.toString()))
                publi = new MagazinePublication(title_ar, langu_ar, cityn_ar, has_pages, first_page, last_page, editor_a, iss_isbn,
                        publi_dt);

            else if(type.equals(PublicationConst.PERIODIC.toString()))
                publi = new PeriodicPublication(title_ar, langu_ar, cityn_ar, has_pages, first_page, last_page, editor_a,
                        iss_isbn, volume_a, fascic_a, series_a);

            else if(type.equals(PublicationConst.MUSIC.toString()))
                publi = new MusicalPiece(title_ar, langu_ar, cityn_ar, has_pages, first_page, last_page, editor_a, instrume);

            else if(type.equals(PublicationConst.TRANSLATION.toString()))
                publi = new TranslatedPublication(title_ar, langu_ar, cityn_ar, has_pages, first_page, last_page, editor_a,
                        translat);

            else
                publi = new GenericPublication(title_ar, langu_ar, cityn_ar, has_pages, first_page, last_page, editor_a);

            publi.setNature(natur_ar);

            p_list.addPublication(publi);
            u_list.addUniversity(uni, gp);
            g_list.addGradProgram(gp, uni, publi);
        }


    }

    public void fromCSV(File f) {
        String type = getTypeFromPath(f.getPath());
        fromCSV(f, type);
    }

    public static String getTypeFromPath(String file_path) {
        if(file_path.contains("-anais."))
            return "anais";
        else if(file_path.contains("-artjr."))
            return "artjr";
        else if(file_path.contains("-artpe."))
            return "artpe";
        else if(file_path.contains("-livro."))
            return "livro";
        else if(file_path.contains("-partmu."))
            return "partmu";
        else if(file_path.contains("-tradu."))
            return "tradu";
        else if(file_path.contains("-outro."))
            return "outro";
        else return null;
    }

}

// Auxiliar classes:
class UniversityList {
    private Map<String, University> u;

    UniversityList() {
        u = new HashMap<>();
    }

    void addUniversity(University uni, GradProgram gp) {
        if(!u.containsKey(uni.getHashKey()))
            u.put(uni.getHashKey(), uni);
        // Common operations
        u.get(uni.getHashKey()).addGraduateProgram(gp);
    }

    int size() {
        return u.size();
    }

    Set<University> getFromShortName(String shortn) {
        Object[] keys = u.keySet().toArray();

        Set<University> l;
        l = new TreeSet<>(); // List of universities that have the short name.

        // Filling the list
        for(Object key : keys) {
            if(key.toString().contains("-" + shortn.toLowerCase() + "-"))
                l.add(u.get(key));
        }

        // Returning the array of wanted universities.
        return l;
    }
}

class PublicationList {
    private Map<Integer, Publication> p;
    private int valid_pages_sum = 0;
    private int valid_publications_num = 0;

    PublicationList() {
        p = new HashMap<>();
    }

    void addPublication(Publication publ) {
        p.put(publ.getHashKey(), publ);
        valid_pages_sum += publ.getPages(); /* Counting the valid pages */
        if(publ.hasPageNumber()) valid_publications_num += 1; /* Counting the valid publications */
    }

    int size() {
        return p.size();
    }

    int getValidPagesSum() {
        return valid_pages_sum;
    }

    int getValidPublicationsNum() {
        return valid_publications_num;
    }

    public double getAveragePagesNum() {
        return (double)valid_pages_sum/(double)valid_publications_num;
    }
}

class GradProgramList {
    private Map<String, GradProgram> g;

    GradProgramList() {
        g = new HashMap<>();
    }

    void addGradProgram(GradProgram grp, University u, Publication p) {
        boolean isInSet = false;
        if(g.containsKey(grp.getHashKey())) {
            isInSet = true;
            grp = g.get(grp.getHashKey());
        }
        // common operations:
        grp.plusPublication(p);
        grp.addUniversity(u);

        // else ...
        if(!isInSet)
            g.put(grp.getHashKey(), grp);
    }

    int size() {
        return g.size();
    }

    void printNetworks() {
        System.out.println("Programas em rede:");

        Object[] key_set = g.keySet().toArray();
        Arrays.sort(key_set);

        GradProgram gp;

        for(Object key : key_set) {
            gp = g.get(key);

            if(gp.getUniversitiesNumber() > 1) {
                System.out.println(gp.toString()); // Printing the grad. prog. ID and name.
                gp.printUniversitiesList(); // Printing the universities list.
            }
        }
    }

    void printProgramData(String program_id) {
        if(g.containsKey(program_id.trim()))
            g.get(program_id).printData();
        else
            System.out.println("PPG nao encontrado.");
    }

    GradProgram get(String id) {
        return g.get(id);
    }
}