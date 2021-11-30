package util;

class Node<T> {
    private final T element;
    private final Node<T> next;

    Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }

    Node<T> getNext() {
        return next;
    }

    T getElement() {
        return element;
    }
}
