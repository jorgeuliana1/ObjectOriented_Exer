public class CircleForm implements GeoForm {

    private double radius;

    public CircleForm(double r) {
        radius = r;
    }

    public double getArea() {
        return Math.pow(radius, 2)*Math.PI;
    }

    public double getPerimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public String toString() {
        return "Circulo de raio " + String.format("%.2f", this.radius) + " - perimetro: " + String.format("%.2f", this.getPerimeter()) + "; area: " + String.format("%.2f", this.getArea()) + ".";
    }
    
}