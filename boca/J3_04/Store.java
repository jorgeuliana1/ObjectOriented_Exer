import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

public class Store implements Comparable<Store> {

    private int number; /* 1 to 4 */
    private ArrayList<Double> sells;

    public Store(int n) {
        setNumber(n);
        sells = new ArrayList<>();
    }

    public void setNumber(int n) {
        if(n >= 1 && n <= 4)
            number = n;
        else if(n > 4)
            number = 4;
        else if(n < 1)
            number = 1;
    }

    public void addSell(double n) {
        sells.add(n);
    }

    @Override
    public int compareTo(Store s) {
        return (number - s.number);
    }

    @Override
    public boolean equals(Object os) {
        Store s = (Store)os;
        int ret_num;
        if(compareTo(s) == 0)
            return true;
        else
            return false;
    }

    public double getSum() {
        double sum = 0;

        for(int i = 0; i < sells.size(); i++) {
            sum += sells.get(i);
        }

        return sum;
    }

    public double getAverage() {
        if(sells.size() != 0)
            return getSum() / sells.size();
        else return 0.0;
    }

}