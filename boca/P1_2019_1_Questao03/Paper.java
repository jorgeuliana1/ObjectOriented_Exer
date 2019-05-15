/**
 * @author J. Jorge M. Uliana
 */

public abstract class Paper {
    private String title;

    private boolean has_page;
    private int start_page;
    private int final_page;

    private String magazine_name;
    
    private String qualis;

    public Paper(String t, int sp, int fp, String mn, String q) {
        /**
         * @param t is the title of the paper.
         * @param sp is the initial page of the paper.
         * @param fp is the final page of the paper.
         * @param mn is the publisher vehicle name.
         * @param q is the Qualis concept.
         */
        this(t, (sp + "-" + fp), mn, q);
        
    }

    public Paper(String t, String p, String mn, String q) {
        /**
         * @param t is the title of the paper.
         * @param p is a string in the format "sp-fp"
         * @param mn is the publisher vehicle name.
         * @param q is the Qualis concept.
         */

        // Splitting the pages.
        String[] pages = p.split("-");

        int sp, fp;

        try {
            sp = Integer.parseInt(pages[0]);
            fp = Integer.parseInt(pages[1]);
        } catch(Exception e) {
            // Paper will be disconsidered for certain purposes.
            // In order to be invalid, fp and sp must be invalid values.
            sp = -1;
            fp = -1;
        }

        title = t;

        /*
        * Rules for pages:
        * - start_page <= final_page;
        * - final_page - start_page <= 50
        */
        if(fp - sp >= 0 && fp - sp <= 50 && sp >= 0 && fp >= 0) {
            start_page = sp;
            final_page = fp;
            has_page = true;
        } else {
            start_page = final_page = 0;
            has_page = false;

            // Generating exception message;
            InvalidNumbersException e = new InvalidNumbersException(t, sp, fp);
            System.out.println(e);
        }

        magazine_name = mn;
        qualis = q;
    }

    public int getNumPages() {
        if(has_page) {
            return (final_page - start_page + 1);
        } return -1;
    }

    public boolean hasPages() {
        return has_page;
    }

    public String getQualis() {
        return qualis;
    }
}