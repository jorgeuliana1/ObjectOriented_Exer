import java.util.DateFormat;

public class Employee {
    private String name;
    private double salary;
    private DateFormat admission;

    public Employee(String name, double salary, String admission) {
        this.name = name;
        this.salary = salary;
        this.admission = java.text.DateFormat.getInstance();
        this.admission = DateFormat.parse(admission);
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    public void incrementSalary(double incr) {
        this.salary += incr;
    }

    public void decrementSalary(double decr) {
        this.salary -= decr;
    }
}