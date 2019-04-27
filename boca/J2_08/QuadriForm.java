abstract class QuadriForm implements GeoForm {
    private double sizA;
    private double sizB;
    private double sizC;
    private double sizD;

    public QuadriForm(double a, double b, double c, double d) {
        sizA = a;
        sizB = b;
        sizC = c;
        sizD = d;
    }

    public double getPerimeter() {
        return sizA + sizB + sizC + sizD;
    }

    public double getSideSize( int index ) {
        if(index == 0) return sizA;
        else if(index == 1) return sizB;
        else if(index == 2) return sizC;
        else return sizD;
    }
}