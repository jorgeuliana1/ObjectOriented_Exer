import java.util.ArrayList;

public class Corporation {
    private String name;
    private String cnpj;
    private ArrayList<Department> depts;

    public Corporation(String name, String cnpj) {
        this.name = name;
        this.cnpj = cnpj;
        this.depts = new ArrayList();
    }

    public String getName() {
        return this.name;
    }

    public String getCNPJ() {
        return this.cnpj;
    }

    public int getNumberOfDepartments() {
        return this.depts.size();
    }

    public void addDepartment(Department dept) {
        this.depts.add(dept);
    }

    public Department getDepartment(int index) {
        return this.depts.get(index);
    }
}