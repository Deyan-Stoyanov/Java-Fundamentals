package problem7_custom_list;

public interface List<T extends Comparable<T>> {
    void add(T element);

    T remove(int index);

    boolean contains(T element);

    void swap(int firstIndex, int secondIndex);

    int countGreaterThan(T element);

    T getMax();

    T getMin();

    Iterable<T> getElements();
}
