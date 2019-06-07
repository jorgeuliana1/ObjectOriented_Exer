package br.ufes.inf.prog3.jjmuliana.stats;

import java.io.*;
import java.util.*;
import br.ufes.inf.prog3.jjmuliana.csvreader.CSVReader;
import br.ufes.inf.prog3.jjmuliana.publication.*;
import br.ufes.inf.prog3.jjmuliana.university.University;
import br.ufes.inf.prog3.jjmuliana.gradprogram.GradProgram;

/**
 * @author Jose Jorge M. Uliana
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
       GradProgram g = g_list.get(gpid); /* getting GradProgram */
       Publication.printCSVStyleHeader(prodtype); /* printing the header */
       g.printCSVStyleTable(";", prodtype); /* printing the table */
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
            String ana_name = null; // Event name
            String iss_isbn = null; // ISSN or ISBN
            String editor_a = null; // Editorial editor
            String publi_dt = null; // Publishing date
            String volume_a = null; // Periodic volume
            String fascic_a = null; // Periodic fascicle
            String series_a = null; // Periodic series
            String instrume = null; // Instrumental formation
            String translat = null; // Translated language

            int first_page = 0, last_page;
            boolean has_pages = false;

            try {
                // Fundamental info, if we can't get it we break the loop.
                natur_ar = csv.getCachedLineContent("DS_NATUREZA");
                title_ar = csv.getCachedLineContent("NM_TITULO");
                langu_ar = csv.getCachedLineContent("DS_IDIOMA");
                cityn_ar = csv.getCachedLineContent("NM_CIDADE");
                sho_name = csv.getCachedLineContent("SG_ENTIDADE_ENSINO");
                uni_name = csv.getCachedLineContent("NM_ENTIDADE_ENSINO");
                grd_code = csv.getCachedLineContent("CD_PROGRAMA_IES");
                grd_name = csv.getCachedLineContent("NM_PROGRAMA_IES");
            } catch(Exception e) {
                break;
            }

            // Getting the data for editorials
            if(type.equals(PublicationConst.BOOK.toString()) || type.equals(PublicationConst.PERIODIC.toString()) ||
                    type.equals(PublicationConst.MAGAZINE.toString()) || type.equals(PublicationConst.MUSIC.toString())
                    || type.equals(PublicationConst.TRANSLATION.toString())
                    || type.equals(PublicationConst.GENERIC.toString()) )
                editor_a = tryToGetData(csv, "NM_EDITORA");

            // Getting ISSN
            if(type.equals(PublicationConst.PERIODIC.toString()) || type.equals(PublicationConst.MAGAZINE.toString()))
                iss_isbn = tryToGetData(csv, "DS_ISSN");

            // Getting ISBN
            if(type.equals(PublicationConst.BOOK.toString()))
                iss_isbn = tryToGetData(csv, "DS_ISBN");

            // Getting newspaper and magazine data
            if(type.equals(PublicationConst.MAGAZINE.toString()))
                publi_dt = tryToGetData(csv, "DT_PUBLICACAO");

            // Getting periodic data
            if(type.equals(PublicationConst.PERIODIC.toString())) {

                volume_a = tryToGetData(csv, "NR_VOLUME");
                fascic_a = tryToGetData(csv, "DS_FASCICULO");
                series_a = tryToGetData(csv, "NR_SERIE");

                /* Fixing the numbers problem:
                RESOLUTION LOGIC:
                try to convert in integer and then in string again.
                if it fails, null the value.
                 */
                volume_a = tryToParse(volume_a);
                fascic_a = tryToParse(fascic_a);
                series_a = tryToParse(series_a);
            }

            // Getting data for musical piece
            if(type.equals(PublicationConst.MUSIC.toString()))
                instrume = tryToGetData(csv, "DS_FORMACAO_INSTRUMENTAL");

            // Getting translated article data
            if(type.equals(PublicationConst.TRANSLATION.toString()))
                translat = tryToGetData(csv, "DS_IDIOMA_TRADUCAO");

            // Getting data for annal
            if(type.equals(PublicationConst.ANNAL.toString()))
                ana_name = tryToGetData(csv, "DS_EVENTO");

            // Getting the pages.
            if(type.equals(PublicationConst.BOOK.toString())) {
                last_page = tryToGetPositiveInt(csv, "NR_PAGINAS_CONTRIBUICAO") - 1;
            }
            else if(type.equals(PublicationConst.MUSIC.toString()) ||
                    type.equals(PublicationConst.GENERIC.toString()) ||
                    type.equals(PublicationConst.TRANSLATION.toString())) {
                last_page = tryToGetPositiveInt(csv, "NR_PAGINAS") - 1;
            } else {
                first_page = tryToGetPositiveInt(csv, "NR_PAGINA_INICIAL");
                last_page = tryToGetPositiveInt(csv, "NR_PAGINA_FINAL");
            }

            // Creating the data.
            University uni;
            GradProgram grp;

            uni  = new University(uni_name, sho_name);
            grp  = new GradProgram(grd_code, grd_name);

            /*
             * Pages must only be considered if:
             * 1. They are integer positive numbers.
             * 2. If the initial page is smaller than the final page.
             * 3. If the difference between them is below 2000 pages.
             * */

            // Creating the publication.
            Publication publi;
            if(type.equals(PublicationConst.BOOK.toString()))
                publi = new BookPublication(title_ar, langu_ar, cityn_ar, last_page, editor_a, iss_isbn);
            else if(type.equals(PublicationConst.ANNAL.toString()))
                publi = new AnnalPublication(title_ar, langu_ar, cityn_ar, first_page, last_page, ana_name);
            else if(type.equals(PublicationConst.MAGAZINE.toString()))
                publi = new MagazinePublication(title_ar, langu_ar, cityn_ar, first_page, last_page, editor_a, iss_isbn,
                        publi_dt);
            else if(type.equals(PublicationConst.PERIODIC.toString()))
                publi = new PeriodicPublication(title_ar, langu_ar, cityn_ar, first_page, last_page, editor_a,
                        iss_isbn, volume_a, fascic_a, series_a);
            else if(type.equals(PublicationConst.MUSIC.toString()))
                publi = new MusicalPiece(title_ar, langu_ar, cityn_ar, last_page, editor_a, instrume);
            else if(type.equals(PublicationConst.TRANSLATION.toString()))
                publi = new TranslatedPublication(title_ar, langu_ar, cityn_ar, last_page, editor_a,
                        translat);
            else
                publi = new GenericPublication(title_ar, langu_ar, cityn_ar, last_page, editor_a);

            publi.setNature(natur_ar);

            //p_list.addPublication(publi);
            grp = g_list.addGradProgram(grp, uni, publi);
            uni = u_list.addUniversity(uni, grp);
        }

    }

    public void fromCSV(File f) {
        String type = getTypeFromPath(f.getPath());
        fromCSV(f, type);
    }

    private String tryToGetData(CSVReader file, String index) {
        try {
            return file.getCachedLineContent(index);
        } catch(Exception e) {
            return null;
        }

    }

    private String tryToParse(String number) {
        try {
            return String.valueOf(Integer.parseInt(number));
        } catch (Exception e) {
            return null;
        }
    }

    private int tryToGetPositiveInt(CSVReader file, String index) {
        try {
            return Integer.parseInt(file.getCachedLineContent(index));
        } catch (Exception e) {
            return -1;
        }
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

