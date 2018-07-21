package problem3_coffee_machine;

import problem3_coffee_machine.enums.CoffeeSize;
import problem3_coffee_machine.enums.CoffeeType;

public class Coffee {
    private CoffeeSize size;
    private CoffeeType type;

    public Coffee(String size, String type) {
        this.size = Enum.valueOf(CoffeeSize.class, size.toUpperCase());
        this.type = Enum.valueOf(CoffeeType.class, type.toUpperCase());
    }

    public int getPrice(){
        return this.size.getPrice();
    }

    @Override
    public String toString() {
        return this.size.toString() + " " + this.type.toString();
    }
}
