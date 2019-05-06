import java.util.Scanner;
import java.util.Locale;
import java.io.File;

public class T1_2019_1_Etapa01 {

    public static void main(String[] args) {
        // Setting up.
        Scanner in;
        in = new Scanner(System.in);
        in.useLocale(Locale.ENGLISH);

        // Getting the file from the path.
        FilePath file_path = new FilePath(in);
        File f = file_path.getFile();

        // Loading the data from the file.
        PublicationStats stats = new PublicationStats();
        stats.fromCSV(f);

        // Printing the stast:
        stats.printAnnalsStats();
    }

}