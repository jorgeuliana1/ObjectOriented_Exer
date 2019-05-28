package br.ufes.inf.prog3.jjmuliana.stats;

import java.io.File;
import java.util.*;
import br.ufes.inf.prog3.jjmuliana.csvreader.CSVReader;
import br.ufes.inf.prog3.jjmuliana.university.University;
import br.ufes.inf.prog3.jjmuliana.publication.Publication;
import br.ufes.inf.prog3.jjmuliana.gradprogram.GradProgram;

/**
 * @author J. Jorge M. Uliana
 * @version 1.2
 */

public class PublicationStats {

    private Map<String, University>   u_list;
    private Map<Integer, Publication> p_list;
    private Map<String, GradProgram>   g_list;

    // Stats vars:
    private int valid_pages_sum = 0;
    private int valid_publications_num = 0;


    public PublicationStats() {
        // Creating the lists of items.
        u_list = new HashMap<>();
        p_list = new HashMap<>();
        g_list = new HashMap<>();
    }

    public void followCommand(StatsCommand c) {
        if(c.equals(StatsCommand.REDE)) {
            printNetworks();
        }
    }

    public void printProgramData(String program_id) {
        // Work here
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
        avePages = getAveragePagesNumber();
        // Getting the amount of pages published.
        amountPages = valid_pages_sum;

        //Printing the stats as requested:
        System.out.printf(new Locale("pt", "BR"),
                "Instituicoes que publicaram em anais: %d\nPPGs que publicaram em anais: %d\n" +
                        "Quantidade de producoes em anais: %d\nQuantidade de paginas publicadas em anais: %d\n" +
                        "Media de paginas por publicacao: %.1f\n",
                itPIA, ptPIA, amountPIA, amountPages, avePages
        );

    }

    public void printNetworks() {

        System.out.println("Programas em rede:");

        Object[] key_set = g_list.keySet().toArray();
        Arrays.sort(key_set);

        GradProgram gp;

        for(Object key : key_set) {
            gp = g_list.get(key);

            if(gp.getUniversitiesNumber() > 1) {
                System.out.println(gp.toString()); // Printing the grad. prog. ID and name.
                gp.printUniversitiesList(); // Printing the universities list.
            }
        }
    }

    public void fromCSV(File f, boolean store_uni, boolean store_grp, boolean store_arct) {

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

        CSVReader csv = new CSVReader(f, ";(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", false, true);

        // Optimizing the function.
        if(store_grp && !store_arct && !store_uni) {
            fromCSVOnlyGRP(csv);
            return;
        }

        while (true) {

            // Defining the university name.
            csv.nextLine();
            if(!csv.hasNextLine())
                break;

            String uni_name;
            String sho_name;
            String grd_code;
            String grd_name;
            String ana_name;

            int first_page = 0;
            int last_page = 0;
            boolean has_pages = false;

            // Getting the data
            try {
                sho_name = csv.getCachedLineContent(2);
                uni_name = csv.getCachedLineContent(3);
                grd_code = csv.getCachedLineContent(0);
                grd_name = csv.getCachedLineContent(1);
                ana_name = csv.getCachedLineContent(9);
            } catch(Exception e) {
                break;
            }

            if(store_arct) {
                try {
                    first_page = Integer.parseInt(csv.getCachedLineContent(14));
                    last_page = Integer.parseInt(csv.getCachedLineContent(13));
                    has_pages = true;
                } catch (NumberFormatException e) {
                    first_page = last_page = 0;
                    has_pages = false;
                }
            }

            // Creating the data.
            University uni;
            GradProgram gp;

            uni = new University(uni_name, sho_name);
            gp  = new GradProgram(grd_code, grd_name);


            if(store_uni)
                addUniversity(uni);
            if(store_grp)
                addGradProgram(gp, uni);


            /*
             * Pages must only be considered if:
             * 1. They are integer positive numbers.
             * 2. If the initial page is smaller than the final page.
             * 3. If the difference between than are below than 2000 pages.
             * */

            if (store_arct &&
                    (first_page < 0 || last_page < 0 || last_page - first_page >= 2000 || last_page - first_page < 0))
                has_pages = false;

            if(store_arct)
                addPublication(new Publication(ana_name, uni_name, grd_name, has_pages, first_page, last_page));
        }


    }

    public void fromCSV(File f) {
        fromCSV(f, true, true, true);
    }

    private void fromCSVOnlyGRP(CSVReader csv) {
        while (true) {
            // Defining the university name.
            csv.nextLine();
            if (!csv.hasNextLine())
                break;

            String uni_name;
            String sho_name;
            String grd_code;
            String grd_name;

            try {
                sho_name = csv.getCachedLineContent(2);
                uni_name = csv.getCachedLineContent(3);
                grd_code = csv.getCachedLineContent(0);
                grd_name = csv.getCachedLineContent(1);
            } catch (Exception e) {
                break;
            }

            // Creating the data.
            University uni;
            GradProgram gp;

            uni = new University(uni_name, sho_name);
            gp = new GradProgram(grd_code, grd_name);

            addGradProgram(gp, uni);
        }
    }

    public void addUniversity(University u) {
        u_list.put(u.getHashKey(), u);
    }

    public void addGradProgram(GradProgram g, University u) {

        if(g_list.containsKey(g.getHashKey())) {
            g_list.get(g.getHashKey()).addUniversity(u);
            return;
        }
        // else ...
        g_list.put(g.getHashKey(), g);
    }

    public void addPublication(Publication p) {
        p_list.put(p.getHashKey(), p);
        valid_pages_sum += p.getPages(); /* Counting the valid pages */
        if(p.hasPageNumber()) valid_publications_num += 1; /* Counting the valid publications */
    }

    public double getAveragePagesNumber() {
        return (double)valid_pages_sum/(double)valid_publications_num;
    }

}