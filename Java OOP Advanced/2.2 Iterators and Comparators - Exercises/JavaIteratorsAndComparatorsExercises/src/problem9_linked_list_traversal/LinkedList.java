package problem9_linked_list_traversal;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T>{
    private Node head;
    private Node tail;
    private int size;

    public class Node{
        private T element;
        private Node next;
        private Node prev;

        public Node(T value) {
            this.element = value;
        }

        public T getElement() {
            return this.element;
        }

        public Node getNext() {
            return this.next;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return this.prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    public void add(T element) {
        if (head == null) {
            head = new Node(element);
            tail = head;
        } else {
            Node currentElement = tail;
            tail = new Node(element);
            tail.prev = currentElement;
            currentElement.next = tail;
        }
        size++;
    }

    public void remove(T element) {
        Node start = head;
        while (start != null) {
            if (start.element.equals(element)) {
                if (start == head) {
                    head = head.next;
                    head.prev = null;
                    size--;
                    return;
                } else if (start == tail) {
                    tail = tail.prev;
                    tail.next = null;
                    size--;
                    return;
                } else {
                    start.prev.next = start.next;
                    start.next.prev = start.prev;
                    size--;
                    return;
                }
            }
            start = start.next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private final class MyLinkedListIterator implements Iterator<T> {

        private Node start;

        public MyLinkedListIterator() {
            start = head;
        }

        @Override
        public boolean hasNext() {
            return start != null;
        }

        @Override
        public T next() {
            Node element = start;
            start = start.next;
            return element.element;
        }
    }

    public int getSize() {
        return size;
    }
}
