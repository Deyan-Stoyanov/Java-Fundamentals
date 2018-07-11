package problem11_threeuple;

public class CustomThreeuple<K extends Comparable<K>, V extends Comparable<V>, V2 extends Comparable<V2>> implements Threeuple<K, V, V2> {
    private K key;
    private V value;
    private V2 secondValue;

    public CustomThreeuple() {
    }

    public CustomThreeuple(K key, V value, V2 secondValue) {
        this.setKey(key);
        this.setValue(value);
        this.setSecondValue(secondValue);
    }

    @Override
    public K getKey() {
        return this.key;
    }

    @Override
    public V getValue() {
        return this.value;
    }

    public V2 getSecondValue() {
        return this.secondValue;
    }

    private void setKey(K key) {
        this.key = key;
    }

    private void setValue(V value) {
        this.value = value;
    }

    private void setSecondValue(V2 secondValue) {
        this.secondValue = secondValue;
    }

    public void put(K key, V value, V2 secondValue) {
        this.setKey(key);
        this.setValue(value);
        this.setSecondValue(secondValue);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getKey()).append(" -> ").append(this.getValue()).append(" -> ").append(this.getSecondValue());
        return sb.toString();
    }
}
