package P05_Square;

public class Square extends Rectangle {
    public Square() {
    }

    @Override
    protected void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    protected void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}
