public class Book extends Item {
    private String author;

    public Book(int barcode, String name, double price, String author) {
        super(barcode, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return super.getName() + " (R$" + super.getPriceString() + ") - " + this.author;
    }
    
} 
 
