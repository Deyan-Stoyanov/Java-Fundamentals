package problem7_food_shortages;

public class Citizen implements Buyer {
    private String name;
    private Integer age;
    private String id;
    private String birthDate;
    private Integer food;

    public Citizen(String name, Integer age, String id, String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
        this.food = INITIAL_FOOD_COUNT;
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
        this.food += 10;
    }

    public String getId() {
        return id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public Integer getFood() {
        return food;
    }
}
