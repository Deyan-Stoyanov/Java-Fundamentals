package problem1_shapes_drawing;

public class Circle implements Drawable {
    private Integer radius;

    public Circle() {
    }

    public Circle(Integer radius) {
        this.radius = radius;
    }

    public Integer getRadius() {
        return radius;
    }

    @Override
    public void draw() {
        double innerRadius = this.getRadius() - 0.4;
        double outerRadius = this.getRadius() + 0.4;
        for (double y = this.getRadius(); y >= -this.getRadius(); --y) {
            for (double x = -this.getRadius(); x < outerRadius; x += 0.5) {
                double value = x * x + y * y;
                if (value >= innerRadius * innerRadius && value <= outerRadius * outerRadius) {
                    System.out.print("*");
                } else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}


