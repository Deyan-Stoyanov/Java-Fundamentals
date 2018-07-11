package problem10_tuple;

public interface Tuple<K, V> {
    K getKey();

    V getValue();

    void put(K key, V value);
}
