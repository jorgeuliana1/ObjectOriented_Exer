import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public enum DateCommand {
    YEAR(1), PRINT(4), EXIT(5), DAY(3), MONTH(2), INVALID(-1);

    private int command_id = 0;
    private String parameter;
    private Calendar cal;

    DateCommand(int id) {
        command_id = id;
    }

    public static DateCommand getCommand(String command) {
        if(command.equals("ano"))
            return YEAR;
        if(command.equals("print"))
            return PRINT;
        if(command.equals("sair"))
            return EXIT;
        if(command.equals("dia"))
            return DAY;
        if(command.equals("mes"))
            return MONTH;
        else
            return INVALID;
    }

    public void setDate(String date) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date d;
        try {
            d = df.parse(date);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            return;
        }

        cal = df.getCalendar();
        cal.setTime(d);
    }

    public Calendar getDate() {
        return cal;
    }

    public void setDate(Calendar c) {
        cal = c;
    }

    public void addMonth(int num) {
        cal.add(Calendar.MONTH, num);
    }

    public void addYear(int num) {
        cal.add(Calendar.YEAR, num);
    }

    public void addDay(int num) {
        cal.add(Calendar.DATE, num);
    }

    public void setParam(String parameter) {
        this.parameter = parameter;
    }

    public void printDate(String param) {
        DateFormat df = new SimpleDateFormat(param);
        String str = df.format(cal.getTime());
        System.out.println(str);
    }

    public int followCommand() {
        if(parameter == null)
            return 0;
        if(command_id == -1 || command_id == 0)
            return 0;

        if(command_id == 1) {
            addYear(Integer.parseInt(parameter));
            return 0;
        }

        if(command_id == 2) {
            addMonth(Integer.parseInt(parameter));
            return 0;
        }

        if(command_id == 3) {
            addDay(Integer.parseInt(parameter));
            return 0;
        }

        if(command_id == 4) {
            printDate(parameter);
            return 0;
        }

        else
            return -1;
    }
}
