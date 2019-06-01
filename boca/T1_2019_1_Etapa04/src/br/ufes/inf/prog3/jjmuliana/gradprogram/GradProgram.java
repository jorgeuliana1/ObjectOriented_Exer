package br.ufes.inf.prog3.jjmuliana.gradprogram;

import java.util.*;
import br.ufes.inf.prog3.jjmuliana.university.University;
import br.ufes.inf.prog3.jjmuliana.university.UniversityComparator;

/**
 * @author J. Jorge M. Uliana
 * @version 1.1
 */

public class GradProgram {

    private String program_id; /* graduate program id */
    private String program_name; /* graduate program name */
    private Map<String, University> university_map; /* tree containing universities */

    // Stats variables:
    private int p_annals;
    private int p_magazi;
    private int p_period;
    private int p_books;
    private int p_music;
    private int p_transl;
    private int p_miscel;

    private int published_pages = 0;
    private int valid_publications = 0;

    public GradProgram(String id, String n) {
        program_id = id;
        program_name = n;
        university_map = new HashMap<>();
        p_annals = p_magazi = p_period = p_books = p_music = p_transl = p_miscel = 0;
    }

    public void plusAnnalPublication() {
        p_annals++;
    }

    public void plusMagazinePublication() {
        p_magazi++;
    }

    public void plusPeriodicPublication() {
        p_period++;
    }

    public void plusBooksPublication() {
        p_books++;
    }

    public void plusMusicPublication() {
        p_music++;
    }

    public void plusTranslationPublication() {
        p_transl++;
    }

    public void plusGenericPublication() {
        p_miscel++;
    }

    public void plusPublication(String type) {
        switch(type) {
            case "anais":
                plusAnnalPublication();
                break;
            case "artjr":
                plusMagazinePublication();
                break;
            case "artpe":
                plusPeriodicPublication();
                break;
            case "livro":
                plusBooksPublication();
                break;
            case "partmu":
                plusMusicPublication();
                break;
            case "tradu":
                plusTranslationPublication();
                break;
            case "outro":
                plusGenericPublication();
                break;
            default:
                break;
        }
    }

    public void plusPublishedPages(int n) {
        published_pages+=n;
        valid_publications+=1;
    }

    public void addUniversity(University u) {
        university_map.put(u.getHashKey(), u);
    }

    public String getID() {
        return program_id;
    }

    public String getName() {
        return program_name;
    }

    @Override
    public boolean equals(Object a) {

        GradProgram ao = (GradProgram) a;
        return this.getID().equals(ao.getID());

    }

    @Override
    public int hashCode() {
        String lower_name = (program_id).toLowerCase().trim();

        // Getting a hash code from the string:
        int sum = 0;
        for(int i = 0; i < lower_name.length(); i++) {
            sum += (int)lower_name.charAt(i);
        }

        return 1;
    }

    public String getHashKey() {
        return (program_id);
    }

    public int getUniversitiesNumber() {
        return university_map.size();
    }

    @Override
    public String toString() {
        return (program_id + ": " + program_name);
    }

    public void printUniversitiesList() {

        // Helped by https://www.mkyong.com/java/how-to-sort-a-map-in-java/

        // Converting map to list:
        List<Map.Entry<String, University>> list
                = new LinkedList<>(university_map.entrySet());

        // Sorting the list:
        list.sort(new Comparator<Map.Entry<String, University>>() {
            // Implementing a comparator using UniversityComparator.
            public int compare(Map.Entry<String, University> o1, Map.Entry<String, University> o2) {
                return new UniversityComparator().compare(o1.getValue(), o2.getValue());
            }
        });

        for(Map.Entry<String, University> entry : list) {
            System.out.printf("\t- %s\n", entry.getValue().toString());
        }

    }

    public void printData() {
        System.out.println("Programa: " + program_name);
        System.out.println("Instituicoes:");
        printUniversitiesList();
        System.out.println();
        System.out.println("Quantidade de producoes por tipo: ");
        System.out.printf("\t- Artigos em anais de eventos: %d\n", p_annals);
        System.out.printf("\t- Artigos em jornais e revistas: %d\n", p_magazi);
        System.out.printf("\t- Artigos em periodicos cientificos: %d\n", p_period);
        System.out.printf("\t- Livros: %d\n", p_books);
        System.out.printf("\t- Partituras musicais: %d\n", p_music);
        System.out.printf("\t- Traducoes: %d\n", p_transl);
        System.out.printf("\t- Outros: %d\n", p_miscel);
        System.out.println();

        System.out.println("Total de paginas produzidas pelo PPG: " + published_pages );
    }

    public int productionsNum() {
        return p_annals + p_magazi + p_period + p_books + p_music + p_transl + p_miscel;
    }

}