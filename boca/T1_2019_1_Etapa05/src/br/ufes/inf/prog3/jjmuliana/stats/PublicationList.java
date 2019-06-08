package br.ufes.inf.prog3.jjmuliana.stats;

/**
 * @author Jose Jorge M. Uliana
 */

// Package private class

import br.ufes.inf.prog3.jjmuliana.publication.Publication;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class PublicationList {
    private int valid_pages_sum = 0;
    private int valid_publications_num = 0;
    private int publications_num = 0;

    PublicationList() {
    }

    void addPublication(Publication publ) {
            valid_pages_sum += publ.getPages(); /* Counting the valid pages */
            if(publ.hasPageNumber()) valid_publications_num += 1; /* Counting the valid publications */
            publications_num++;
    }

    int size() {
        return publications_num;
    }

    int getValidPagesSum() {
        return valid_pages_sum;
    }

    public double getAveragePagesNum() {
        return (double)valid_pages_sum/(double)valid_publications_num;
    }
}
