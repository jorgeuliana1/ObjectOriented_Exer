public class J1_02 {
	public static void main(String[] args) {
		int i;

		for(i = 1001; i < 9999; i++) /* Analyzing the intengers in the interval. */
		{
			int ab,
			    cd;

			// Defining the "halfs" of the number.
			ab = i / 100;
			cd = i % 100;

			int ef = ab + cd;
			if(Math.pow(ef, 2) == i)
				System.out.println(Integer.toString(i));
			
		}

	}
}
