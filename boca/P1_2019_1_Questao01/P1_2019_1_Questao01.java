import java.util.Scanner;

public class P1_2019_1_Questao01 {
    public static void main(String[] args) {

        String car_name, supercar_name;
        double dist, fuel;

        Scanner in = new Scanner(System.in);

        car_name = in.nextLine();
        supercar_name = in.nextLine();

        try {
            fuel = Double.parseDouble(in.nextLine());
            dist = Double.parseDouble(in.nextLine());
        } catch(Exception e) {
            return;
        }

        Car c = new Car(car_name, fuel);
        Supercar s = new Supercar(supercar_name, fuel);

        c.drive(dist);
        s.drive(dist);

    }
}
