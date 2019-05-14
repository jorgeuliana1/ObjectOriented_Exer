/**
 * @author J. Jorge M. Uliana
 */

import java.util.Scanner;
import java.util.Locale;

public class P1_2019_1_Questao03 {

    public static void main(String[] args) {
        Scanner in;
        in = new Scanner(System.in);
        in.useLocale(Locale.ENGLISH);

        Paper[] p_array;
        p_array = getPArray(in);

        printPArrayData(p_array);


    }

    public static Paper[] getPArray(Scanner in) {
        Paper[] p_array;

        // Receiving the first line (Size of p_array).
        int siz_p = in.nextInt();
        p_array = new Paper[siz_p];

        // Collecting the info.
        for(int i = 0; i < siz_p; i++) {
            // Getting the info.
            String type;
            type = in.nextLine();
            String title;
            title = in.nextLine();
            String pages;
            pages = in.nextLine();
            String magaz;
            magaz = in.nextLine();
            String qualis;
            qualis = in.nextLine();

            // Creating the paper object;
            if(type.equals("trabalhoCompletoEmCongresso")) {
                p_array[i] = new LongPaper(title, pages, magaz, qualis);
            } else if(type.equals("artigoEmPeriodico")) {
                p_array[i] = new PeriodicPaper(title, pages, magaz, qualis);
            } else {
                p_array[i] = new ShortPaper(title, pages, magaz, qualis);
            }
        }

        return p_array;
    }

    public static void printPArrayData(Paper[] p_array) {
        // Defining the counter variables:
        int long_count, short_count, periodic_count;
        long_count = short_count = periodic_count = 0;

        int long_pages, short_pages, periodic_pages;
        long_pages = short_pages = periodic_pages = 0;

        int a1, a2, b1, b2, b3, b4, b5, c;
        a1 = a2 = b1 = b2 = b3 = b4 = b5 = c = 0;

        // Defining the size of p_array.
        int n = p_array.length;

        // Counting...
        for(int i = 0; i < n; i++) {
            if(p_array[i] instanceof LongPaper) {
                if(p_array[i].getNumPages() >= 0) {
                    long_count+=1;
                    long_pages+=p_array[i].getNumPages();
                }
            } else if(p_array[i] instanceof ShortPaper) {
                if(p_array[i].getNumPages() >= 0) {
                    short_count+=1;
                    short_pages+=p_array[i].getNumPages();
                }
            } else if(p_array[i] instanceof PeriodicPaper) {
                if(p_array[i].getNumPages() >= 0) {
                    periodic_count+=1;
                    periodic_pages+=p_array[i].getNumPages();
                }
            }

            // Counting qualis...
            String qualis = p_array[i].getQualis();
            if(qualis.equals("C")) {
                c++;
            } else if(qualis.equals("B5")) {
                b5++;
            } else if(qualis.equals("B4")) {
                b4++;
            } else if(qualis.equals("B3")) {
                b3++;
            } else if(qualis.equals("B2")) {
                b2++;
            } else if(qualis.equals("B1")) {
                b1++;
            } else if(qualis.equals("A2")) {
                a2++;
            } else if(qualis.equals("A1")) {
                a1++;
            }
        }

        System.out.println("Total de paginas produzidas: " + (long_pages + short_pages + periodic_pages));
        System.out.printf(new Locale("en", "US"), "Media por tipo: curto %.2f / longo %.2f / periodico %.2f\n", (double)(short_pages/short_count), 
        (double)(long_pages/long_count), (double)(periodic_pages/periodic_pages));
        System.out.print("Publicacoes por Qualis: ");
        System.out.print(a1 + " x A1; ");
        System.out.print(a2 + " x A2; ");
        System.out.print(b1 + " x B1; ");
        System.out.print(b2 + " x B2; ");
        System.out.print(b3 + " x B3; ");
        System.out.print(b4 + " x B4; ");
        System.out.print(b5 + " x B5; ");
        System.out.println(c + " x C;");

    }
}