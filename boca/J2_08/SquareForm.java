public class SquareForm extends RectangleForm {
    public SquareForm(double side) {
        super(side, side);
    }
    @Override
    public String toString() {
        return "Quadrado de lado " + String.format("%.2f", super.getSideSize(0)) + " - perimetro: " + String.format("%.2f", this.getPerimeter()) + "; area: " + String.format("%.2f", this.getArea()) + ".";
    }
}
