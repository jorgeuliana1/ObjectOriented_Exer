/**
 * @author Jose Jorge Moutinho Uliana
 */

public class Discipline {

    private String name;
    private int time; /* Given in hours */
    private int students; /* N of students */
    private int aval_n; /* Number of tests */

    public Discipline(String n, int t, int s, int a) {

        name = n;
        time = t;
        students = s;
        aval_n = a;

    }

    @Override
    public String toString() {
        return (name + " (" + time + " horas-aula)");
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public int getStudentsNum() {
        return students;
    }

    public int getTestsNum() {
        return aval_n;
    }

}
