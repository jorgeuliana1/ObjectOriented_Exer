import java.util.Formatter;

public class Item {
    private String name;
    private double price;
    private int barcode;

    public Item(int barcode, String name, double price) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
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

    public int getBarcode() {
        return this.barcode;
    }

    @Override
    public boolean equals(Object i) {
        Item i2 = (Item)i;

        if(this.barcode - i2.barcode == 0)
            return true;
        else
            return false;
    }

    public boolean equals(int i) {
        if(this.barcode - i == 0)
            return true;
        else
            return false;
    }

}