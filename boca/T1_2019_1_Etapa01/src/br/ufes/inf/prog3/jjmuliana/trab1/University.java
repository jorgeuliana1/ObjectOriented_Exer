package br.ufes.inf.prog3.jjmuliana.trab1;

public class University {

    private String n; /* name */
    private String s; /* short name */
    private int p = 0; /* publications */
    private boolean a = false; /* annals */
    private int gp = 0; /* graduate programs */

    public University(String name, String shortname) {
        n = name;
        s = shortname;
    }

    public void setAnnals(boolean hasAnnals) {
        a = hasAnnals;
    }

    public void setGraduateProgramsNumber(int gp_number) {
        gp = gp_number;
    }

    public void setPublications(int p_number) {
        p = p_number;
    }

    public void addPublication() {
        addPublication(1);
    }

    public void addPublication(int i) {
        p += i;
    }

    public void addGraduateProgram() {
        addGraduateProgram(1);
    }

    public void addGraduateProgram(int i) {
        gp += i;
    }

    public boolean publishesInAnnals() {
        return a;
    }

    public int getGradProgramsNum() {
        return gp;
    }
    
    public int getPublicationsNum() {
        return p;
    }

    public String getName() {
        return n;
    }

    @Override
    public boolean equals(Object a) {

        University ao = (University)a;

        if(this.getName().equals(ao.getName()) && this.s.equals(ao.s))
            return true;
        else
            return false;
    }

}