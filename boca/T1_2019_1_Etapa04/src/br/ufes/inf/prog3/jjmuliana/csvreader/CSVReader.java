package br.ufes.inf.prog3.jjmuliana.csvreader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @
 * @author Jose Jorge Moutinho Uliana
 * @version 1.3
 */

public class CSVReader {

    private FileReader r;
    private String s; // Separator
    private ArrayList<String> stream;
    private String[] cache_string;
    private String next_line = null;
    private BufferedReader br;
    private boolean thereIsNextLine = false;
    private Map<String, Integer> index;

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
        else if(has_index_row) {
            String[] i;
            try {
                i = br.readLine().split(s);
                createIndex(i);
            } catch(IOException e) {
                return;
            }
            try {
                next_line = br.readLine();
                thereIsNextLine = true;
            } catch(NullPointerException | IOException e) {
                next_line = null;
                thereIsNextLine = false;
            }
            nextLine();
        }

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

        // Performance optimization.
            /*
            The program was spending a lot of time with splits, so I decided to store only one splitted vector instead of
            splitting at the get function.
             */

        if(thereIsNextLine) {
            cache_string = next_line.split(s);
        }

        try {
            next_line = br.readLine();
            thereIsNextLine = true;
        } catch (IOException | NullPointerException e) {
            thereIsNextLine = false;
        }
        if(next_line == null)
            thereIsNextLine = false;
    }

    public String getCachedLineContent(int elem) throws NullPointerException {
        return cache_string[elem].trim();
    }

    public String getCachedLineContent(String elem) {
        try {
            return cache_string[getIndexNumberbyName(elem)].trim();
        } catch(ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    public void createIndex(String[] ind) {

        int counter = 0;

        index = new HashMap<>();

        for(String i : ind) {
            index.put(i, counter);
            counter++;
        }

        // Creates a HashMap that represents the indexes.

    }

    private int getIndexNumberbyName(String index_name) {
        try {
            return index.get(index_name);
        } catch(NullPointerException e) {
            return -1;
        }
    }

    public boolean hasNextLine() {
        return thereIsNextLine;
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
