import java.io.*;
import java.util.ArrayList;

public class CSVReader {

    private FileReader r;
    private String s; // Separator
    private ArrayList<String> stream = new ArrayList<String>();

    public CSVReader(File f, String separator, boolean autoread) {

        try {
            r = new FileReader(f);
        } catch(FileNotFoundException e) {
            System.out.println("Erro de I/O");
        }
        s = separator;
        if(autoread)
            readCSV();

    }

    public void readCSV() {

        BufferedReader br;
        try {
            br = new BufferedReader(r);
        } catch(NullPointerException e) {
            System.exit(-1);
            return;
        }
        String str;

        while(true) {

            try {
                str = br.readLine();
            } catch(IOException e) {
                System.out.println("Erro de I/O");
                break;
            }

            if(str == null)
                break;
            stream.add(str);
        }
    }

    public String[] getRow(int row) {

        return stream.get(row).split(s);

    }

    public String getContent(int row, int column) {

        return stream.get(row).split(s)[column];

    }

    public int[] getSize() {

        int []ret = new int[2];
        /*
         INDEX 0 | CONTAINS THE NUMBER OF ROWS OF THE CSV
         INDEX 1 | CONTAINS THE NUMBER OF COLUMNS OF THE CSV
        */
        ret[0] = stream.size();
        ret[1] = stream.get(0/* 0 is the header row position index */).split(s).length;

        return ret;

    }
}
