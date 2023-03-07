package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque(DequeNode<T> f, DequeNode<T> l) {
        first = f;
        last = l;
        first.setNext(l);
        l.setPrevious(f);
        size = 2;
    }
    public DoublyLinkedListDeque(){
        first = null;
        last = null;
        size = 0;
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
        if(first != null) {
            first = first.getNext();
            size--;
        } else{
            throw new DoubleEndedQueueException("Delete on null pointer");
        }
    }

    @Override
    public void deleteLast() {
        if(last != null){
        last = last.getPrevious();
        size--;
        } else{
            throw new DoubleEndedQueueException("Delete on null pointer");
        }
    }

    @Override
    public T first() {
        if(first != null) {
            return first.getItem();
        } else{
            throw new DoubleEndedQueueException("Get on null pointer");
        }
    }

    @Override
    public T last() {
        if(first != null) {
            return last.getItem();
        } else{
            throw new DoubleEndedQueueException("Get on null pointer");
        }
    }

    @Override
    public int size() {
        return size;
    }
}
