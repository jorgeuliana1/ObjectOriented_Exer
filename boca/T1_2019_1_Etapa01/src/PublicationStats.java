import java.io.File;
import java.util.LinkedList;

/**
 * @author J. Jorge M. Uliana
 * @version 1.0
 */

public class PublicationStats {

    private LinkedList<University> u_list;
    private LinkedList<Publication> p_list;
    private LinkedList<GradProgram> g_list;

    // Stats vars:
    private int valid_pages_sum = 0;
    private int valid_publications_num = 0;


    public PublicationStats() {
        // Creating the lists of items.
        u_list = new LinkedList<>();
        p_list = new LinkedList<>();
        g_list = new LinkedList<>();
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
        System.out.printf(
                "Instituicoes que publicaram em anais: %d\nPPGs que publicaram em anais: %d\n" +
                        "Quantidade de producoes em anais: %d\nQuantidade de paginas publicadas em anais: %d\n" +
                        "Media de paginas por publicacao: %.1f\n",
                itPIA, ptPIA, amountPIA, amountPages, avePages
        );

    }

    public void fromCSV(File f) {

        /*
        INDEXES TABLE:
        INDEX | INFO                          | UTIL PARA O PROGRAMA?
        0     | CD_PROGRAMA_IES               | GradProgram
        1     | NM_PROGRAMA_IES               |
        2     | SG_ENTIDADE_ENSINO            | University
        3     | NM_ENTINDADE_ENSINO           | University
        4     | AN_BASE_PRODUCAO              |
        5     | ID_ADD_PRODUCAO_INTELECTUAL   |
        6     | ID_TIPO_PRODUCAO              |
        7     | ID_SUBTIPO_PRODUCAO           |
        8     | DS_NATUREZA                   |
        9     | NM_TITULO                     | Publication / Annal
        10    | NR_VOLUME                     |
        11    | DS_FASCICULO                  |
        12    | NR_SERIE                      |
        13    | NR_PAGINA_FINAL               | Publication
        14    | NR_PAGINA_INICIAL             | Publication
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

        CSVReader csv = new CSVReader(f, ";(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)", true);

        int csv_rows = csv.getSize()[0];

        for (int j = 1; j < csv_rows; j++) {

            // Defining the university name.
            String uni_name;
            String sho_name;
            sho_name = csv.getContent(j, 2);
            uni_name = csv.getContent(j, 3);

            addGradProgram(new GradProgram(csv.getContent(j, 0), uni_name));
            addUniversity(new University(uni_name, sho_name));

            /*
             * Pages must only be considered if:
             * 1. They are integer positive numbers.
             * 2. If the initial page is smaller than the final page.
             * 3. If the difference between than are below than 2000 pages.
             * */

            boolean pages;
            int first_page, last_page;
            if (!(isNumeric(csv.getContent(j, 14)) && isNumeric(csv.getContent(j, 13)))) {
                pages = false;
                first_page = last_page = 0;
            } else {

                pages = true;
                first_page = Integer.parseInt(csv.getContent(j, 14));
                last_page = Integer.parseInt(csv.getContent(j, 13));

                if (first_page < 0 || last_page < 0)
                    pages = false;

                if (last_page - first_page >= 2000 || last_page - first_page < 0)
                    pages = false;

            }

            addPublication(new Publication(csv.getContent(j, 9), csv.getContent(j, 3), csv.getContent(j, 1), pages, first_page, last_page));
        }


    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str); // Trying to parse a possible number
        } catch (NumberFormatException e) {
            return false; // Returns false if it is not a integer.
        }
        return true;
    }

    public void addUniversity(University u) {
        if (!u_list.contains(u))
            u_list.add(u);
    }

    public void addGradProgram(GradProgram g) {
        if (!g_list.contains(g))
            g_list.add(g);
    }

    public void addPublication(Publication p) {
        p_list.add(p);
        valid_pages_sum += p.getPages(); /* Counting the valid pages */
        if(p.hasPageNumber()) valid_publications_num += 1; /* Counting the valid publications */
    }

    public double getAveragePagesNumber() {
        return (double)valid_pages_sum/(double)valid_publications_num;
    }

}