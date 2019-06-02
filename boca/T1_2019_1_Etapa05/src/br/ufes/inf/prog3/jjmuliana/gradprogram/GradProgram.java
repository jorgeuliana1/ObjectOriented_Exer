package br.ufes.inf.prog3.jjmuliana.gradprogram;

import java.util.*;

import br.ufes.inf.prog3.jjmuliana.publication.*;
import br.ufes.inf.prog3.jjmuliana.university.University;
import br.ufes.inf.prog3.jjmuliana.university.UniversityComparator;

/**
 * @author J. Jorge M. Uliana
 * @version 1.2
 */

public class GradProgram {

    private String program_id; /* graduate program id */
    private String program_name; /* graduate program name */
    private Map<String, University> university_map; /* tree containing universities */

    // HashMaps of publications:
    private Map<String, AnnalPublication>      m_anna = new TreeMap<>(); // Annals publications
    private Map<String, MagazinePublication>   m_maga = new TreeMap<>(); // Magazines publications
    private Map<String, PeriodicPublication>   m_peri = new TreeMap<>(); // Periodic publications
    private Map<String, BookPublication>       m_book = new TreeMap<>(); // Book publications
    private Map<String, TranslatedPublication> m_tran = new TreeMap<>(); // Translated publications
    private Map<String, MusicalPiece>          m_musi = new TreeMap<>(); // Musical pieces
    private Map<String, GenericPublication>    m_gene = new TreeMap<>(); // Generic publications

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

    public void plusAnnalPublication(AnnalPublication p) {
        m_anna.put(p.getBigHashKey(), p);
    }

    public void plusMagazinePublication(MagazinePublication p) {
        m_maga.put(p.getBigHashKey(), p);
    }

    public void plusPeriodicPublication(PeriodicPublication p) {
        m_peri.put(p.getBigHashKey(), p);
    }

    public void plusBooksPublication(BookPublication p) {
        m_book.put(p.getBigHashKey(), p);
    }

    public void plusMusicPublication(MusicalPiece p) {
        m_musi.put(p.getBigHashKey(), p);
    }

    public void plusTranslatedPublication(TranslatedPublication p) {
        m_tran.put(p.getBigHashKey(), p);
    }

    public void plusGenericPublication(GenericPublication p) {
        m_gene.put(p.getBigHashKey(), p);
    }

    public void plusPublication(Publication p) {

        // Higher lever function to insert publications in hashsets.
        if(p instanceof AnnalPublication)
            plusAnnalPublication((AnnalPublication) p);
        else if(p instanceof MagazinePublication)
            plusMagazinePublication((MagazinePublication) p);
        else if(p instanceof PeriodicPublication)
            plusPeriodicPublication((PeriodicPublication) p);
        else if(p instanceof BookPublication)
            plusBooksPublication((BookPublication) p);
        else if(p instanceof MusicalPiece)
            plusMusicPublication((MusicalPiece) p);
        else if(p instanceof TranslatedPublication)
            plusTranslatedPublication((TranslatedPublication) p);
        else if(p instanceof GenericPublication)
            plusGenericPublication((GenericPublication) p);
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
        System.out.printf("\t- Artigos em anais de eventos: %d\n", m_anna.size());
        System.out.printf("\t- Artigos em jornais e revistas: %d\n", m_maga.size());
        System.out.printf("\t- Artigos em periodicos cientificos: %d\n", m_peri.size());
        System.out.printf("\t- Livros: %d\n", m_book.size());
        System.out.printf("\t- Partituras musicais: %d\n", m_musi.size());
        System.out.printf("\t- Traducoes: %d\n", m_tran.size());
        System.out.printf("\t- Outros: %d\n", m_gene.size());
        System.out.println();

        System.out.println("Total de paginas produzidas pelo PPG: " + published_pages );
    }

    public int productionsNum() {
        return m_anna.size() + m_tran.size() + m_book.size() + m_gene.size() + m_maga.size() + m_musi.size() + m_peri.size();
    }

    public void printCSVStyleTable(String separator, String type) {
        if(type.equals(PublicationConst.GENERIC.toString())) {

            // Key iterator
            Iterator<String> iterator = m_gene.keySet().iterator();

            for(int i = 0; i < m_gene.size(); i++) {
                String key;
                key = iterator.next();

                GenericPublication p;
                if(m_gene.containsKey(key))
                    p = m_gene.get(key);
                else return;
                printCSVLine(";", p.getNature(), p.getTitle(), p.getLanguage(), p.getEditor(), p.getCity());
            }
            return;
        } else if(type.equals(PublicationConst.ANNAL.toString())) {

            // Key iterator
            Iterator<String> iterator = m_anna.keySet().iterator();

            for(int i = 0; i < m_anna.size(); i++) {
                String key;
                key = iterator.next();

                AnnalPublication p;
                if(m_anna.containsKey(key))
                    p = m_anna.get(key);
                else return;
                printCSVLine(";", p.getNature(), p.getTitle(), p.getLanguage(), p.getAnnal(), p.getCity());
            }
            return;
        } else if(type.equals(PublicationConst.MAGAZINE.toString())) {

            // Key iterator
            Iterator<String> iterator = m_maga.keySet().iterator();

            for(int i = 0; i < m_maga.size(); i++) {
                String key;
                key = iterator.next();

                MagazinePublication p;
                if(m_maga.containsKey(key))
                    p = m_maga.get(key);
                else return;
                printCSVLine(";", p.getNature(), p.getTitle(), p.getLanguage(), p.getEditor(), p.getCity(),
                        p.getPublishingDate(), p.getISSN());
            }
            return;
        } else if(type.equals(PublicationConst.PERIODIC.toString())) {

            // Key iterator
            Iterator<String> iterator = m_peri.keySet().iterator();

            for(int i = 0; i < m_peri.size(); i++) {
                String key;
                key = iterator.next();

                PeriodicPublication p;
                if(m_peri.containsKey(key))
                    p = m_peri.get(key);
                else return;
                printCSVLine(";", p.getNature(), p.getTitle(), p.getLanguage(), p.getEditor(), p.getCity(),
                        p.getVolume(), p.getFascicle(), p.getSeries(), p.getISSN());
            }
            return;
        } else if(type.equals(PublicationConst.BOOK.toString())) {

            // Key iterator
            Iterator<String> iterator = m_book.keySet().iterator();

            for(int i = 0; i < m_book.size(); i++) {
                String key;
                key = iterator.next();

                BookPublication p;
                p = m_book.get(key);
                printCSVLine(";", p.getNature(), p.getTitle(), p.getLanguage(), p.getEditor(), p.getCity(),
                        p.getISBN());
            }
            return;
        } else if(type.equals(PublicationConst.MUSIC.toString())) {

            // Key iterator
            Iterator<String> iterator = m_musi.keySet().iterator();

            for(int i = 0; i < m_musi.size(); i++) {

                String key;
                key = iterator.next();

                MusicalPiece p;
                if(m_musi.containsKey(key))
                    p = m_musi.get(key);
                else return;
                printCSVLine(";", p.getNature(), p.getTitle(), p.getLanguage(), p.getEditor(), p.getCity(),
                        p.getInstrumentalFormation());
            }
            return;
        } else if(type.equals(PublicationConst.TRANSLATION.toString())) {

            // Key iterator
            Iterator iterator = m_tran.keySet().iterator();

            for(int i = 0; i < m_tran.size(); i++) {
                int key;
                key = (int)iterator.next();

                TranslatedPublication p;
                if(m_tran.containsKey(key))
                    p = m_tran.get(key);
                else return;
                printCSVLine(";", p.getNature(), p.getTitle(), p.getLanguage(), p.getEditor(), p.getCity(),
                        p.getTranslation());
            }
            return;
        }
    }

    private void printCSVLine(String separator, String ... content /* content of the csv line*/) {
        // NOTE: AUXILIAR FUNCTION
        for ( String cont : content ) {
            System.out.print(cont);
            if(cont != content[content.length - 1]) /* if cont isn't the last element of content... */ {
                System.out.print(separator);
            }
        }
        // Break line
        System.out.println();
    }

}