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

    public GradProgram(String id, String n) {
        program_id = id;
        program_name = n;
        university_map = new HashMap<>();
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

}