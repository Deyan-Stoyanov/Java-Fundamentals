package problem9_custom_list_iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MyList<T extends Comparable<T>> implements List<T>, Iterable<T> {
    private Object[] arr;
    private int currentCapacity;

    public MyList() {
        this.arr = new Object[1];
        this.currentCapacity = 0;
    }

    private boolean isValid(int index){
        return (index >= 0 && index < this.currentCapacity);
    }

    @Override
    public void add(T element) {
        if (element == null) {
            return;
        }
        if (currentCapacity == arr.length) {
            this.increaseSize();
        }
        this.arr[this.currentCapacity] = element;
        this.currentCapacity++;
    }

    @Override
    public T remove(int index) {
        if(this.isValid(index)){
            Object[] newArr = new Object[this.arr.length];
            T t = (T) this.arr[index];
            for (int i = 0; i < index; i++) {
                newArr[i] = this.arr[i];
            }
            for (int i = index + 1; i < this.currentCapacity; i++) {
                newArr[i - 1] = this.arr[i];
            }
            this.arr = newArr;
            if (this.arr.length / 4 > this.currentCapacity) {
                this.decreaseSize();
            }
            this.currentCapacity--;
            return t;
        }
        return null;
    }

    @Override
    public boolean contains(T element) {
        for (Object o : arr) {
            if (o.equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        if(this.isValid(firstIndex) && this.isValid(secondIndex)){
            T temp = (T) this.arr[firstIndex];
            this.arr[firstIndex] = this.arr[secondIndex];
            this.arr[secondIndex] = temp;
        }
    }

    @Override
    public int countGreaterThan(T element) {
        int count = 0;
        for (Object o : arr) {
            if(o != null) {
                if (element.compareTo((T) o) < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public T getMax() {
        T max = (T) this.arr[0];
        for (Object o : arr) {
            if(o != null){
                if (max.compareTo((T) o) < 0) {
                    max = (T) o;
                }
            }
        }
        return max;
    }

    @Override
    public T getMin() {
        T min = (T) this.arr[0];
        for (Object o : arr) {
            if(o != null) {
                if (min.compareTo((T) o) > 0) {
                    min = (T) o;
                }
            }
        }
        return min;
    }

    public void increaseSize() {
        Object[] newArr = new Object[arr.length * 2];
        for (int i = 0; i < this.currentCapacity; i++) {
            newArr[i] = this.arr[i];
        }
        this.arr = newArr;
    }

    public void decreaseSize() {
        Object[] newArr = new Object[arr.length / 2];
        for (int i = 0; i < currentCapacity; i++) {
            newArr[i] = this.arr[i];
        }
        this.arr = newArr;
    }

    @Override
    public Iterable<T> getElements() {
        return Arrays.stream(this.arr).map( x -> (T)x).collect(Collectors.toList());
    }

    @Override
    public void sort(){
        for (int i = 0; i < this.currentCapacity - 1; i++) {
            for (int j = 0; j < this.currentCapacity - i - 1; j++) {
                if(((T) arr[j]).compareTo((T) arr[j + 1]) > 0){
                    this.swap(j, j + 1);
                }
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < currentCapacity;
            }

            @Override
            public T next() {
                return (T) arr[index++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (int i = 0; i < this.currentCapacity; i++) {
            action.accept((T)this.arr[i]);
        }
    }
}
