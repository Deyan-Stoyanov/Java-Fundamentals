package problem2_method_overriding;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle() {
    }

    protected Rectangle(double sideA) {
        this.sideA = sideA;
    }

    public Rectangle(double sideA, double sideB) {
        this(sideA);
        this.sideB = sideB;
    }

    public double area() {
        return this.getSideA() * this.getSideB();
    }

    public double getSideA() {
        return sideA;
    }

    private void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    private void setSideB(double sideB) {
        this.sideB = sideB;
    }
}
