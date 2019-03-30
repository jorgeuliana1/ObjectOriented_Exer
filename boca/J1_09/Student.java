public class Student {
    private String name;
    private double[] grades;
    
    public Student(String name, double ... grades) {
        this.name   = name;
        this.grades = grades;
    }

    public double getAverage() {
        double sum;
        sum = new Double(0);

        for(double i : grades) {
            sum += i;
        }

        return sum / grades.length;
    }

    public String getName() {
        return name;
    }
}