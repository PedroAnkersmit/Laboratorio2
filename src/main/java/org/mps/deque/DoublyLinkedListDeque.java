package org.mps.deque;

import java.util.Comparator;

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

    public DoublyLinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        DequeNode<T> aux = new DequeNode<>(value, null, first);
        if (first != null) first.setPrevious(aux);
        else last = aux;
        first = aux;
        size++;
    }

    @Override
    public void append(T value) {
        DequeNode<T> aux = new DequeNode<>(value, last, null);
        if (last != null) last.setNext(aux);
        else first = aux;
        last = aux;
        size++;
    }

    @Override
    public void deleteFirst() {
        if (first != null) {
            first = first.getNext();
            if (first != null) first.setPrevious(null);
            size--;
        } else {
            throw new DoubleEndedQueueException("Delete on null pointer");
        }
    }

    @Override
    public void deleteLast() {
        if (last != null) {
            last = last.getPrevious();
            if (last != null) last.setNext(null);
            size--;
        } else {
            throw new DoubleEndedQueueException("Delete on null pointer");
        }
    }

    @Override
    public T first() {
        if (first != null) {
            return first.getItem();
        } else {
            throw new DoubleEndedQueueException("Get on null pointer");
        }
    }

    @Override
    public T last() {
        if (first != null) {
            return last.getItem();
        } else {
            throw new DoubleEndedQueueException("Get on null pointer");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int i) {
        DequeNode<T> x = first;
        for (int t = 0; t < i; t++) {
            if (t < size) {
                x = x.getNext();
            } else {
                throw new DoubleEndedQueueException("Get on invalid index");
            }
        }
        return x.getItem();
    }

    @Override
    public boolean contains(T value) {
        DequeNode<T> x = first;
        boolean found = false;
        int i = 0;
        while (!found && i < size) {
            if (x.getItem().equals(value)) {
                found = true;
            } else {
                x = x.getNext();
                i++;
            }
        }
        return found;
    }

    @Override
    public void remove(T value) {

        DequeNode<T> x = first;
        boolean found = false;
        int i = 0;
        while (!found && i < size) {
            if (x.getItem().equals(value)) {
                found = true;
            } else {
                x = x.getNext();
                i++;
            }
        }
        if (found) {
            if (first != x) {
                first.setPrevious(x);
                x.getPrevious().setNext(x.getNext());

                if (last != x) x.getNext().setPrevious(x.getPrevious());
                x.setNext(first);
                x.setPrevious(null);
                first = x;
            }
            deleteFirst();
        }


    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        for (int i = 0; i < this.size(); i++) {
            T actual;
            for (int j = 0; j < this.size() - i; j++) {
                actual = this.get(j); //Comprobamos si este es el menor de los que quedan por ordenar
                int k = 0;
                for (; k < this.size() - i; k++) {
                    if (k == j) continue;
                    if (comparator.compare(actual, this.get(k)) > 0)
                        break; //No es el menor
                }

                if (k == this.size() - i) { //Es el menor
                    this.remove(actual);
                    this.append(actual);
                    break;
                }
            }

        }
    }
}
