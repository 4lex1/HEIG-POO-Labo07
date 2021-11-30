/* ---------------------------
Laboratoire : Labo 07
Fichier : Node.java
Auteur(s) : Alexis Monthoux - Victor Nondjock
Date : 23.11.21

But :   Class Node, link constituting the stack
        and containing a reference to the stored element

Remarque(s) : /

Compilateur : OpenJDK 11

--------------------------- */
package util;

/**
 *
 * @param <T> class of contained element
 */
public class Node<T> {
    private final T element;
    private final Node<T> next;

    /**
     * Node constructor
     * @param element contained element
     * @param next next node in the stack
     */
    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    /**
     *
     * @return the next Node
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     *
     * @return contained element
     */
    public T getElement() {
        return element;
    }
}
