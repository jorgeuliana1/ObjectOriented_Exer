import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class T1_2019_1_Etapa01 {

    public static void main(String[] args) {
        // Setting up.
        Scanner in;
        in = new Scanner(System.in);
        in.useLocale(Locale.ENGLISH);

        // Getting the file from the path.
        File f = new File(in.nextLine(), in.nextLine());

        if(!f.exists()) {
            System.out.println("Erro de I/O");
            return;
        }

        // Loading the data from the file.
        PublicationStats stats = new PublicationStats();
        stats.fromCSV(f);

        // Printing the stats:
        stats.printAnnalsStats();
    }

}