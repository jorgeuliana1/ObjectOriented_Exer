package br.ufes.inf.prog3.jjmuliana.stats;

/**
 * @author Jose Jorge M. Uliana
 */

// Package private class

import br.ufes.inf.prog3.jjmuliana.gradprogram.GradProgram;
import br.ufes.inf.prog3.jjmuliana.publication.Publication;
import br.ufes.inf.prog3.jjmuliana.university.University;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class GradProgramList {
    private Map<String, GradProgram> g;

    GradProgramList() {
        g = new HashMap<>();
    }

    GradProgram addGradProgram(GradProgram grp, University u, Publication p) {
        boolean isInSet = false;
        if(g.containsKey(grp.getHashKey())) {
            isInSet = true;
            grp = g.get(grp.getHashKey());
        }
        // common operations:
        grp.plusPublication(p);
        grp.addUniversity(u);

        // else ...
        if(!isInSet)
            g.put(grp.getHashKey(), grp);

        return grp;
    }

    int size() {
        return g.size();
    }

    void printNetworks() {
        System.out.println("Programas em rede:");

        Object[] key_set = g.keySet().toArray();
        Arrays.sort(key_set);

        GradProgram gp;

        for(Object key : key_set) {
            gp = g.get(key);

            if(gp.getUniversitiesNumber() > 1) {
                System.out.println(gp.toString()); // Printing the grad. prog. ID and name.
                gp.printUniversitiesList(); // Printing the universities list.
            }
        }
    }

    void printProgramData(String program_id) {
        if(g.containsKey(program_id.trim()))
            g.get(program_id).printData();
        else
            System.out.println("PPG nao encontrado.");
    }

    GradProgram get(String id) {
        return g.get(id);
    }
}
