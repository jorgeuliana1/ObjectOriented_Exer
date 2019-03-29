public class J1_01 {
	public static void main(String[] args) {
		int i;

		// Part One (S1)
		double s1_result = 0.0;
		for(i = 1; i <= 50; i++) {
			s1_result += (double)((i * 2) - 1)/i;
		}
		// Printing the result on stdout
		System.out.println("S1 = " + Double.toString(s1_result));

		// Part Two (S2)
		double s2_result = 0.0;
		for(i = 1; i <= 50; i++) {
			s2_result += Math.pow(2, i)/(50 - i + 1);
		}
		// Printing the result on stdout
		System.out.println("S2 = " + Double.toString(s2_result));

		// Part Three (S3)
		double s3_result = 0.0;
		for(i = 1; i <= 10; i++) {
			if(i % 2 == 0)
				s3_result -= i/(Math.pow(i, 2));
			else
				s3_result += i/(Math.pow(i, 2));
		}
		// Printing the result on stdout
		System.out.println("S3 = " + Double.toString(s3_result));

	}
}
