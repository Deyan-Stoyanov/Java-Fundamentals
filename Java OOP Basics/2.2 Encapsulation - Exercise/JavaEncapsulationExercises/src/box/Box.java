package box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box() {
    }

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume(){
        return this.height * this.width * this.length;
    }

    public double getSurfaceArea(){
        return (2 * this.length * this.height) + (2 * this.width * this.height) + (2 * this.width * this.length);
    }

    public double getLateralSurfaceArea(){
        return (2 * this.length * this.height) + (2 * this.width * this.height);
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%n" +
                "Lateral Surface Area - %.2f%n" +
                "Volume - %.2f", this.getSurfaceArea(), this.getLateralSurfaceArea(), this.getVolume());
    }
}
