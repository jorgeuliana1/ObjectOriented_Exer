import java.util.Scanner;
import java.io.File;
import java.util.Locale;

public class J3_04 {

    public static void main(String[] args) {

        Scanner in;
        in = new Scanner(System.in);

        String path;
        path = in.nextLine();

        File f = new File(path);
        CSVReader store_csv = new CSVReader(f, ",", true);
        int size = store_csv.getSize()[0];

        Store[] stores = new Store[4];

        int stores_n = 4;

        for(int i = 1; i <= stores_n; i++) {
            stores[i - 1] = new Store(i);
        }

        for(int i = 0; i < size; i++) {
            int n_store = Integer.parseInt(store_csv.getContent(i, 0));
            double sell = Double.parseDouble(store_csv.getContent(i, 1));

            stores[n_store - 1].addSell(sell);
        }

        for(int i = 0; i < stores_n; i++) {
            System.out.printf(new Locale("pt", "BR"), "Filial %d: Total = R$ %.2f; Media = R$ %.2f\n", i+1, stores[i].getSum(), stores[i].getAverage());
        }
    }

}