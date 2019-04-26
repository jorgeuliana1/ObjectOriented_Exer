import java.util.Formatter;

public class Item implements Comparable<Item> {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceString() {

        Formatter f;
        f = new Formatter();
        
        f.format("%.2f", this.price);
        String output =  f.out().toString();

        f.close();
        return output;

    }

    @Override
    public int compareTo( Item i ) {
        
        if ( this.price > i.price ) 
            return -1;
        else if ( this.price < i.price )
            return 1;
        else {
            return this.name.compareTo(i.name);
        }

    }

}