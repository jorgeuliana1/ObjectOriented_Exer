import java.util.ArrayList;

public class Corporation {
    private String name;
    private String cnpj;
    private Department[] depts;

    public Corporation(String name, String cnpj, int num_depts) {
        this.name = name;
        this.cnpj = cnpj;
        this.depts = new Department[num_depts];
    }

    public String getName() {
        return this.name;
    }

    public String getCNPJ() {
        return this.cnpj;
    }

    public int getNumberOfDepartments() {
        return this.depts.length;
    }

    public void addDepartment(Department dept) {
        for(int i = 0; i < this.depts.length; i++) {
            if(this.depts[i] == null) {
                this.depts[i] = dept;
                break;
            }
        }
    }

    public Department getDepartment(int index) {
        return this.depts[index];
    }
}