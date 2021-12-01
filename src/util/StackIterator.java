/* ---------------------------
Laboratoire : Labo 07
Fichier : StackIterator.java
Auteur(s) : Alexis Monthoux - Victor Nondjock
Date : 23.11.21

But :   An iterator to navigate through the
        stack and access elements.

Remarque(s) : StackIterator implements Iterator<T>.

Compilateur : OpenJDK 11

--------------------------- */
package util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @param <T> Type of contained element.
 */
class StackIterator<T> implements Iterator<T> {
    private Node<T> current;

    /**
     * StackIterator constructor.
     * @param element Node linked to the iterator.
     */
    StackIterator(Node<T> element) {
        current = element;
    }

    /**
     * Go to the next Node.
     * @return The element linked to the next Node.
     */
    @Override
    public T next() {
        if (current == null) {
            throw new NoSuchElementException("trying to access null element.");
        }

        T element = current.getElement();
        current = current.getNext();
        return element;
    }

    /**
     * informs If there is a Node after.
     * @return True if there is a next one.
     */
    @Override
    public boolean hasNext() {
        return current != null;
    }
}
