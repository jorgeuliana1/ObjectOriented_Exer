import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

public class J3_07 {

    public static void main(String[] args) {
        // Setting up in/output.
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);

        String str_locale, country, language;

        str_locale = in.nextLine();
        country = str_locale.split(" ")[0];
        language = str_locale.split(" ")[1];

        String fact;

        fact = in.nextLine();

        // Given code
        Locale locale = new Locale(language, country);

        ResourceBundle bundle = ResourceBundle.getBundle("mensagens", Locale.US);
        String msg = bundle.getString("text.occurredin");

        fact = bundle.getString(fact);

        // Getting the date
        String raw_date;
        raw_date = in.nextLine();

        /*
         * index 0 is the day
         * index 1 is the month
         * index 2 is the year
         */

        // Setting up the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(raw_date, formatter);
        DayOfWeek day = date.getDayOfWeek();
        String display_date = day.getDisplayName(TextStyle.NARROW, locale);

        out.println(fact + " - " + msg + " " + display_date);

    }

}
