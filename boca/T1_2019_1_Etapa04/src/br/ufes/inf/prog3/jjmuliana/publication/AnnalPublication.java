package br.ufes.inf.prog3.jjmuliana.publication;

import br.ufes.inf.prog3.jjmuliana.csvreader.CSVBuilder;

/**
 * @author Jose Jorge Moutinho Uliana
 * @version 1.1
 */
public class AnnalPublication extends Publication {

    private String annal; /* event */

    public AnnalPublication(String title, String lang, String city, int p1, int p2, String event) {
        super(title, lang, city, p1, p2);
        setNature(PublicationConst.ANNAL.toString());
        annal = event;
    }

    public String getAnnal() {
        return annal;
    }

    @Override
    public int compareTo(Publication pa) {
        AnnalPublication p = (AnnalPublication)pa;

        int compare;

        compare = getNature().compareTo(p.getNature());
        if(compare != 0)
            return compare;

        compare = getTitle().compareTo(p.getTitle());
        if(compare != 0)
            return compare;

        compare = getLanguage().compareTo(p.getLanguage());
        if(compare != 0)
            return compare;

        compare = getAnnal().compareTo(p.getAnnal());
        if(compare != 0)
            return compare;

        compare = getCity().compareTo(p.getCity());
        if(compare != 0)
            return compare;

        compare = getPages() - p.getPages();
        return compare;
    }
}
