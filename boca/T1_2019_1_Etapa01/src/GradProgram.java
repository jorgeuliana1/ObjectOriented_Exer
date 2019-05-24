public class GradProgram {

    private String g_name; /* graduate program name */
    private int publ = 0;
    private boolean annals = false;

    public GradProgram(String g) {
        g_name = g;
    }

    public void addPublication(int i) {
        publ += i;
    }

    public void addPublication() {
        addPublication(1);
    }

    public void setAnnals(boolean t) {
        annals = t;
    }

    public String getName() {
        return g_name;
    }

    public int getPublicationsNumber() {
        return publ;
    }

    public boolean hasAnnals() {
        return annals;
    }

    @Override
    public boolean equals(Object a) {

        GradProgram ao = (GradProgram) a;

        return this.getName().equals(ao.getName());
    }

    @Override
    public int hashCode() {
        String lower_name = (g_name).toLowerCase().trim();

        // Getting a hash code from the string:
        int sum = 0;
        for(int i = 0; i < lower_name.length(); i++) {
            sum += (int)lower_name.charAt(i);
        }

        return 1;
    }

    public String getHashKey() {
        return (g_name).toLowerCase().trim();
    }

}