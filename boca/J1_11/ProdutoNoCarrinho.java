public class ProdutoNoCarrinho {

    // "ProdutoNoCarrinho" means "ProductOnTheCart".

    private Produto item;
    private int amount;

    ProdutoNoCarrinho (String name, double price, int amount) {
        item = new Produto(name, price);
        this.amount = amount;
    }

    int getAmount() {
        return this.amount;
    }

    Produto getItem() {
        return this.item;
    }
}  
