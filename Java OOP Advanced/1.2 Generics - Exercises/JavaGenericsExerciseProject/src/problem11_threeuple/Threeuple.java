package problem11_threeuple;

public interface Threeuple<K, V, V2> {
    K getKey();

    V getValue();

    V2 getSecondValue();

    void put(K key, V value, V2 secondValue);
}
