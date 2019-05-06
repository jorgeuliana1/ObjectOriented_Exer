public class GradProgram {

    private String g_name; /* graduate program name */
    private String u_name; /* university name */
    private int publ = 0;
    private boolean annals = false;

    public GradProgram(String g, String u) {
        g_name = g;
        u_name = u;
    }

    public void addPublication(int i) {
        publ+=i;
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

    public String getUName() {
        return u_name;
    }

    public int getPublicationsNumber() {
        return publ;
    }

    public boolean hasAnnals() {
        return annals;
    }

    @Override
    public boolean equals(Object a) {
        
        GradProgram ao = (GradProgram)a;

        if(this.getName().equals(ao.getName()))
            return true;
        else
            return false;
    }

}