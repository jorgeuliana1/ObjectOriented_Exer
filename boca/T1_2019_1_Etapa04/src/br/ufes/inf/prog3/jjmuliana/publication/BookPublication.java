package br.ufes.inf.prog3.jjmuliana.publication;

/**
 * @author Jose Jorge Moutinho Uliana
 * @version 1.0
 */
public class BookPublication extends EditorialPublication {

    private String isbn;

    public BookPublication(String title, String lang, String city, int pages, String editor, String isbn) {
        super(title, lang, city, 0, pages, editor);
        super.setNature(PublicationConst.BOOK.toString());
        this.isbn = isbn;
    }

    public String getISBN() {
        return isbn;
    }

    @Override
    public int compareTo(Publication pa) {
        BookPublication p = (BookPublication) pa;

        int compare;

        compare = getNature().compareTo(p.getNature());
        if(compare != 0)
            return compare;

        compare = getTitle().compareTo(p.getTitle());
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

        compare = getISBN().compareTo(p.getISBN());
        if(compare != 0)
            return compare;

        compare = getPages() - p.getPages();
        return compare;
    }
}
