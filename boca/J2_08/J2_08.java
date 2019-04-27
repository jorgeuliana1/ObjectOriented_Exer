import java.util.Scanner;
import java.util.Locale;

public class J2_08 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        in.useLocale(new Locale("en", "US"));

        int n = Integer.parseInt(in.nextLine());

        GeoForm[] gf = new GeoForm[n];

        for(int i = 0; i < n; i++) {
            String[] line = in.nextLine().split(",");

            if(line[0].equals("R"))
                gf[i] = new RectangleForm(Double.parseDouble(line[1]), Double.parseDouble(line[2]));
            
            else if(line[0].equals("Q"))
                gf[i] = new SquareForm(Double.parseDouble(line[1]));

            else if(line[0].equals("C"))
                gf[i] = new CircleForm(Double.parseDouble(line[1]));
        }

        in.close();
        
        for(int i = 0; i < n; i++) {
            System.out.println(gf[i].toString());
        }
        
    }
}