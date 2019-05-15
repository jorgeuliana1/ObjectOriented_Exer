import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jose Jorge Moutinho Uliana
 */

public class P1_2019_1_Questao02 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        in.useLocale(new Locale("en", "US"));
        Discipline d;
        ArrayList<Student> s = new ArrayList<Student>();

        try {
            d = new Discipline(in.nextLine(), in.nextInt(), in.nextInt(), in.nextInt());
            for (int i = 0; i < d.getStudentsNum(); i++) {
                int missed = in.nextInt();
                double[] grades = new double[d.getTestsNum()];
                for(int j = 0; j < d.getTestsNum(); j++) {
                    grades[j] = in.nextDouble();
                }

                s.add(new Student(in.next(), missed, d, grades));
            }
        } catch(Exception e) {
            System.out.println("Dados invalidos: null");
            return;
        }
        
        System.out.println(d.toString() + ":");
        for(int i = 0; i < s.size(); i++) {
            s.get(i).print();
        }

    }
}
