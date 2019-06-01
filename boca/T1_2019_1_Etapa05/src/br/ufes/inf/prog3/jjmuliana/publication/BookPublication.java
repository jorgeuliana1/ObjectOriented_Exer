package br.ufes.inf.prog3.jjmuliana.publication;

/**
 * @author Jose Jorge Moutinho Uliana
 * @version 1.0
 */
public class BookPublication extends EditorialPublication {

    private String isbn;

    public BookPublication(String title, String lang, String city, boolean p, int p1, int p2, String editor, String isbn) {
        super(title, lang, city, p, p1, p2, editor);
        super.setNature(PublicationConst.BOOK.toString());
        this.isbn = isbn;
    }

    public String getISBN() {
        return isbn;
    }
}
