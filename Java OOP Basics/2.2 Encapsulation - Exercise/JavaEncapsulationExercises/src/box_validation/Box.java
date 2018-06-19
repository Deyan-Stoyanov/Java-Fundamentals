package box_validation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box() {
    }

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public double getLength() {
        return length;
    }

    private void setLength(double length) {
        if(length <= 0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if(width <= 0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if(height <= 0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
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
