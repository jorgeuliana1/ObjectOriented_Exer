package br.ufes.inf.prog3.jjmuliana.publication;

import br.ufes.inf.prog3.jjmuliana.csvreader.CSVBuilder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Jose Jorge Moutinho Uliana
 * @version 1.0
 */
public class MagazinePublication extends SerializedPublication {

    private String publishing_date;

    public MagazinePublication(String title, String lang, String city, boolean p, int p1, int p2, String editor,
                               String issn, String publishing_date)
    {
        super(title, lang, city, p, p1, p2, editor, issn);
        this.publishing_date = publishing_date;
        super.setNature(PublicationConst.MAGAZINE.toString());
    }

    public String getPublishingDate() {
        return publishing_date;
    }

    @Override
    public String getBigHashKey() {
        String pages = String.valueOf(getPages());
        if(pages.equals("0"))
            pages = "";

        if(getTitle() != null)
            return CSVBuilder.getCSVStyleLine(";", getTitle(), getLanguage(), getCity(), getPublishingDate(), getISSN(),
                    pages);
        else return "0" + getHashKey();
    }

    @Override
    public int compareTo(Publication pa) {
        MagazinePublication p = (MagazinePublication)pa;

        int compare;

        // First comparison:
        compare = getTitle().compareTo(p.getTitle());
        if(compare != 0)
            return compare;

        // Second comparison:
        compare = getLanguage().compareTo(p.getLanguage());
        if(compare != 0)
            return compare;

        // Third comparison:
        compare = getCity().compareTo(p.getCity());
        if(compare != 0)
            return compare;

        // Fourth comparison:
        if(isBRDate(getPublishingDate()) && isBRDate(p.getPublishingDate()))
            compare = convertDate(getPublishingDate()).compareTo(convertDate(p.getPublishingDate()));
        if(compare != 0)
            return compare;

        // Fifth comparison:
        compare = getISSN().compareTo(p.getISSN());
        if(compare != 0)
            return compare;

        // Last comparison:
        compare = getPages() - p.getPages();
        return compare;
    }

    private boolean isBRDate(String s) {
        // Trying to know if s is a date.
        Pattern pattern = Pattern.compile("([0-9][0-9)])/([0-9][0-9)]/[0-9][0-9)][0-9][0-9)])");
        Matcher matcher = pattern.matcher(s);

        return matcher.matches();
    }

    private String convertDate(String s) {
        // Used only when s is a date.
        // Reorganizes date to fit the sorting algorithm.
        String[] splitted = s.split("/");

        // Returns YYYY/MM/DD format if input is DD/MM/YYYY
        return splitted[2] + splitted[1] + splitted[0];
    }

}
