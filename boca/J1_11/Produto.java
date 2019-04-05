public class Produto {

    // "Produto" means "Product" or "Item".

    private String name;
    private double price;

    Produto (String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }
}  
