package problem1_listy_iterator;

import java.util.Iterator;

public class ListyIterator<T> implements Iterator<T> {
    private int internalIndex;
    private T[] array;

    public ListyIterator(T... input) {
        this.internalIndex = 0;
        this.array = input;
    }

    @Override
    public boolean hasNext() {
        if(this.internalIndex + 1 < this.array.length){
            return true;
        }
        return false;
    }

    @Override
    public T next() {
        return this.array[internalIndex++];
    }

    public void print(){
        if(this.internalIndex >= this.array.length){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(this.array[this.internalIndex]);
    }
}
