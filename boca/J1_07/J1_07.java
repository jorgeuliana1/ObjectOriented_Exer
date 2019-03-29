import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;
import java.util.Locale;

public class J1_07 {
    public static void main(String[] args) {

        // Setting up input and output.
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.ENGLISH);
        DecimalFormat df = new DecimalFormat("#.00000", DecimalFormatSymbols.getInstance(Locale.US));

        Point a;
        Point b;
        Point c;

        a = new Point(in.nextDouble(), in.nextDouble());
        b = new Point(in.nextDouble(), in.nextDouble());
        c = new Point(in.nextDouble(), in.nextDouble());

        Triangle t;
        t = new Triangle(a, b, c);

        System.out.println(df.format(t.GetPerimeter()));

        
    }
}