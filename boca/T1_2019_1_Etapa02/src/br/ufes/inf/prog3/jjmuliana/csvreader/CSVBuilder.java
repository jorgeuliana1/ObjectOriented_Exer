package br.ufes.inf.prog3.jjmuliana.csvreader;

/**
 * @author J. Jorge M. Uliana
 * @version 1.0
 */

public class CSVBuilder {

    public static String getCSVStyleLine(String separator, String ... content /* content of the csv line*/) {

        StringBuilder builder;
        builder = new StringBuilder();

        for ( String cont : content ) {
            if(cont != null && !cont.equals("0"))
                builder.append(cont);
            if(cont != content[content.length - 1]) /* if cont isn't the last element of content... */ {
                builder.append(separator);
            }
        }

        return builder.toString();
    }

}
