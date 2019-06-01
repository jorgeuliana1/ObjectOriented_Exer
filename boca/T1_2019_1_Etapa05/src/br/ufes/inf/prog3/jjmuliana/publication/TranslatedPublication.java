package br.ufes.inf.prog3.jjmuliana.publication;

/**
 * @author Jose Jorge Moutinho Uliana
 * @version 1.0
 */
public class TranslatedPublication extends EditorialPublication {

    private String translation; /* translation language */

    public TranslatedPublication(String title, String lang, String city, boolean p, int p1, int p2, String editor,
                                 String translation) {
        super(title, lang, city, p, p1, p2, editor);
        this.translation = translation;
        super.setNature(PublicationConst.TRANSLATION.toString());
    }

    public String getTranslation() {
        return translation;
    }
}
