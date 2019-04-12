public class MovieDisc extends Item {
    private int length;

    public MovieDisc(int barcode, String name, double price, int length) {
        super(barcode, name, price);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return super.getName() + " (R$" + super.getPriceString() + ") - " + this.length + " minutos";
    }
    
} 
