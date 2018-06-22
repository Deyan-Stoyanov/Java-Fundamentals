package problem3_shapes;

public abstract class Shape {
    private double perimeter;
    private double area;

    protected Shape() {
    }

    public double getPerimeter() {
        return this.perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public double getArea() {
        return this.area;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    public abstract void calculatePerimeter();

    public abstract void calculateArea();
}

