public class Publication {

    private String a_name; /* annal name */

    private int[] pages;    /* 
                            pages vctr: index 0: 1 or 0, 1 if there is a defined
                            number of pages; index 1 and 2: first and last page number
                            */

    private String u_name; /* university name */
    private String grad_prog; /* graduate program name */
    private boolean wasInAnnal = true;

    public Publication(String a, String u, String g, boolean p, int p1, int p2) {

        // Defining a_name
        if(a.equals("(null)"))
            wasInAnnal = false;
        else
            wasInAnnal = true;
        a_name = a;

        u_name = u;
        grad_prog = g;

        pages = new int[3];

        // Defining the pages vctr
        if(p2 - p1 >= 2000 || p1 > p2 || p2 < 0 || p1 < 0)
            p = false;


        if(p == true)
            pages[0] = 1;
        else
            pages[0] = 0;
        
        pages[1] = p1;
        pages[2] = p2;
        
    }

    public int getPages() {
        if(pages[0] == 1)
            return pages[2] - pages[1];
        else
            return 0;
    }

    public String getAnnal() {
        if(wasInAnnal)
            return a_name;
        else
            return "(null)";
    }

    public String getGradProgName() {
        return grad_prog;
    }

    public String getUniversityName() {
        return u_name;
    }

}