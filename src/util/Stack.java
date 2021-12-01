/* ---------------------------
Laboratoire : Labo 07
Fichier : Stack
Auteur(s) : Alexis Monthoux - Victor Nondjock
Date : 23.11.21

But :   Class Stack is a container class to

Remarque(s) : Stack implements Iterable<T>.

Compilateur : OpenJDK 11

--------------------------- */
package util;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * @param <T> Type of contained element.
 */
public class Stack<T> implements Iterable<T> {
    private Node<T> first;
    private int size;

    /**
     * Pushes a new Node at first place and shifts the others. The return allows pushing one Node after another.
     * @param element Contained element in the Node to be added.
     * @return The stack with containing the new Node.
     */
    public Stack<T> push(T element) {
        first = new Node<>(element, first);
        ++size;
        return this;
    }

    /**
     * Gets the first element out of the Stack.
     * @return Former first Node.
     */
    public T pop() {
        if (first == null) {
            throw new EmptyStackException();
        }

        T elem = first.getElement();
        first = first.getNext();
        --size;
        return elem;
    }

    /**
     * Redefinition of toString.
     * @return A String displaying each element of the stack.
     */
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

    /**
     * Puts the elements contained in the stack into an array of objects.
     * @return An Array of Type Object.
     */
    public Object[] toArray() {
        Object[] result = new Object[size];

        int i = 0;
        for (T el : this) {
            result[i++] = el;
        }

        return result;
    }

    /**
     * Puts the elements contained in the stack into an array of Type T.
     * @param a Array in which the elements are supposed to be put if big enough.
     * @return a with all the elements of the stack in it, or a new Array containing them.
     */
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

    /**
     * Gets size of the Array.
     * @return size.
     */
    public int size() {
        return size;
    }

    /**
     * Gets an Iterator pointing on the first element.
     * @return A new Iterator.
     */
    public Iterator<T> iterator() {
        return new StackIterator<>(first);
    }
}

