import java.util.Scanner;

public class J1_03 {
	public static void main(String[] args) {
		/* Creating object sc */
		Scanner sc = new Scanner(System.in);
		
		/* To get a line: sc.nextLine();
		   To get an integer: sc.nextInt();
		   etc...
		*/

		int[] intput;
		intput = new int[2];

		/* Equivalent to:
			scanf("%d %d", intput[0], intput[1]);
		*/

		intput[0] = sc.nextInt();
		intput[1] = sc.nextInt();

 		System.out.println(Integer.toString(MDC(intput[0], intput[1])));

	}

	public static int MDC(int x, int y) {
		/* MDC s.f. "Maximo Divisor Comum", Greatest common divisor */
		
		if(x == y)
			return x;
		else if(x > y)
			return MDC(x - y, y);
		else
			return MDC(y, x);
		
	}
}
