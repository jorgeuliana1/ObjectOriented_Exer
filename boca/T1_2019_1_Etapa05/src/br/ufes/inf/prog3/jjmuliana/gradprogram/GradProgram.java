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

    private long published_pages = 0;
    private long valid_publications = 0;

    public GradProgram(String id, String n) {
        program_id = id;
        program_name = n;
        university_map = new TreeMap<>(new Comparator<String>() {
            // Implementing a comparator using UniversityComparator.
            public int compare(String o1, String o2) {
                String[] infos_1;
                String[] infos_2;

                infos_1 = o1.substring(1, o1.length()).split("-");
                infos_2 = o2.substring(1, o2.length()).split("-");

                // Comparing short names, since university key is in the format -shortname-name
                int compare = infos_1[0].compareTo(infos_2[0]);
                if(compare != 0)
                    return compare;

                // else ...
                // compare names
                return infos_1[1].compareTo(infos_2[1]);
            }
        });
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
        type = type.toLowerCase().trim();

        if(type.equals("anais"))
            plusAnnalPublication();
        else if(type.equals("artjr"))
            plusMagazinePublication();
        else if(type.equals("artpe"))
            plusPeriodicPublication();
        else if(type.equals("livro"))
            plusBooksPublication();
        else if(type.equals("partmu"))
            plusMusicPublication();
        else if(type.equals("tradu"))
            plusTranslationPublication();
        else if(type.equals("outro"))
            plusGenericPublication();
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
        for(Map.Entry<String, University> entry : university_map.entrySet()) {
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