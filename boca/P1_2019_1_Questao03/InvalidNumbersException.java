/**
 * @author J. Jorge M. Uliana
 */
public class InvalidNumbersException extends RuntimeException {

    int fp;
    int lp;

    String title;

    public InvalidNumbersException(String t, int fp, int lp) {
        title = t;
        this.fp = fp;
        this.lp = lp;
    }

    @Override
    public String toString() {
        return ("Artigo " + title + " informa dados de paginas inicial-final incorretos: " + fp + "-" + lp);
    }
}