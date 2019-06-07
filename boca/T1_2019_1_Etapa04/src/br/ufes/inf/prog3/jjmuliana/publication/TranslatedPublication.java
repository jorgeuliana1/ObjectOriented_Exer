package br.ufes.inf.prog3.jjmuliana.publication;

/**
 * @author Jose Jorge Moutinho Uliana
 * @version 1.0
 */
public class TranslatedPublication extends EditorialPublication {

    private String translation; /* translation language */

    public TranslatedPublication(String title, String lang, String city, int pages, String editor, String translation) {
        super(title, lang, city, 0, pages, editor);
        this.translation = translation;
        super.setNature(PublicationConst.TRANSLATION.toString());
    }

    public String getTranslation() {
        return translation;
    }

    @Override
    public int compareTo(Publication pa) {
        TranslatedPublication p = (TranslatedPublication) pa;

        int compare;

        compare = getNature().compareTo(p.getNature());
        if(compare != 0)
            return compare;

        try {
            compare = getEditor().compareTo(p.getEditor());
        } catch(NullPointerException e) {
            compare = 0;
        }
        if(compare != 0)
            return compare;

        compare = getCity().compareTo(p.getCity());
        if(compare != 0)
            return compare;

        compare = getTranslation().compareTo(p.getTranslation());
        if(compare != 0)
            return 0;

        compare = getPages() - p.getPages();
        return compare;
    }
}
