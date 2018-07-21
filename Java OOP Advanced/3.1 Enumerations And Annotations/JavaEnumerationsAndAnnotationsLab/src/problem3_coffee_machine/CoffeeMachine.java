package problem3_coffee_machine;

import problem3_coffee_machine.enums.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {
    private List<Coffee> coffeeList;
    private int money;

    public CoffeeMachine() {
        this.coffeeList = new ArrayList<>();
    }

    public void buyCoffee(String size, String type){
        Coffee coffee = new Coffee(size, type);
        if(coffee.getPrice() <= this.money){
            this.coffeeList.add(coffee);
            this.money = 0;
        }
    }

    public void insertCoin(String coin){
        this.money += Enum.valueOf(Coin.class, coin).getValue();
    }

    public Iterable<Coffee> coffeesSold(){
        return this.coffeeList;
    }
}
