package P05_Square;

import org.junit.Assert;
import org.junit.Test;

public class RectangleTests {
    @Test
    public void getRectangleSidesTest() {
        Rectangle rect = new Rectangle();
        rect.setHeight(5);
        rect.setWidth(10);
        Assert.assertEquals(10, rect.getWidth());
        Assert.assertEquals(5, rect.getHeight());
    }

    @Test
    public void getSquareSidesTest() {
        Square square = new Square();
        square.setHeight(10);
        square.setWidth(10);
        Assert.assertEquals(10, square.getWidth());
        Assert.assertEquals(10, square.getHeight());
    }

    @Test
    public void getRectangleAreaTest() {
        Rectangle rect = new Rectangle();
        rect.setHeight(5);
        rect.setWidth(10);
        Assert.assertEquals(50, rect.getArea());
    }

    @Test
    public void getSquareAreaTest() {
        Square square = new Square();
        square.setWidth(10);
        square.setHeight(10);
        Assert.assertEquals(100, square.getArea());
    }
}
