import br.ufes.inf.prog3.jjmuliana.publication.Publication;
import br.ufes.inf.prog3.jjmuliana.stats.PublicationStats;
import br.ufes.inf.prog3.jjmuliana.stats.StatsCommand;

import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class T1_2019_1_Etapa05 {

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

            // Defining the command.
            if(line.equals("rede")) {
                s = StatsCommand.REDE;
                break;
            } else if(line.split(" ")[0].equals("ppg")) {
                s = StatsCommand.PPG;
                s.setSubCommand(line.split(" ")[1]);
                break;
            } else if(line.split(" ")[0].equals("ies")) {
                s = StatsCommand.IES;
                s.setSubCommand(line.split(" ")[1]);
                break;
            } else if(line.split(" ")[0].equals("csv")) {
                s = StatsCommand.CSV;
                String[] subline = line.split(" ");
                s.setSubCommand(subline[1], subline[2]);
                break;
            }

            // Getting the file from the path.
            f = new File(folder_path, line);

            if (!f.exists()) {
                System.out.println("Erro de I/O");
                return;
            }

            // Loading the data from the file.
            stats.fromCSV(f);
        }

        stats.followCommand(s);
    }

}