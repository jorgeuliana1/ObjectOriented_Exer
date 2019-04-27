public class RectangleForm extends QuadriForm {
    public RectangleForm(double sideA, double sideB) {
        super(sideA, sideA, sideB, sideB);
    }

    public double getArea() {
        return super.getSideSize(0) * super.getSideSize(2);
    }

    @Override
    public String toString() {
        return "Retangulo de base " + String.format("%.2f", super.getSideSize(0)) + " e altura " + String.format("%.2f", super.getSideSize(2))
               + " - perimetro: " + String.format("%.2f", this.getPerimeter()) + "; area: " + String.format("%.2f", this.getArea()) + ".";
    }
} 
