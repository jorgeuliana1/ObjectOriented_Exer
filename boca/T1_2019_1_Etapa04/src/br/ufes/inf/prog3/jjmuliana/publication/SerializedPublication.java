package br.ufes.inf.prog3.jjmuliana.publication;

public abstract class SerializedPublication extends EditorialPublication {

    String issn;

    public SerializedPublication(String title, String lang, String city, int p1, int p2, String editor, String issn) {
        super(title, lang, city, p1, p2, editor);
        this.issn = issn;
    }

    public String getISSN() {
        return issn;
    }
}
