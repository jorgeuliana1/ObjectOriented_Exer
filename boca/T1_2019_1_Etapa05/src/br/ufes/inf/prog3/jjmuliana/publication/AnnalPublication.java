package br.ufes.inf.prog3.jjmuliana.publication;

/**
 * @author Jose Jorge Moutinho Uliana
 * @version 1.0
 */
public class AnnalPublication extends Publication {

    private String annal; /* event */

    public AnnalPublication(String title, String lang, String city, boolean p, int p1, int p2, String event) {
        super(title, lang, city, p, p1, p2);
        setNature(PublicationConst.ANNAL.toString());
        annal = event;
    }

    public String getAnnal() {
        return annal;
    }

}
