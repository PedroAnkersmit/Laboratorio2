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
        DequeNode<T> n = new DequeNode<>(value, null, first);
        first = n;
        size++;
    }

    @Override
    public void append(T value) {
        DequeNode<T> n = new DequeNode<>(value, last, null);
        last = n;
        size++;
    }

    @Override
    public void deleteFirst() {
        first = first.getNext();
        size--;
    }

    @Override
    public void deleteLast() {
        last = last.getPrevious();
        size--;
    }

    @Override
    public T first() {
        return first.getItem();
    }

    @Override
    public T last() {
        return last.getItem();
    }

    @Override
    public int size() {
        return size;
    }
}
