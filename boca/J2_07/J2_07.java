import java.util.Scanner;
import java.util.Formatter;
import java.util.Arrays;

public class J2_07 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s1;
        s1 = in.nextLine();

        int n;
        n = Integer.parseInt(s1);

        Item[] it = new Item[n];
        
        for(int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] s2 = s.split(",");

            if(s2[0].equals("L")) {
                it[i] = new Book(s2[1], Double.parseDouble(s2[2]), s2[3]);
            }

            else if(s2[0].equals("C")) {
                it[i] = new CompactDisc(s2[1], Double.parseDouble(s2[2]), Integer.parseInt(s2[3]));
            }

            else if(s2[0].equals("D")) {
                it[i] = new MovieDisc(s2[1], Double.parseDouble(s2[2]), Integer.parseInt(s2[3]));
            }
        }

        in.close();

        Arrays.sort(it, 0, n);

        for( Item ip : it ) {

            System.out.println(ip.toString());

        }
        
    }
}
