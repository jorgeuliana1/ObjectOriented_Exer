import java.util.Scanner;
import java.util.Locale;

public class J2_01 {

    public static void main(String[] args) {
        Scanner in;
        in = new Scanner(System.in);
        in.useLocale(Locale.ENGLISH);

        // Receiving input.
        long num;
        num = in.nextLong();

        Aleatorio r;
        
        r = new Aleatorio(num);

        // Printing the random numbers.
        for(int i = 0; i < 10; i++) {
            System.out.print(Integer.toString(r.getNum()) + " ");
        }
        

        System.out.println();

        in.close();
    }
}