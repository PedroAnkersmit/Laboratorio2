package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque(DequeNode<T> f, DequeNode<T> l) {
        // TODO
        first = f;
        last = l;
        size = 2;
    }

    @Override
    public void prepend(T value) {
        DequeNode<T> nuevo = new DequeNode<>(value, null, first);
        first = nuevo;
        size++;
    }

    @Override
    public void append(T value) {
        DequeNode<T> nuevo = new DequeNode<>(value, last, null);
        last = nuevo;
        size++;
    }

    @Override
    public void deleteFirst() {
        DequeNode<T> aux = first;
    }

    @Override
    public void deleteLast() {
        // TODO
    }

    @Override
    public T first() {
        // TODO
        return null;
    }

    @Override
    public T last() {
        // TODO
        return null;
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }
}
