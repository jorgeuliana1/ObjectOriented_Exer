import java.util.Scanner;

public class J3_03 {

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

            if(c.equals("+")) {
                try {
                    acc.addToBalance(value);
                } catch(NegativeMoneyValueException e) {
                    System.out.println(e.getMessage());
                    in.close();
                    return;
                }
            } else {
                try {
                    acc.takeFromBalance(value);
                } catch(YouDontHaveException e) {
                    System.out.println(e.getMessage());
                    in.close();
                    return;
                } catch(NegativeMoneyValueException e) {
                    System.out.println(e.getMessage());
                    in.close();
                    return;
                }
            }
        }
    }
} 
