package problem2_collection;

import java.util.Iterator;
import java.util.function.Consumer;

public class ListyIterator<T> implements Iterable<T> {
    private int internalIndex;
    private T[] array;

    public ListyIterator(T... input) {
        this.internalIndex = 0;
        this.array = input;
    }

    private final class LIter<T> implements Iterator<T>{

        @Override
        public boolean hasNext() {
            return internalIndex + 1 < array.length;
        }

        @Override
        public T next() {
            return (T) array[internalIndex++];
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new LIter<>();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (int i = 0; i < this.array.length; i++) {
            action.accept(this.array[i]);
        }
    }

    public void print(){
        if(this.internalIndex >= this.array.length){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(this.array[this.internalIndex]);
    }
}
