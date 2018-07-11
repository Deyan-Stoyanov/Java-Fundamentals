package problem3_generic_swap_method;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    public List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T element){
        this.list.add(element);
    }

    public void swap(List<T> list, int firstIndex, int lastIndex){
        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(lastIndex));
        list.set(lastIndex, temp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T t : list) {
            sb.append(String.format("%s: %s%n", t.getClass().getName(), t.toString()));
        }
        return sb.toString();
    }
}
