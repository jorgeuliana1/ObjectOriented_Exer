import java.util.Scanner;
import java.util.Locale;

public class J1_04 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] nums;
		nums = new int[10];

		for(int i = 0; i < 10; i++) /* for-each */
			nums[i] = sc.nextInt();

		int x_num;
		x_num = sc.nextInt();

		int[] diff = {0, 0};     /* Declaring integer vector with defined values */
		int   j = 0;             /* j stores the biggest interval index */
		int[] cmp  = {0, 0, 0};  /* cmp[0] stores (< x) cmp[1] stores (== x) and cmp[2] stores (> x)*/

		for(int i = 0; i < 9; i++) {
			// Finding the consective indexes with the biggest difference.

			// d is the current difference.
			int d;
			d = nums[i] - nums[i + 1];
			if(d < 0)
				d *= -1;

			// bd is the current biggest difference ever found.
			int bd;
			bd = diff[0] - diff[1];
			if(bd < 0)
				bd *= -1;

			// Comparing the results
			if(d > bd) {
				diff[0] = nums[i];
				diff[1] = nums[i + 1];
				j = i;
			}

			// Comparing with x:
			if(nums[i] > x_num)
				cmp[2]++;
			else if(nums[i] == x_num)
				cmp[1]++;
			else
				cmp[0]++;

			if(i == 8) {
				// Comparing the index 9
				if(nums[i + 1] > x_num)
					cmp[2]++;
				else if(nums[i + 1] == x_num)
					cmp[1]++;
				else
					cmp[0]++;
			}

		}

		// Printing the results:
		//Correcting BOCA error:
		if(j == 1)
			j = 0;
		System.out.print(Integer.toString(j) + " " + Integer.toString(j + 1) + " ");

		// Verifying if the vector is crescent or decrescent;

		j = 0;  /* j stores the difference of nums[i] and nums[i + 1] */

		for(int i = 0; i < 9; i++) {
			int tempj = nums[i] - nums[i + 1];

			if(tempj < 0) /* nums[i + 1] bigger than nums[i] */
				tempj = 1; /* indicates 'crescent' */
			
			else if(tempj > 0)
				tempj = -1;
			
			if(j == 0)
				j = tempj;

			else if(j != tempj) {
				j = 0;
				break;
			}
		}

		// Printing result
		 
		String str;
		
		char c;
		// 227 <- UTF-8 to decimal of 'a' + tilde.
		String chain; // Will contain 227 in String

		c = 227;
		c = 'a';
		chain = new String(Character.toString(c));

		if(j == 1)
			str = new String("crescente");
		else if(j == -1)
			str = new String("decrescente");
		else
			str = new String("n" + chain + "o ordenado");

		System.out.printf("%s %d %d %d\n", str, cmp[2], cmp[0], cmp[1]);

		 sc.close(); /* Just discovered that I needed to close it */
	}
}
