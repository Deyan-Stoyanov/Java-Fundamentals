package random_array_list;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {
    private Random random;

    public RandomArrayList() {
        this.random = new Random();
    }

    public Object getRandomElement(){
        int rnd = this.random.nextInt(super.size());
        Object element = super.get(rnd);
        super.set(rnd, super.get(super.size() - 1));
        super.remove(super.size() - 1);
        return element;
    }
}
