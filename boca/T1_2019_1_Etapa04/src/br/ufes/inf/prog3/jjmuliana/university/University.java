package br.ufes.inf.prog3.jjmuliana.university;

import br.ufes.inf.prog3.jjmuliana.gradprogram.GradProgram;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University {

    private String n; /* name */
    private String s; /* short name */
    private int p = 0; /* publications */
    private boolean a = false; /* annals */
    private List<GradProgram> g_list;

    public University(String name, String shortname) {
        n = name;
        s = shortname;
        g_list = new ArrayList<>();
    }

    public void setAnnals(boolean hasAnnals) {
        a = hasAnnals;
    }

    public void setPublications(int p_number) {
        p = p_number;
    }

    public void addPublication() {
        addPublication(1);
    }

    public void addPublication(int i) {
        p += i;
    }

    public void addGraduateProgram(GradProgram g) {
        if(!g_list.contains(g))
            g_list.add(g);
    }

    public void printData() {
        // Printing the "name (short name)"
        System.out.println(n + " (" + s + "):");

        // Sorting the grad programs list
        g_list.sort(new Comparator<GradProgram>() {
            @Override
            public int compare(GradProgram o1, GradProgram o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for(GradProgram i : g_list) {
            System.out.printf("\t- %s: %d producoes\n", i.getName(), i.productionsNum());
        }
    }

    public boolean publishesInAnnals() {
        return a;
    }

    public int getGradProgramsNum() {
        return g_list.size();
    }

    public int getPublicationsNum() {
        return p;
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
        return ("-" + s + "-" + n).toLowerCase().trim();
    }

    @Override
    public String toString() {
        return (s + " (" + n + ")");
    }

}