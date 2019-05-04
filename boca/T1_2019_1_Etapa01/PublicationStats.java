import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PublicationStats {

    private ArrayList<University> u_list;
    private ArrayList<Publication> p_list;
    private ArrayList<GradProgram> g_list;


    public PublicationStats() {
        // Creating the lists of items.
        u_list = new ArrayList<University>();
        p_list = new ArrayList<Publication>();
        g_list = new ArrayList<GradProgram>();
    }

    public String getAnnalsStats() {
        return "batata";
    }

    public void fromCSV(File f) {

        try {
            Scanner in = new Scanner(f);

            // First Line goes to trash.
            String trash;
            if(in.hasNextLine())
                trash = in.nextLine();

            /*
            INDEXES TABLE:
            INDEX | INFO                          | UTIL PARA O PROGRAMA?
            0     | CD_PROGRAMA_IES               |
            1     | NM_PROGRAMA_IES               | GradProgram
            2     | SG_ENTIDADE_ENSINO            |
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

            // Reading the CSV file
            while(in.hasNextLine()) {
                String[] split_line;
                String   line;
                
                line = in.nextLine();
                split_line = line.split(";");

                University u = new University(split_line[3]);
                GradProgram g = new GradProgram(split_line[1], split_line[3]);
                Publication p;
                
                // Creating the Publication
                if(split_line[13].equals(" - ") || split_line[14].equals(" - ")) {
                    p = new Publication(split_line[9], split_line[3], split_line[1], false, 0, 0);
                } else {
                    p = new Publication(
                                        split_line[9], split_line[3], split_line[1],
                                        true, Integer.parseInt(split_line[14]), Integer.parseInt(split_line[13])
                                    );
                }

                // Adding to the 'database'
                addUniversity(u);
                addGradProgram(g);
                addPublication(p);

            }
        } catch(FileNotFoundException e) {
            System.out.println("Erro de I/O");
            return;
        } 

        
        
    }

    public void addUniversity(University u) {
        if(!u_list.contains(u))
            u_list.add(u);
    }

    public void addGradProgram(GradProgram g) {
        if(!g_list.contains(g))
            g_list.add(g);
    }

    public void addPublication(Publication p) {
        if(!p_list.contains(p))
            p_list.add(p);
    }

}