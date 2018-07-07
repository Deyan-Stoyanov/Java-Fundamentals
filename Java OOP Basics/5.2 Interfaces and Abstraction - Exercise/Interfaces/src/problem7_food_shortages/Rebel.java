package problem7_food_shortages;

public class Rebel implements Buyer {
    private String name;
    private Integer age;
    private String group;
    private Integer food;

    public Rebel() {
    }

    public Rebel(String name, Integer age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = this.INITIAL_FOOD_COUNT;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getAge() {
        return this.age;
    }

    @Override
    public void buyFood() {
        this.food += 5;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public Integer getFood() {
        return food;
    }
}
