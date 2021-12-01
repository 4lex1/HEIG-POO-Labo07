/* ---------------------------
Laboratoire : Labo 07
Fichier : Node.java
Auteur(s) : Alexis Monthoux - Victor Nondjock
Date : 23.11.21

But :   Class Node, link constituting the stack
        and containing a reference to the stored element.

Remarque(s) : /

Compilateur : OpenJDK 11

--------------------------- */

package util;

/**
 * @param <T> Type of contained element.
 */
class Node<T> {
    private final T element;
    private final Node<T> next;

    /**
     * Node constructor.
     * @param element Contained element.
     * @param next following Node in the stack.
     */
    Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    /**
     * Gets the following Node.
     * @return next.
     */
    Node<T> getNext() {
        return next;
    }

    /**
     * Gets the contained element.
     * @return element
     */
    T getElement() {
        return element;
    }
}
