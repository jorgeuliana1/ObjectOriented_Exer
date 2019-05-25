import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class T1_2019_1_Etapa02 {

    public static void main(String[] args) {
        // Setting up.
        Scanner in;
        in = new Scanner(System.in);
        in.useLocale(Locale.ENGLISH);
        PublicationStats stats = new PublicationStats();
        File f;
        StatsCommand s;

        String folder_path;
        String line;

        folder_path = in.nextLine();

        while(true) {
            // Reading the input.
            line = in.nextLine();

            if(line.equals("rede")) {
                s = StatsCommand.REDE;
                break;
            }

            // Getting the file from the path.
            f = new File(folder_path, line);

            if (!f.exists()) {
                System.out.println("Erro de I/O");
                return;
            }

            // Loading the data from the file.
            stats.fromCSV(f, false, true, false);
        }

        stats.followCommand(s);
    }

}