import java.util.Scanner;
import java.util.Locale;

public class J2_03 {

    public static void main(String[] args) {
        Scanner in;
        in = new Scanner(System.in);
        in.useLocale(Locale.ENGLISH);

        Customer c;
        String s;

        while(true) {
            c = new Customer(in.nextLine());
            while(true) {
                s = in.nextLine();
                if(s.equals("+") || s.equals("."))
                    break;
                c.setCPF(s);
            }
            // Printing the customer info.
            System.out.println(c.getName() + " " + c.getCPF());
            if(s.equals("."))
                return;
        }


    }

}