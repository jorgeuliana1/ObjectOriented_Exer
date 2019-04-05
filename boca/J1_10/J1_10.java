import java.util.Scanner; 

public class J1_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        printFibonacci(n);

    }

    public static int getFibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
	
        int fibo_value = getFibonacci(n - 1) + getFibonacci(n - 2);
        return fibo_value;
    }

    public static void printFibonacci(int n) {
        if(n > 47)
            n = 47;

        int fibo = 0;
        int temp_fibo = 0;

        for(int i = 0; i < n; i++) {
            if(i == 0)
                fibo = 0;
            if(i == 1)
                fibo = 1;
            else {
                int temp_temp_fibo = temp_fibo;
                temp_fibo = fibo;
                fibo = temp_temp_fibo + temp_fibo;
            }

            System.out.print(Integer.toString(fibo) + " ");
        }
        System.out.println();
    }
} 
