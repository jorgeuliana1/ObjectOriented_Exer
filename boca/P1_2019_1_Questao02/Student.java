import java.util.Locale;

/**
 * @author Jose Jorge Moutinho Uliana
 */
public class Student {

    private String name;
    private int missed; /* In hours */
    private double[] grades;
    private Discipline dis;

    public Student(String name, int missed, Discipline dis, double[] grades) {
        this.name = name;
        this.missed = missed;
        this.grades = grades;
        this.dis = dis;
    }

    public double getAverage() {
        double sum = 0;
        for(double grade : grades) {
            sum += grade;
        }

        return sum / grades.length;
    }

    public String getSituation() {
        if((double)missed/(double)dis.getTime() > 0.25) {
            return "RF";
        } else if(getAverage() < 7.0) {
            return "PF";
        }
        else return "AP";
    }

    public int getMissed() {
        return missed;
    }

    public void print() {
        System.out.printf(new Locale("en", "US"), "%s %.1f %s\n", this.name, getAverage(), getSituation());
    }
}
