import java.util.Scanner;

public class J1_11 {
    public static void main(String[] args) {

        // This code block given by the problem
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        CarrinhoDeCompras c = new CarrinhoDeCompras(num);
        for (int i = 0; i < num; i++) {
            String nome = scanner.nextLine();
            double preco = scanner.nextDouble();
            scanner.nextLine();
            int qtd = scanner.nextInt();
            scanner.nextLine();
            c.adicionar(nome, preco, qtd);
        }
        c.imprimir();
        // END OF THE CODE BLOCK
    }
} 
