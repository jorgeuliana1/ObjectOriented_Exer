import java.util.Scanner;

public class J2_02 {

    public static void main(String[] args) {
        Scanner in;
        in = new Scanner(System.in);

        // Receiving input.
        long sNum;
        sNum = in.nextLong();

        Aleatorio r;
        r = new Aleatorio(sNum);

        // Printing the random numbers.
        for(int i = 0; i < 10; i++) {

            System.out.print(Integer.toString(r.getNum()) + " ");

        }
        

        System.out.println();

        in.close();
    }
}