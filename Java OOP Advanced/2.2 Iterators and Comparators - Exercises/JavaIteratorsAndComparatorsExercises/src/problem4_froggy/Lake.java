package problem4_froggy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake<T> implements Iterable<T> {
    private T[] numbers;
    private int currentIndex;

    public Lake(T... numbers) {
        this.numbers = numbers;
        this.currentIndex = 0;
    }

    private final class Frog<T> implements Iterator<T>{

        @Override
        public boolean hasNext() {
            return currentIndex + 2 < numbers.length;
        }

        @Override
        public T next() {
            return (T) numbers[currentIndex += 2];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog<>();
    }

    public List<T> jump(){
        List<T> allJumps = new ArrayList<>();
        allJumps.add(numbers[currentIndex]);
        while(iterator().hasNext()) {
            allJumps.add(iterator().next());
        }
        this.currentIndex = 1;
        if(this.numbers.length > 1){
            allJumps.add(numbers[currentIndex]);
        }
        while(iterator().hasNext()) {
            allJumps.add(iterator().next());
        }
        return allJumps;
    }
}
