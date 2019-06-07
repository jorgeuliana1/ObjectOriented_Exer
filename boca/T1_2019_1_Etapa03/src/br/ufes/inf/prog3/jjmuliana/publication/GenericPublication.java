package br.ufes.inf.prog3.jjmuliana.publication;

public class GenericPublication extends EditorialPublication {

    public GenericPublication(String title, String lang, String city, boolean p, int p1, int p2, String editor) {
        super(title, lang, city, p, p1, p2, editor);
        super.setNature(PublicationConst.GENERIC.toString());
    }

    @Override
    public int compareTo(Publication pa) {
        GenericPublication p = (GenericPublication) pa;

        int compare;

        compare = getNature().compareTo(p.getNature());
        if(compare != 0)
            return compare;

        compare = getLanguage().compareTo(p.getLanguage());
        if(compare != 0)
            return compare;

        compare = getEditor().compareTo(p.getEditor());
        if(compare != 0)
            return compare;

        compare = getCity().compareTo(p.getCity());
        if(compare != 0)
            return compare;

        compare = getPages() - p.getPages();
        return compare;
    }

}