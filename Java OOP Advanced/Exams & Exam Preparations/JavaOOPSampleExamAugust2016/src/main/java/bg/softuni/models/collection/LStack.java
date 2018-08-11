package bg.softuni.models.collection;

import bg.softuni.interfaces.Fragment;
import bg.softuni.interfaces.Stack;

import java.util.Iterator;
import java.util.LinkedList;

public class LStack<T extends Fragment> implements Stack<T> {

    private LinkedList<T> innerList;

    public LStack() {
        this.innerList = new LinkedList<>();
    }

    @Override
    public Integer size() {
        return this.innerList.size();
    }

    @Override
    public T push(T t) {
        this.innerList.addLast(t);
        return t;
    }

    @Override
    public T pop() {
        return this.innerList.removeLast();
    }

    @Override
    public T peek() {
        return this.innerList.getLast();
    }

    @Override
    public Boolean isEmpty() {
        return this.innerList.isEmpty();
    }

    @Override
    public Iterator<T> iterator() {
        return this.innerList.iterator();
    }
}