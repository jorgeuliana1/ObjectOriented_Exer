package br.ufes.inf.prog3.jjmuliana.stats;

/**
 * @author Jose Jorge M. Uliana
 */

// Package private class

import br.ufes.inf.prog3.jjmuliana.gradprogram.GradProgram;
import br.ufes.inf.prog3.jjmuliana.publication.Publication;
import br.ufes.inf.prog3.jjmuliana.university.University;

import java.util.*;

// Auxiliar classes:
class UniversityList {
    private List<University> u;

    UniversityList() {
        u = new ArrayList<>();
    }

    University addUniversity(University uni, GradProgram gp) {
        if(!u.contains(uni))
            u.add(uni);
        else
            uni = u.get(u.indexOf(uni));

        uni.addGraduateProgram(gp);

        return uni;
    }

    int size() {
        return u.size();
    }

    Set<University> getFromShortName(String shortn) {

        Iterator<University> iterator;
        iterator = u.iterator();

        // Filling the set
        Set<University> search;
        search = new TreeSet<>();
        while(iterator.hasNext()) {
            University uni = iterator.next();
            if(uni.getShortName().equals(shortn)) {
                search.add(uni);
            }
        }

        // Returning the set of wanted universities.
        return search;
    }
}
