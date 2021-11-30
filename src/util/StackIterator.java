package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

class StackIterator<T> implements Iterator<T> {
    private Node<T> current;

    StackIterator(Node<T> element) {
        current = element;
    }

    @Override
    public T next() {
        if (current == null) {
            throw new NoSuchElementException("trying to access null element.");
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
