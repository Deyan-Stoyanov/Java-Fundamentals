package fragile_base_class;

public class Predator extends Animal {
    private int health;

    public Predator() {
        super();
    }

    public void feed(Food food){
        super.eat(food);
        this.health++;
    }

//    @Override
//    public void eat(Food food) {
//        this.feed(food);
//    }
}
