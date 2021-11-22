package util;

public class Node<T> {
    private final T element;
    private final Node<T> next;

    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    public Node<T> getNext() {
        return next;
    }

    public T getElement() {
        return element;
    }
}
