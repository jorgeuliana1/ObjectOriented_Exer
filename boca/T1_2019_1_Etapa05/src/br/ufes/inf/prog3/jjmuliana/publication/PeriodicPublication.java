package br.ufes.inf.prog3.jjmuliana.publication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jose Jorge Moutinho Uliana
 * @version 1.0
 */
public class PeriodicPublication extends SerializedPublication {

    private String volume;
    private String fascicle;
    private String series;

    public PeriodicPublication(String title, String lang, String city, int p1, int p2, String editor,
                               String issn, String volume, String fascicle, String series)
    {
        super(title, lang, city, p1, p2, editor, issn);
        this.volume = volume;
        this.fascicle = fascicle;
        this.series = series;
        super.setNature(PublicationConst.PERIODIC.toString());
    }

    public String getVolume() {
        return volume;
    }

    public String getFascicle() {
        return fascicle;
    }

    public String getSeries() {
        return series;
    }

    @Override
    public int compareTo(Publication pa) {
        PeriodicPublication p = (PeriodicPublication) pa;

        int compare;
        compare = getNature().compareTo(p.getNature());
        if(compare != 0)
            return compare;

        compare = getLanguage().compareTo(p.getLanguage());
        if(compare != 0)
            return compare;

        compare = getEditor().compareTo(p.getEditor());
        if(compare != 0)
            return compare;

        compare = getCity().compareTo(p.getCity());
        if(compare != 0)
            return compare;

        try {
            int a;
            int b;
            if(isNumber(getVolume()))
                a = Integer.parseInt(convertNumber(getVolume()));
            else
                a = 0;

            if(isNumber(p.getVolume()))
                b = Integer.parseInt(convertNumber(p.getVolume()));
            else
                b = 0;

            compare = a - b;

            if(compare != 0)
                return compare;
        } catch (NullPointerException e) {
            compare = 0;
        }

        try {
            int a;
            int b;
            if(isNumber(getFascicle()))
                a = Integer.parseInt(convertNumber(getFascicle()));
            else
                a = 0;

            if(isNumber(p.getFascicle()))
                b = Integer.parseInt(convertNumber(p.getFascicle()));
            else
                b = 0;

            compare = a - b;

            if(compare != 0)
                return compare;
        } catch (NullPointerException e) {
            compare = 0;
        }

        try {
            int a;
            int b;
            if(isNumber(getSeries()))
                a = Integer.parseInt(convertNumber(getSeries()));
            else
                a = 0;

            if(isNumber(p.getSeries()))
                b = Integer.parseInt(convertNumber(p.getSeries()));
            else
                b = 0;

            compare = a - b;

            if(compare != 0)
                return compare;
        } catch (NullPointerException e) {
            compare = 0;
        }

        try {
            compare = convertStringISSN(getISSN()).compareTo(convertStringISSN(p.getISSN()));
            if(compare != 0)
                return compare;
        } catch (NullPointerException e) {
            compare = 0;
        }

        compare = getPages() - p.getPages();
        return compare;
    }

    public boolean equals(Publication pa) {
        if(compareTo(pa) == 0) return true;
        else return false;
    }

    private boolean isNumber(String s) {

        if(s == null)
            return false;

        // Trying to know if s is a number.
        Pattern pattern = Pattern.compile("([0-9][0-9][0-9])|([0-9][0-9])|([0-9])");
        Matcher matcher = pattern.matcher(s);

        return matcher.matches();
    }

    private String convertNumber(String s) {
        int length;
        length = s.length();

        StringBuilder builder = new StringBuilder(s);

        for(int i = 0; i < 4 - length; i++) {
            builder.reverse();
            builder.append("0");
            builder.reverse();
        }

        return builder.toString();
    }

    private boolean isStringISSN(String s) {
        // Trying to know if s is a ISSN found in Periodics.
        Pattern pattern = Pattern.compile("\\([0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-X]\\) ([A-Z])");
        Matcher matcher = pattern.matcher(s);

        return matcher.find();
    }

    private String convertStringISSN(String s) {

        StringBuilder builder;
        String[] splited;

        splited = s.split(" ");
        builder = new StringBuilder();

        builder.append(splited[0].replaceAll("(\\()|(\\))|(-)", ""));
        //builder.reverse();

        for(int i = 1; i < splited.length; i++) {
            builder.append(splited[i]);
        }


        return builder.toString();

    }

    public static String getCSVStyleHeader() {
        return "Natureza;Idioma;Editora;Cidade;Volume;Fasciculo;Serie;ISSN;Paginas";
    }
}
