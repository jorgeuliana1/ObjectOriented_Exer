import java.util.Scanner;
import java.util.Formatter;

public class J2_07 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s1;
        s1 = in.nextLine();

        int n;
        n = Integer.parseInt(s1);
        
        for(int i = 0; i < n; i++) {
            String s = in.nextLine();
            String[] s2 = s.split(",");

            if(s2[0].equals("L")) {
                Book b = new Book(s2[1], Double.parseDouble(s2[2]), s2[3]);
                System.out.println(b.toString());
            }

            else if(s2[0].equals("C")) {
                CompactDisc c = new CompactDisc(s2[1], Double.parseDouble(s2[2]), Integer.parseInt(s2[3]));
                System.out.println(c.toString());
            }

            else if(s2[0].equals("D")) {
                MovieDisc d = new MovieDisc(s2[1], Double.parseDouble(s2[2]), Integer.parseInt(s2[3]));
                System.out.println(d.toString());
            }
        }

        in.close();
        
    }
}
