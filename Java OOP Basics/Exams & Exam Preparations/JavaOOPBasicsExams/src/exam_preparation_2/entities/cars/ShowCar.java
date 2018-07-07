package exam_preparation_2.entities.cars;

public class ShowCar extends Car {

    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    public int getStars() {
        return this.stars;
    }

    private void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%n%d *", this.getStars());
    }

    @Override
    public void tune(int tuneIndex, String addOn) {
        super.tune(tuneIndex, addOn);
        this.setStars(this.getStars() + tuneIndex);
    }
}
