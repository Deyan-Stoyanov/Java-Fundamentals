package P03_GraphicEditor;

public abstract class Shape implements Drawable{

    @Override
    public void draw() {
        System.out.println("I'm " + this.getClass().getSimpleName());
    }
}
