package br.ufes.inf.prog3.jjmuliana.university;

import java.util.Comparator;

public class UniversityComparator implements Comparator<University> {
    public int compare(University u1, University u2) {
        // Comparing the short names;
        int compare = u1.getShortName().compareTo(u2.getShortName());
        if(compare != 0)
            return compare;

        // If they are equal, we compare the long ones.
        else return u1.getName().compareTo(u2.getName());
    }
}
