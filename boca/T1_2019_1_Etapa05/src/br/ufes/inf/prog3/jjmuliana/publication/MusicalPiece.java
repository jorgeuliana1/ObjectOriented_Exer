package br.ufes.inf.prog3.jjmuliana.publication;

/**
 * @author Jose Jorge Moutinho Uliana
 * @version 1.0
 */
public class MusicalPiece extends EditorialPublication {

    private String instrumental; /* instrumental formation */

    public MusicalPiece(String title, String lang, String city, int pages, String editor, String instrumental) {
        super(title, lang, city, 0, pages, editor);
        this.instrumental = instrumental;
        this.setNature(PublicationConst.MUSIC.toString());
    }

    public String getInstrumentalFormation() {
        return instrumental;
    }

    @Override
    public int compareTo(Publication pa) {
        MusicalPiece p = (MusicalPiece) pa;

        int compare;

        compare = getNature().compareTo(p.getNature());
        if(compare != 0)
            return compare;

        compare = getEditor().compareTo(p.getEditor());
        if(compare != 0)
            return compare;

        if(!getCity().equals(p.getCity()))
            return getCity().compareTo(p.getCity());

        if(!getInstrumentalFormation().equals(p.getInstrumentalFormation()))
            return getInstrumentalFormation().compareTo(p.getInstrumentalFormation());

        if(getPages() != 0 || p.getPages() != 0)
            compare = getPages() - p.getPages();
        return compare;
    }

    public static String getCSVStyleHeader() {
        return "Natureza;Editora;Cidade;Formacao;Paginas";
    }
}
