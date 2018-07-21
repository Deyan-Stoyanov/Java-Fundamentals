package problem3_stack_iterator;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Stack<T> implements Iterable<T> {
    private T[] array;
    private int currentLength;

    public Stack(T... input) {
        this.array = input;
        this.currentLength = 0;
    }

    public void setArray(T... array) {
        this.array = array;
    }

    private final class StackIterator<T> implements Iterator<T>{

        @Override
        public boolean hasNext() {
            return currentLength + 1 < array.length && array[currentLength + 1] != null;
        }

        @Override
        public T next() {
            return (T) array[currentLength++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator<>();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (int j = array.length - 1; j >= 0; j--) {
            action.accept(array[j]);
        }
    }

    public void push(T... t){
        if(this.array.length == 0){
            this.setArray(t);
        }else {
            T[] newArr = (T[]) Array.newInstance(array[0].getClass(), array.length + t.length);
            System.arraycopy(array, 0, newArr, 0, array.length);
            for (int i = 0; i < t.length; i++) {
                newArr[i + array.length] = t[i];
            }
            this.array = newArr;
        }
    }

    public void pop(){
        if(this.array.length == 0){
            throw new NoSuchElementException("No elements");
        }
        T t = this.array[this.array.length - 1];
        T[] newArr = (T[]) Array.newInstance(array[0].getClass(), array.length - 1);
        System.arraycopy(array, 0, newArr, 0, newArr.length);
        this.array = newArr;
    }
}
