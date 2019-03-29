import java.util.ArrayList;

public class Department {

    private String name;
    private ArrayList<Employee> emps;

    public Department(String name) {
        this.name = name;
        this.emps = new ArrayList();
    }

    public void addEmployee(Employee emp) {
        this.emps.add(emp);
    }

    public void removeEmployee(int index) {
        this.emps.remove(index);
    }

    public void moveEmployeeTo(int index, Department other) {
        Employee emp = this.emps.get(index);
        this.emps.remove(index);
        other.addEmployee(emp);
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        double sum;
        sum = new Double(0);
        for(int i = 0; i < this.emps.size(); i++) {
            sum += this.emps.get(i).getSalary();
        }

        return sum;
    }

}