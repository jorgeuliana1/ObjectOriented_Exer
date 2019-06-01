package br.ufes.inf.prog3.jjmuliana.publication;

/**
 * @author Jose Jorge Moutinho Uliana
 * @version 1.0
 */
public class MagazinePublication extends SerializedPublication {

    private String publishing_date;

    public MagazinePublication(String title, String lang, String city, boolean p, int p1, int p2, String editor,
                               String issn, String publishing_date)
    {
        super(title, lang, city, p, p1, p2, editor, issn);
        this.publishing_date = publishing_date;
        super.setNature(PublicationConst.MAGAZINE.toString());
    }

    public String getPublishingDate() {
        return publishing_date;
    }

}
