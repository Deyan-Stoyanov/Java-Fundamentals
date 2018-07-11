package problem4_generic_swap_method_integers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    private List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T element){
        this.list.add(element);
    }

    public void swap(int firstIndex, int lastIndex){
        this.swap(this.list, firstIndex, lastIndex);
    }

    public void swap(List<T> list, int firstIndex, int lastIndex){
        T temp = list.get(firstIndex);
        list.set(firstIndex, list.get(lastIndex));
        list.set(lastIndex, temp);
    }

    public List<T> getList() {
        return Collections.unmodifiableList(this.list);
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
