package br.ufes.inf.prog3.jjmuliana.publication;

/**
 * @author Jose Jorge Moutinho Uliana
 * @version 1.0
 */
public class PeriodicPublication extends SerializedPublication {

    private String volume;
    private String fascicle;
    private String series;

    public PeriodicPublication(String title, String lang, String city, boolean p, int p1, int p2, String editor,
                               String issn, String volume, String fascicle, String series)
    {
        super(title, lang, city, p, p1, p2, editor, issn);
        this.volume = volume;
        this.fascicle = fascicle;
        this.series = series;
        super.setNature(PublicationConst.PERIODIC.toString());
    }

    public String getVolume() {
        return volume;
    }

    public String getFascicle() {
        return fascicle;
    }

    public String getSeries() {
        return series;
    }
}
