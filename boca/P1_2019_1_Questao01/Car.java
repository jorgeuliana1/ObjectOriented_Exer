import java.util.Locale;

public class Car {

    private String name;
    private double fuel;
    int speed = 100;
    int prfmc = 10;

    public Car(String n, double f) {
        name = n;
        fuel = f;
    }

    public void drive(double d) {

        fuel -= d/prfmc;
        
        double time = d / speed;

        System.out.printf(new Locale("en", "US"), "%s andou %.1f km em %.1f horas e agora possui %.1f litros de combustivel\n", name, d, time, fuel);

    }
}