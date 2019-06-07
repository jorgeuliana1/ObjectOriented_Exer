package br.ufes.inf.prog3.jjmuliana.gradprogram;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.ufes.inf.prog3.jjmuliana.csvreader.CSVBuilder;
import br.ufes.inf.prog3.jjmuliana.publication.*;
import br.ufes.inf.prog3.jjmuliana.university.University;
import br.ufes.inf.prog3.jjmuliana.university.UniversityComparator;

/**
 * @author J. Jorge M. Uliana
 * @version 1.3
 */

public class GradProgram {

    private String program_id; /* graduate program id */
    private String program_name; /* graduate program name */
    private Map<String, University> university_map; /* tree containing universities */

    // HashMaps of publications:
    private Set<AnnalPublication>      m_anna = new TreeSet<>(); // Annals publications
    private Set<MagazinePublication>   m_maga = new TreeSet<>(); // Magazines publications
    private Set<PeriodicPublication>   m_peri = new TreeSet<>(); // Periodic publications
    private Set<BookPublication>       m_book = new TreeSet<>(); // Book publications
    private Set<TranslatedPublication> m_tran = new TreeSet<>(); // Translated publications
    private Set<MusicalPiece>          m_musi = new TreeSet<>(); // Musical pieces
    private Set<GenericPublication>    m_gene = new TreeSet<>(); // Generic publications

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

        System.out.println("Total de paginas produzidas pelo PPG: " + published_pages );
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


}