
/* ---------------------------
Laboratoire : Labo 07
Fichier : StackIterator.java
Auteur(s) : Alexis Monthoux - Victor Nondjock
Date : 23.11.21

But :   an iterator to navigate through the
        stack and access elements

Remarque(s) : StackIterator implements Iterator

Compilateur : OpenJDK 11

--------------------------- */
package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <T> class of contained element
 */
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
