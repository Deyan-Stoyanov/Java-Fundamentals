package problem7_custom_list;

import java.util.ArrayList;

public class CustomList<T extends Comparable<T>> implements List<T> {
    private java.util.List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    private boolean isValid(int index){
        return (index >= 0 && index < this.list.size());
    }

    @Override
    public void add(T element) {
        this.list.add(element);
    }

    @Override
    public T remove(int index) {
        return this.list.remove(index);
    }

    @Override
    public boolean contains(T element) {
        return this.list.contains(element);
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        if(this.isValid(firstIndex) && this.isValid(secondIndex)){
            T temp = this.list.get(firstIndex);
            this.list.set(firstIndex, this.list.get(secondIndex));
            this.list.set(secondIndex, temp);
        }
    }

    @Override
    public int countGreaterThan(T element) {
        int count = 0;
        for (T t : list) {
            if (element.compareTo(t) < 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public T getMax() {
        T max = this.list.get(0);
        for (T t : list) {
            if (max.compareTo(t) < 0) {
                max = t;
            }
        }
        return max;
    }

    @Override
    public T getMin() {
        T min = this.list.get(0);
        for (T t : list) {
            if (min.compareTo(t) > 0) {
                min = t;
            }
        }
        return min;
    }

    @Override
    public Iterable<T> getElements() {
        return this.list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T o : list) {
            sb.append(o);
            if(list.indexOf(o) != this.list.size() - 1){
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
