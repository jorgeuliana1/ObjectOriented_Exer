import java.util.Scanner;
import java.util.Locale;

public class Customer {

    // CPF s.f. "Cadastro de Pessoa Fisica".

    private String name;
    private String cpf = "000.000.000-01";
    private boolean veriCPF = false;

    Customer (String name) {

        // Invalid CPF.
        this(name, "000.000.000-01");

    }

    Customer (String name, String ... cpfs) {
        this.name = name;
        
        for(String currCPF : cpfs) {
            if(verifyCPF(currCPF)) {
                this.cpf = currCPF;
                this.veriCPF = true;
                break;
            }
        }

    }

    public void setCPF(String cpf) {
        if(verifyCPF(cpf)) {
            this.cpf = cpf;
            this.veriCPF = true;
        }
    }

    public boolean hasCPF() {
        return this.veriCPF;
    }

    public String getCPF() {
        if(this.veriCPF)
            return this.cpf;
        else
            return " ";
    }

    public String getName() {
        return this.name;
    }

    // CODE GIVEN BY THE PROFESSOR.

    private static boolean verifyCPF(String cpf) {

        if (cpf == null || cpf.length() == 0)
            return false;

        // Considerates only the digits from CPF, putting them in a StringBuilder.
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cpf.length(); i++) {
            char c = cpf.charAt(i);
            if (c >= '0' && c <= '9') builder.append(c);
        }

        // A valid CPF has 11 digits.
        if (builder.length() != 11)
            return false;

        // Calculates the first verifier digit and compares with the given digit.
        int digit = calculateVerifierDigit(builder, 9);
        if (digit != builder.charAt(9) - '0')
            return false;

        // Do the same thing with the second verifier digit.
        digit = calculateVerifierDigit(builder, 10);
        if (digit != builder.charAt(10) - '0')
            return false;

        // If everything is OK, returns true.
        return true;

    }

    private static int calculateVerifierDigit(StringBuilder builder, int index) {
        int sum = 0, weight = index + 1, digit;

        for (int i = 0; i < index; i++, weight--) {
            digit = builder.charAt(i) - '0';
            sum += digit * weight;
        }

        digit = 11 - (sum % 11);

        if (digit > 9)
            digit = 0;

        return digit;
    }

    // END OF THE PROFESSOR'S CODE

}