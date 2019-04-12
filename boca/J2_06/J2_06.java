import java.util.Scanner;

public class J2_06 {

    public static void main(String[] args) {
        Scanner in;
        in = new Scanner(System.in);

        String c;
        c = in.nextLine();

        CheckingAccount acc;

        if(c.equals("E")) {
            acc = new SpecialAccount();
        }

        else {
            acc = new CheckingAccount();
        }

        while(true) {
            c = in.next();

            if(c.equals(".")) {
                in.close();
                return;
            }

            double value;
            value = in.nextDouble();

            if(c.equals("+"))
                acc.addToBalance(value);
            else
                acc.takeFromBalance(value);
        }
    }
} 
