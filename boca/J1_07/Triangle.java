public class Triangle {

    private Point a;
    private Point b;
    private Point c;
    public static void main(String[] args) {
        
    }

    public Triangle (Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Point GetA() {
        return this.a;
    }

    public Point GetB() {
        return this.b;
    }

    public Point GetC() {
        return this.c;
    }

    public double GetPerimeter() {
        return this.c.DistanceTo(a) + this.a.DistanceTo(b) + this.b.DistanceTo(c);
    }
}