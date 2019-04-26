public class MovieDisc extends Item {
    private int length;

    public MovieDisc(String name, double price, int length) {
        super(name, price);
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
