import java.util.Scanner;
import java.util.Locale;

public class J1_09 {
    public static void main(String[] args) {

        // Setting up the scanner:
        Scanner in;
        in = new Scanner(System.in);
        in.useLocale(Locale.US);

        // Creating Students array:
        Student[] studs;
        studs = new Student[in.nextInt()]; /* Getting the size of the vector from the standard input. */

        // Registering students and obtaining the sum of their grades:
        double sum;
        sum = new Double(0);

        for( int i = 0; i < studs.length; i++ ) {
            studs[i] = new Student(in.next(), in.nextDouble(), in.nextDouble(), in.nextDouble());
            sum += studs[i].getAverage();
        }

        // Analyzing and printing the results.
        double average;
        average = sum / studs.length; /* Average grade of the class */

        System.out.println("Nome,Nota,Situacao,Media"); /* :Printing header of the csv */
        
        for( Student stud : studs ) {
            String strAve;
            String strSit;

            // Verifying the student average in relation to the rest of the class:
            if(stud.getAverage() > average)
                strAve = new String("Acima");
            else if(stud.getAverage() < average)
                strAve = new String("Abaixo");
            else
                strAve = new String("Media");

            // Verifying the situation of the student:
            if(stud.getAverage() >= 7.0)
                strSit = new String("Aprovado");
            else
                strSit = new String("Prova Final");

            // Printing the result:
            System.out.printf("%s,%.1f,%s,%s\n", stud.getName(), stud.getAverage(), strSit, strAve);
        }

        // Closing scanner:
        in.close();
    }
}