import java.util.ArrayList;

public class Department {

    private String name;
    private Employee[] emps;

    public Department(String name, int num_emps) {
        this.name = name;
        this.emps = new Employee[num_emps];
    }

    public void addEmployee(Employee emp) {
        if(this.emps[this.emps.length - 1] != null) {
            Employee[] copy = this.emps;
            this.emps = new Employee[this.emps.length + 1];
            for(int i = 0; i < copy.length; i++) {
                this.emps[i] = copy[i];
            }
            this.emps[this.emps.length - 1] = emp;
        }

        else {
            for(int i = 0; i < this.emps.length; i++) {
                if(this.emps[i] == null) {
                    this.emps[i] = emp;
                    break;
                }
            }
        }
    }

    public Employee removeEmployee(int index) {
        Employee toRemove = this.emps[index];

        for(int i = index; i < this.emps.length - 1; i++) {
            this.emps[i] = this.emps[i + 1];
        }

        this.emps[this.emps.length - 1] = null;

        return toRemove;
    }

    public void moveEmployeeTo(int index, Department other) {
        Employee emp = this.removeEmployee(index);
        other.addEmployee(emp);
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        double sum;
        sum = new Double(0);
        for(int i = 0; i < this.emps.length; i++) {
            if(this.emps[i] != null)
                sum += this.emps[i].getSalary();
        }

        return sum;
    }

    public int getNumEmps() {
        return this.emps.length;
    }

}