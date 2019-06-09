import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class J3_08 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        Locale.setDefault(new Locale("pt", "BR"));

        DateCommand c = DateCommand.getCommand("set");
        c.setDate(in.nextLine());

        Calendar d = c.getDate();

        while(true) {
            c = DateCommand.getCommand(in.next().trim());
            c.setParam(in.nextLine().trim());

            c.setDate(d);

            int flag = c.followCommand();

            if(flag != 0)
                break;

            d = c.getDate();
        }
    }

}
