package br.ufes.inf.prog3.jjmuliana.gradprogram;

import java.util.*;

import br.ufes.inf.prog3.jjmuliana.csvreader.CSVBuilder;
import br.ufes.inf.prog3.jjmuliana.publication.*;
import br.ufes.inf.prog3.jjmuliana.university.University;

/**
 * @author J. Jorge M. Uliana
 * @version 1.3
 */

public class GradProgram implements Comparable<GradProgram> {

    private String program_id; /* graduate program id */
    private String program_name; /* graduate program name */
    private Map<String, University> university_map; /* tree containing universities */
    private int publications_count = 0;

    // TreeSets of publications:
    private List<AnnalPublication>      m_anna = new ArrayList<>(); // Annals publications
    private List<MagazinePublication>   m_maga = new ArrayList<>(); // Magazines publications
    private List<PeriodicPublication>   m_peri = new ArrayList<>(); // Periodic publications
    private List<BookPublication>       m_book = new ArrayList<>(); // Book publications
    private List<TranslatedPublication> m_tran = new ArrayList<>(); // Translated publications
    private List<MusicalPiece>          m_musi = new ArrayList<>(); // Musical pieces
    private List<GenericPublication>    m_gene = new ArrayList<>(); // Generic publications

    public GradProgram(String id, String n) {
        program_id = id;
        program_name = n;
        university_map = new TreeMap<>(new Comparator<String>() {
            // Implementing a comparator using UniversityComparator.
            public int compare(String o1, String o2) {
                String[] infos_1;
                String[] infos_2;

                infos_1 = o1.substring(1, o1.length()).split("_");
                infos_2 = o2.substring(1, o2.length()).split("_");

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
        m_anna.add(p);
    }

    public void plusMagazinePublication(MagazinePublication p) {
        m_maga.add(p);
    }

    public void plusPeriodicPublication(PeriodicPublication p) {
        m_peri.add(p);
    }

    public void plusBooksPublication(BookPublication p) {
        m_book.add(p);
    }

    public void plusMusicPublication(MusicalPiece p) {
        m_musi.add(p);
    }

    public void plusTranslatedPublication(TranslatedPublication p) {
        m_tran.add(p);
    }

    public void plusGenericPublication(GenericPublication p) {
        m_gene.add(p);
    }

    public void plusPublication(Publication p) {

        // Higher lever function to insert publications in set.
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

        publications_count++;
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

    public int compareTo(GradProgram g) {
        int compare;
        compare = getName().compareTo(g.getName());
        if(compare == 0)
            return getID().compareTo(g.getID());
        return compare;
    }

    public int getUniversitiesNumber() {
        return university_map.size();
    }

    @Override
    public String toString() {
        return (program_id + ": " + program_name);
    }

    public void printUniversitiesList() {

        Iterator iterator = university_map.values().iterator();
        while(iterator.hasNext()) {
            University u = (University) iterator.next();
            System.out.printf("\t- %s\n", u.toString());
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

        System.out.println("Total de paginas produzidas pelo PPG: " + getPublishedPages());
        System.out.println();
    }

    public int productionsNum() {
        return m_anna.size() + m_tran.size() + m_book.size() + m_gene.size() + m_maga.size() + m_musi.size() + m_peri.size();
    }

    public void printCSVStyleTable(String separator, String type) {

        List<String> output_buffer;
        output_buffer = new ArrayList<>();

        if(type.equals(PublicationConst.GENERIC.toString())) {

            // Key iterator
            Iterator<GenericPublication> iterator = m_gene.iterator();

            for(int i = 0; i < m_gene.size(); i++) {
                GenericPublication p;
                if(iterator.hasNext())
                    p = iterator.next();
                else return;
                output_buffer.add(CSVBuilder.getCSVStyleLine(";", p.getNature(), p.getTitle(), p.getLanguage(), p.getEditor(), p.getCity(), String.valueOf(p.getPages())));
            }
        }
        else if(type.equals(PublicationConst.ANNAL.toString())) {

            // Key iterator
            Iterator<AnnalPublication> iterator = m_anna.iterator();

            for(int i = 0; i < m_anna.size(); i++) {
                AnnalPublication p;
                if(iterator.hasNext())
                    p = iterator.next();
                else return;
                output_buffer.add(CSVBuilder.getCSVStyleLine(";", p.getNature(), p.getTitle(), p.getLanguage(),
                        p.getAnnal(), p.getCity(), String.valueOf(p.getPages())));
            }
        }
        else if(type.equals(PublicationConst.MAGAZINE.toString())) {

            // Key iterator
            Iterator<MagazinePublication> iterator = m_maga.iterator();

            for(int i = 0; i < m_maga.size(); i++) {
                MagazinePublication p;
                if(iterator.hasNext())
                    p = iterator.next();
                else return;
                output_buffer.add(CSVBuilder.getCSVStyleLine(";", p.getTitle(), p.getLanguage(), p.getCity(),
                        p.getPublishingDate(), p.getISSN(), String.valueOf(p.getPages())));
            }
        }
        else if(type.equals(PublicationConst.PERIODIC.toString())) {

            // Key iterator
            Iterator<PeriodicPublication> iterator = m_peri.iterator();

            for(int i = 0; i < m_peri.size(); i++) {
                PeriodicPublication p;
                if(iterator.hasNext())
                    p = iterator.next();
                else return;
                output_buffer.add(CSVBuilder.getCSVStyleLine(";", p.getNature(), p.getLanguage(),
                        p.getEditor(), p.getCity(), p.getVolume(), p.getFascicle(), p.getSeries(), p.getISSN(),
                        String.valueOf(p.getPages())));
            }
        }
        else if(type.equals(PublicationConst.BOOK.toString())) {

            // Key iterator
            Iterator<BookPublication> iterator = m_book.iterator();

            for(int i = 0; i < m_book.size(); i++) {
                BookPublication p;
                if(iterator.hasNext())
                    p = iterator.next();
                else return;
                output_buffer.add(CSVBuilder.getCSVStyleLine(";", p.getNature(), p.getTitle(), p.getLanguage(), p.getEditor(), p.getCity(),
                        p.getISBN()));
            }
        }
        else if(type.equals(PublicationConst.MUSIC.toString())) {

            // Key iterator
            Iterator<MusicalPiece> iterator = m_musi.iterator();

            for(int i = 0; i < m_musi.size(); i++) {
                MusicalPiece p;
                if(iterator.hasNext())
                    p = iterator.next();
                else return;
                output_buffer.add(CSVBuilder.getCSVStyleLine(";", p.getNature(),
                        p.getEditor(), p.getCity(), p.getInstrumentalFormation()));
            }
        }
        else if(type.equals(PublicationConst.TRANSLATION.toString())) {

            // Key iterator
            Iterator<TranslatedPublication> iterator = m_tran.iterator();

            for(int i = 0; i < m_tran.size(); i++) {
                TranslatedPublication p;
                if(iterator.hasNext())
                    p = iterator.next();
                else return;
                output_buffer.add(CSVBuilder.getCSVStyleLine(";", p.getNature(), p.getTitle(), p.getLanguage(),
                        p.getEditor(), p.getCity(), p.getTranslation()));
            }
        }

        // Printing the strings.
        for(String line : output_buffer) {
            System.out.println(line);
        }

    }

    public int getPublishedPages() {
        int sum = 0;
        sum += getSetPages(m_anna.iterator());
        sum += getSetPages(m_gene.iterator());
        sum += getSetPages(m_book.iterator());
        sum += getSetPages(m_maga.iterator());
        sum += getSetPages(m_musi.iterator());
        sum += getSetPages(m_peri.iterator());
        sum += getSetPages(m_tran.iterator());
        return sum;
    }

    private static int getSetPages(Iterator p) {

        Iterator<Publication> iterator;
        iterator = (Iterator<Publication>) p;

        int sum = 0;

        while(iterator.hasNext()) {
            int toSum = iterator.next().getPages();
            sum += toSum;
        }

        return sum;
    }

    public boolean equals(GradProgram p) {
        if(compareTo(p) == 0) return true;
        else return false;
    }


}