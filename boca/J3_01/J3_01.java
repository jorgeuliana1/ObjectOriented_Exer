import java.util.Scanner;

public class J3_01 {

    public static void main(String[] args) {
        Scanner in;
        in = new Scanner(System.in);

        int n = Integer.parseInt(in.nextLine());

        String[] s = new String[n];

        for(int i = 0; i < n; i++) {
            s[i] = in.nextLine();
        }

        n = Integer.parseInt(in.nextLine());

        in.close();

        try {
            System.out.println("Elemento na posicao " + n + ": " + s[n]);
        } catch(Exception ArrayOutofBounds) {
            System.out.println("Posicao " + n + " esta fora dos limites do vetor.");
        }
    }

}