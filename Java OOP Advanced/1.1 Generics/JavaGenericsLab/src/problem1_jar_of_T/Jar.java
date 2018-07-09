package problem1_jar_of_T;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {

    private Deque<T> deque;

    public Jar() {
        this.deque = new ArrayDeque<>();
    }

    public void add(T element) {
        this.deque.push(element);
    }

    public T remove() {
        if (!this.deque.isEmpty()) {
            return this.deque.pop();
        }
        return null;
    }

    public T get() {
        if (!this.deque.isEmpty()) {
            return this.deque.peek();
        }
        return null;
    }
}
