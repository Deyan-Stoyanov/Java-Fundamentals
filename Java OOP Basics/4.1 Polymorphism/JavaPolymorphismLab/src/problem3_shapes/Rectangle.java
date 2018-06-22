package problem3_shapes;

public class Rectangle extends Shape{
    private double height;
    private double width;

    public Rectangle() {
    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        this.width = width;
    }

    @Override
    public void calculatePerimeter() {
        super.setPerimeter((this.getHeight() * 2) + (this.getWidth() * 2));
    }

    @Override
    public void calculateArea() {
        super.setArea(this.getHeight() * this.getWidth());
    }
}
