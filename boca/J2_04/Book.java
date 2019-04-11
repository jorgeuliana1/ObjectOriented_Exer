public class Book extends Item {
    private String author;

    public Book(String name, double price, String author) {
        super(name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return this.name + " (R$"this.price + ") - " + this.author;
    }
    
} 
 
