import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
import java.util.Locale;
import java.util.Date;

public class J1_08 {
    public static void main(String[] args) {

        // Setting up input and output.
        Locale br = new Locale("pt", "BR");
        Scanner in = new Scanner(System.in);
        in.useLocale(br);

        // Programming here
        Corporation corp;
        corp = new Corporation(in.next(), in.next(), in.nextInt());

        int num_depts;
        num_depts = corp.getNumberOfDepartments();

        for(int i = 0; i < num_depts; i++) {

            Department dept;
            dept = new Department(in.next(), in.nextInt());
            corp.addDepartment(dept);

            int num_emps;
            num_emps = dept.getNumEmps();

            for(int j = 0; j < num_emps; j++) {
                Employee emp;
                if(i == 0) // Increasing salaries of the first dept.
                    emp = new Employee(in.next(), in.nextDouble() * 1.1, in.next());
                else
                    emp = new Employee(in.next(), in.nextDouble(), in.next());
                dept.addEmployee(emp);
            }
        }
        // Moving employee 1 of dept 1 to dept 2.
        Department dep1 = corp.getDepartment(0);
        Department dep2 = corp.getDepartment(1);

        dep1.moveEmployeeTo(0, dep2);

        for(int i = 0; i < corp.getNumberOfDepartments(); i++) {
            System.out.printf("%s R$ %.2f\n", corp.getDepartment(i).getName(), corp.getDepartment(i).getSalary());
        }

    }
}