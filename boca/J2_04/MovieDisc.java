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
        return this.name + " (R$"this.price + ") - " + this.length + " minutos";
    }
    
} 
