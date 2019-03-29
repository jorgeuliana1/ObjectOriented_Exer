public class Employee {
    private String name;
    private double salary;
    private String admission;

    public Employee(String name, double salary, String admission) {
        this.name = name;
        this.salary = salary;
        this.admission = admission;
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

    public int getAdmissionDay() {
        int day;
        day = 10*this.admission.charAt(0) + this.admission.charAt(1);
        //return Integer.parseInt(day);
        return day;
    }

    public int getAdmissionMonth() {
        int month;
        month = 10*this.admission.charAt(4) + this.admission.charAt(5);
        //return Integer.parseInt(month);
        return month;
    }

    public int getAdmissionYear() {
        int year;
        year = 10*this.admission.charAt(7) + this.admission.charAt(8);
        //return Integer.parseInt(year);
        return year;
    }
}