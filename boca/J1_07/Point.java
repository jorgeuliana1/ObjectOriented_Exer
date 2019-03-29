public class Point {

    private double x;
    private double y;
    public static void main(String[] args) {
        
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double GetX() {
        return this.x;
    }

    public double GetY() {
        return this.y;
    }

    public double DistanceTo(Point p) {
        double pX;
        double pY;
        pX = p.GetX();
        pY = p.GetY();

        return Math.sqrt(Math.pow(this.x - pX, 2) + Math.pow(this.y - pY, 2));
    }
}