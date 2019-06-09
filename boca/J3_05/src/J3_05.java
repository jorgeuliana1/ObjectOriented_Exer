import java.io.*;
import java.util.Scanner;

public class J3_05 {
    public static void main(String[] args) {
        Scanner in;
        in = new Scanner(System.in);

        String path;
        path = in.nextLine();

        File f;
        f = new File(path);
        if(!f.isDirectory()) {
            System.out.println("Diretorio nao existe: " + path);
            return;
        }

        f = new File(path, generateFileName());

        // Writing in a temporary file.
        PrintWriter out;
        try {
            FileWriter fw = new FileWriter(f);
            out = new PrintWriter(fw);
        } catch (IOException e) {
            return;
        }

        int elements;
        elements = in.nextInt();

        printFibonacci(out, elements);

        out.close();

        System.out.println(f.length());


    }

    private static void printFibonacci(PrintWriter out, int elements) {
        int fibo1 = 2;
        int fibo2 = 1;

        for(int i = 0; i < elements - 1; i++) {
            String output_str = Integer.toString(fibo2);
            if(i < elements - 3)
                output_str = output_str + " ";

            out.print(output_str);
            int aux = fibo2;
            fibo2 = fibo1;
            fibo1 = aux + fibo2;
        }

        out.println();
    }

    private static String generateFileName() {
        return java.util.UUID.randomUUID().toString();
    }
}
