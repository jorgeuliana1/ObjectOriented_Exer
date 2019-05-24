public class Publication {

    private String a_name; /* annal name */

    private int[] pages;    /* 
                            pages vctr: index 0: 1 or 0, 1 if there is a defined
                            number of pages; index 1 and 2: first and last page number
                            */

    private String u_name; /* university name */
    private String grad_prog; /* graduate program name */
    private static int counter = 0;

    public Publication(String a, String u, String g, boolean p, int p1, int p2) {

        // Defining a_name
        a_name = a;

        u_name = u;
        grad_prog = g;

        pages = new int[3];

        // Defining the pages vctr
        if (p2 - p1 >= 2000 || p1 > p2 || p2 < 0 || p1 < 0)
            p = false;


        if (p == true)
            pages[0] = 1;
        else
            pages[0] = 0;

        pages[1] = p1;
        pages[2] = p2;

    }

    public int getPages() {
        if (pages[0] == 1)
            return pages[2] - pages[1] + 1; /*
                I will give you a example:
                - If you have an article that starts at page 42 and ends at page 42, the article has one page.
                - Then, we conclude that the formula is "last page" - "first page" + 1,

            */
        else
            return 0;
    }

    public String getAnnal() {
        return a_name;
    }

    public String getGradProgName() {
        return grad_prog;
    }

    public String getUniversityName() {
        return u_name;
    }

    public boolean hasPageNumber() {
        return pages[0] == 1;
    }

    @Override
    public int hashCode() {
        String lower_name = (a_name + u_name + grad_prog).toLowerCase().trim();

        // Getting a hash code from the string:
        int sum = 0;
        for(int i = 0; i < lower_name.length(); i++) {
            sum += (int)lower_name.charAt(i);
        }

        return 1;
    }

    public int getHashKey() {
        counter += 1;
        return counter;
    }

}