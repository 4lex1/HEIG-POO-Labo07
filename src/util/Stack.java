package util;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node<T> first;
    private int size;

    public Stack<T> push(T element) {
        first = new Node<>(element, first);
        ++size;
        return this;
    }

    public T pop() {
        if (first == null) {
            throw new EmptyStackException();
        }

        T elem = first.getElement();
        first = first.getNext();
        --size;
        return elem;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[ ");

        for (T el : this) {
            sb.append("<").append(el).append("> ");
        }

        sb.append("]");

        return sb.toString();
    }

    public Object[] toArray() {
        Object[] result = new Object[size];

        int i = 0;
        for (T el : this) {
            result[i++] = el;
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray(T[] a){
        if (a.length < size){
            return (T[]) Arrays.copyOf(toArray(), size, a.getClass());
        }

        int i = 0;
        for (T el : this){
            a[i++] = el;
        }

        return a;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new StackIterator<>(first);
    }
}

