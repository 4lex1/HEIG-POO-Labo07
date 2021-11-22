package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
    private Node<T> first;

    public Stack() {

    }

    public Stack<T> push(T element) {
        first = new Node<>(element, first);
        return this;
    }

    public T pop() {
        if (first == null) {
            throw new NoSuchElementException();
        }

        T elem = first.getElement();
        first = first.getNext();
        return elem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T t : this) {
            sb.append("<").append(t).append("> ");
        }

        return sb.toString();
    }

    public Object[] toArray() {
        Object[] result = new Object[size()];

        int i = 0;
        for (T t : this) {
            result[i] = t;
            ++i;
        }

        return result;
    }

    public int size() {
        int value = 0;

        for (T t : this) {
            value++;
        }

        return value;
    }

    public Iterator<T> iterator() {
        return new StackIterator<>(first);
    }

}

