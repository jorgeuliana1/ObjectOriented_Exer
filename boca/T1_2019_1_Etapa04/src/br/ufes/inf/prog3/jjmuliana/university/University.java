package br.ufes.inf.prog3.jjmuliana.university;

import br.ufes.inf.prog3.jjmuliana.gradprogram.GradProgram;
import br.ufes.inf.prog3.jjmuliana.publication.Publication;

import java.util.*;

public class University implements Comparable<University> {

    private String n; /* name */
    private String s; /* short name */
    private int p = 0; /* publications */
    private boolean a = false; /* annals */
    private Set<GradProgram> g_list = new TreeSet<>();

    public University(String name, String shortname) {
        n = name;
        s = shortname;
    }

    public boolean equals(University u) {
        if(this.compareTo(u) == 0)
            return true;
        else return false;
    }

    public void addGraduateProgram(GradProgram g) {
        addGraduateProgram(g, null);
    }

    public void addGraduateProgram(GradProgram g, Publication p) {
        if(!g_list.contains(g)) {
            g_list.add(g);
        } else {
            // getting gradprogram
            Iterator<GradProgram> iterator;
            iterator = g_list.iterator();

            while(iterator.hasNext()) {
                GradProgram gradProgram;
                gradProgram = iterator.next();
                if(g.equals(gradProgram)) {
                    g = gradProgram;
                }
            }
        }

        if(p != null) {
            g.plusPublication(p);
        }

    }

    public void printData() {
        // Printing the "name (short name)"
        System.out.println(n + " (" + s + "):");

        Iterator<GradProgram> iterator = g_list.iterator();

        while(iterator.hasNext()) {
            GradProgram i = iterator.next();
            System.out.printf("\t- %s: %d producoes\n", i.getName(), i.productionsNum());
        }
    }

    public String getName() {
        return n;
    }

    public String getShortName() {

        return s;

    }

    @Override
    public boolean equals(Object a) {

        University ao = (University) a;

        return this.getName().equals(ao.getName()) && this.s.equals(ao.s);
    }

    @Override
    public int hashCode() {
        String lower_name = (n + s).toLowerCase().trim();

        // Getting a hash code from the string:
        int sum = 0;
        for(int i = 0; i < lower_name.length(); i++) {
            sum += (int)lower_name.charAt(i);
        }

        return 1;
    }

    public String getHashKey() {
        return ("_" + s + "_" + n).toLowerCase().trim();
    }

    @Override
    public String toString() {
        return (s + " (" + n + ")");
    }

    @Override
    public int compareTo(University u) {
        int compare;
        compare = getShortName().compareTo(u.getShortName());
        if(compare == 0)
            return getName().compareTo(u.getName());
        return compare;
    }

}