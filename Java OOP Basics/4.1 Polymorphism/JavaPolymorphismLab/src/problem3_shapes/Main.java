package problem3_shapes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(2, 4);
        Shape circle = new Circle(3);
        List<Shape> shapes = new ArrayList<>(){{
           add(rectangle);
           add(circle);
        }};
        for (Shape shape : shapes) {
            shape.calculatePerimeter();
            shape.calculateArea();
            System.out.println(shape.getClass().getSimpleName());
            System.out.printf("Perimeter: %.2f%n", shape.getPerimeter());
            System.out.printf("Area: %.2f%n", shape.getArea());
        }
    }
}
