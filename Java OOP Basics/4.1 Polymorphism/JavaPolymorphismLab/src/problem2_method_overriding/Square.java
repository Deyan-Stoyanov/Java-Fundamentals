package problem2_method_overriding;

public class Square extends Rectangle{
    public Square(double sideA) {
        super(sideA);
    }

    @Override
    public double area(){
        return this.getSideA() * this.getSideA();
    }
}
