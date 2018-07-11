package problem10_tuple;

public class CustomTuple<K extends Comparable<K>, V extends Comparable<V>> implements Tuple<K, V>{
    private K key;
    private V value;

    public CustomTuple() {
    }

    public CustomTuple(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey(){
        return this.key;
    }

    @Override
    public V getValue(){
        return this.value;
    }

    @Override
    public void put(K key, V value){
        this.setKey(key);
        this.setValue(value);
    }

    private void setKey(K key) {
        this.key = key;
    }

    private void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s", this.getKey(), this.getValue());
    }
}
