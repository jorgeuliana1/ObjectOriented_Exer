package br.ufes.inf.prog3.jjmuliana.publication;

public abstract class Publication implements Comparable<Publication> {

    private String nature; /* publication nature */
    private String a_name; /* publication title */
    private String lang;   /* language used to write the publication */
    private String city;   /* city of the publication */
    private int[] pages;    /* 
                            pages vctr: index 0: 1 or 0, 1 if there is a defined
                            number of pages; index 1 and 2: first and last page number
                            */

    private static int counter = 0;

    public Publication(String a, String l, String c, boolean p, int p1, int p2) {

        a_name = a;
        lang = l;
        city = c;

        pages = new int[3];

        // Defining the pages
        if (p2 - p1 >= 2000 || p1 > p2 || p2 < 0 || p1 < 0)
            p = false;


        if (p)
            pages[0] = 1;
        else
            pages[0] = 0;

        pages[1] = p1;
        pages[2] = p2;

    }

    public int getPages() {
        if (pages[0] == 1)
            return pages[2] - pages[1] + 1; /*
                I will give you an example:
                - If you have an article that starts at page 42 and ends at page 42, the article has one page.
                - Then, we conclude that the formula is "last page" - "first page" + 1,

            */
        else
            return 0;
    }

    public void setNature(String n) {
        nature = n;
    }

    public String getNature() {
        return nature;
    }

    public String getTitle() {
        return a_name;
    }

    public String getLanguage() {
        return lang;
    }

    public String getCity() {
        return city;
    }

    public boolean hasPageNumber() {
        return pages[0] == 1;
    }

    @Override
    public int hashCode() {
        String lower_name = (a_name + nature + city).toLowerCase().trim();

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

    @Override
    public abstract int compareTo(Publication p);

}