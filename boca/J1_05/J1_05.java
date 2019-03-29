import java.util.Scanner;
import java.util.Arrays;

public class J1_05 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] nums;
		nums = new int[10];

		for(int i = 0; i < 10; i++)
			nums[i] = sc.nextInt();

		int initial_vle,
			increment;
		
		initial_vle = nums[0];
		increment = nums[1] - nums[0];

		int[] model;
		model = new int[10];

		for(int i = 0; i < 10; i++)
			model[i] = initial_vle + i * increment;

		if(Arrays.equals(model, nums))
			System.out.println("Sim " + initial_vle + " " + increment);

		else
			System.out.println("Nao");

	}
}
