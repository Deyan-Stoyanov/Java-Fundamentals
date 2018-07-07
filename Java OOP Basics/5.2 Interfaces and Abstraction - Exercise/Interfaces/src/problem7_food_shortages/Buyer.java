package problem7_food_shortages;

public interface Buyer {
    Integer INITIAL_FOOD_COUNT = 0;
    String getName();
    Integer getAge();
    void buyFood();
    Integer getFood();
}
