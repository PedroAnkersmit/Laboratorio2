package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque(DequeNode<T> f, DequeNode<T> l) {
        first = f;
        last = l;
        size = 2;
    }

    @Override
    public void prepend(T value) {
        first = new DequeNode<>(value, null, first);
        size++;
    }

    @Override
    public void append(T value) {
        last = new DequeNode<>(value, last, null);
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
