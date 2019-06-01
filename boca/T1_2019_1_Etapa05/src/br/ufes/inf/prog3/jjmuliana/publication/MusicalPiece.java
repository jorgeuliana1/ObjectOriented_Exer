package br.ufes.inf.prog3.jjmuliana.publication;

/**
 * @author Jose Jorge Moutinho Uliana
 * @version 1.0
 */
public class MusicalPiece extends EditorialPublication {

    private String instrumental; /* instrumental formation */

    public MusicalPiece(String title, String lang, String city, boolean p, int p1, int p2, String editor, String instrumental) {
        super(title, lang, city, p, p1, p2, editor);
        this.instrumental = instrumental;
        this.setNature(PublicationConst.MUSIC.toString());
    }

    public String getInstrumentalFormation() {
        return instrumental;
    }
}
