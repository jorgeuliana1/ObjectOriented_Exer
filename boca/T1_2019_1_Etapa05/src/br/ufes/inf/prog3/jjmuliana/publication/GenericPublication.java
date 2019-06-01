package br.ufes.inf.prog3.jjmuliana.publication;

public class GenericPublication extends EditorialPublication {

    public GenericPublication(String title, String lang, String city, boolean p, int p1, int p2, String editor) {
        super(title, lang, city, p, p1, p2, editor);
        super.setNature(PublicationConst.GENERIC.toString());
    }

}
