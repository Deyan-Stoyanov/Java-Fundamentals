package stack_of_strings;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StackOfStrings {
    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String s) {
        this.data.add(s);
    }

    public String pop() {
        if (!this.isEmpty()) {
            return this.data.remove(this.data.size() - 1);
        }
        throw new NoSuchElementException("Stack is empty");
    }

    public String peek() {
        if (!this.isEmpty()) {
            return this.data.get(this.data.size() - 1);
        }
        throw new NoSuchElementException("Stack is empty");
    }

    public boolean isEmpty() {
        return this.data.size() == 0;
    }
}
