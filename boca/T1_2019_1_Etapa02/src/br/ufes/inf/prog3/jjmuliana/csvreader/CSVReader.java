package br.ufes.inf.prog3.jjmuliana.csvreader;

import java.io.*;
import java.util.ArrayList;

/**
 * @
 * @author J. Jorge M. Uliana
 * @version 1.1
 */

public class CSVReader {

    private FileReader r;
    private String s; // Separator
    private ArrayList<String> stream;
    private String cache_string;
    private BufferedReader br;
    private boolean thereIsNextLine = true;

    public CSVReader(File f, String separator, boolean autoread, boolean has_index_row) {

        try {
            r = new FileReader(f);
        } catch (FileNotFoundException e) {
            System.out.println("Erro de I/O");
        }
        s = separator;
        initializeReader();
        if (autoread)
            readCSV();
        else if(has_index_row)
            nextLine();

    }

    public void readCSV() {

        String str;

        stream = new ArrayList<>();

        while (true) {

            try {
                str = br.readLine();
            } catch (IOException e) {
                System.out.println("Erro de I/O");
                break;
            }

            if (str == null)
                break;
            stream.add(str);
        }

        thereIsNextLine = false;
    }

    private void initializeReader() {
        try {
            br = new BufferedReader(r);
        } catch (NullPointerException e) {
            System.out.println("Erro de I/O");
        }
    }

    public void nextLine() {
        try {
            cache_string = br.readLine();
        } catch (IOException e) {
            System.out.println("Erro de I/O");
            thereIsNextLine = false;
        }
    }

    public String getCachedLineContent(int elem) throws NullPointerException {
        return cache_string.split(s)[elem].trim();
    }

    public boolean hasNextLine() {
        return thereIsNextLine;
    }

    public String[] getRow(int row) {

        return stream.get(row).split(s);

    }

    public String getContent(int row, int column) {

        return stream.get(row).split(s)[column].trim();

    }

    public int[] getSize() {

        int[] ret = new int[2];
        /*
         INDEX 0 | CONTAINS THE NUMBER OF ROWS OF THE CSV
         INDEX 1 | CONTAINS THE NUMBER OF COLUMNS OF THE CSV
        */
        ret[0] = stream.size();
        ret[1] = stream.get(0/* 0 is the header row position index */).split(s).length;

        return ret;

    }
}
