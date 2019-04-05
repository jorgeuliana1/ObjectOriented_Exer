public class CarrinhoDeCompras {

    //CarrinhoDeCompras means ShoppingCart

    private ProdutoNoCarrinho[] products;

    CarrinhoDeCompras(int num) {
        this.products = new ProdutoNoCarrinho[num];
    }

    public void adicionar(String name, double price, int amount) {
        // "adicionar" means "add".

        // Looking for the first empty position in the array.
        int empty_index = this.products.length + 1; /* assigning unreachable value to avoid errors */

        for(int i = 0; i < this.products.length; i++) {
            if(this.products[i] == null) {
                empty_index = i;
                break;
            }
        }

        // If the array is full.
        if(empty_index == this.products.length + 1)
            return;

        // Adding the product at the end of the array.
        this.products[empty_index] = new ProdutoNoCarrinho(name, price, amount);
    }

    public void imprimir() {
        // "imprimir" means "print".

        System.out.println("No carrinho:");

        double moneySum = 0;

        for(ProdutoNoCarrinho i : this.products) {
            // i.print();
            double money;
            money = i.getItem().getPrice() * i.getAmount();
            System.out.print("* " + i.getAmount() + " = R$ ");
            System.out.printf("%.2f\n", money);
            moneySum += money;
        }

        System.out.print("Total: R$ ");
        System.out.printf("%.2f\n", moneySum);
    }
} 
