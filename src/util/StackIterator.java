package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackIterator<T> implements Iterator<T> {
    private Node<T> current;

    public StackIterator(Node<T> element) {
        current = element;
    }

    @Override
    public T next() {
        if (current == null) {
            throw new NoSuchElementException();
        }

        T element = current.getElement();
        current = current.getNext();
        return element;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }
}
