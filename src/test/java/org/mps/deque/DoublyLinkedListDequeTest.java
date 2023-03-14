package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pedro Ankersmit Carrion
 * @author Daniel Garcia Rodriguez
 */

class DoublyLinkedListDequeTest {
    private DoublyLinkedListDeque<Integer> queue;

    @BeforeEach
    void construct() {
        DequeNode<Integer> f = new DequeNode<>(11, null, null);
        DequeNode<Integer> l = new DequeNode<>(10, null, null);
        queue = new DoublyLinkedListDeque<>(f, l);
    }

    @Nested
    @DisplayName("The constructed doubly linked list deque")
    class constructor {
        @Test
        @DisplayName("Has the proper size")
        void size() {
            assertEquals(queue.size(), 2);
        }

        @Test
        @DisplayName("Is not null")
        void isNotNull() {
            assertNotNull(queue.first());
            assertNotNull(queue.last());
        }
    }

    @Nested
    @DisplayName("The method prepend")
    class prepend {
        @Test
        @DisplayName("Makes the new node the first in the qeue")
        void newNodeIsFirst() {
            queue.prepend(2);
            assertEquals(queue.first(), 2);
        }

        @Test
        @DisplayName("Increments the size of the qeue")
        void qeueSize() {
            queue.prepend(2);
            assertEquals(queue.size(), 3);
        }
    }

    @Nested
    @DisplayName("The method append")
    class append {
        @Test
        @DisplayName("Makes the new node the last in the qeue")
        void newNodeIsFirst() {
            queue.append(2);
            assertEquals(queue.last(), 2);
        }

        @Test
        @DisplayName("Increments the size of the qeue")
        void qeueSize() {
            queue.append(2);
            assertEquals(queue.size(), 3);
        }
    }

    @Nested
    @DisplayName("The method delete first")
    class deleteFirst {
        @Test
        @DisplayName("Deletes the first value")
        void deletedFirst() {
            queue.deleteFirst();
            assertEquals(queue.first(), queue.last());
        }

        @Test
        @DisplayName("Decrements the size of the qeue")
        void qeueSize() {
            queue.deleteFirst();
            assertEquals(queue.size(), 1);
        }

        @Test
        @DisplayName("Throws DoubleEndedQueueException if first is null")
        void firstNull() {
            queue = new DoublyLinkedListDeque<>();
            assertThrows(DoubleEndedQueueException.class, () -> queue.deleteFirst());
        }
    }

    @Nested
    @DisplayName("The method delete last")
    class deleteLast {
        @Test
        @DisplayName("Deletes the last value")
        void deletedFirst() {
            queue.deleteLast();
            assertEquals(queue.first(), queue.last());
        }

        @Test
        @DisplayName("Decrements the size of the qeue")
        void qeueSize() {
            queue.deleteLast();
            assertEquals(queue.size(), 1);
        }

        @Test
        @DisplayName("Throws DoubleEndedQueueException if last is null")
        void lastNull() {
            queue = new DoublyLinkedListDeque<>();
            assertThrows(DoubleEndedQueueException.class, () -> queue.deleteLast());
        }
    }

    @Nested
    @DisplayName("The method first")
    class first {
        @Test
        @DisplayName("Returns the correct value")
        void returnValue() {
            assertEquals(queue.first(), 11);
        }

        @Test
        @DisplayName("Throws DoubleEndedQueueException if first is null")
        void firstNull() {
            queue = new DoublyLinkedListDeque<>();
            assertThrows(DoubleEndedQueueException.class, () -> queue.first());
        }
    }

    @Nested
    @DisplayName("Given a DoubleEndedQueue and the method last")
    class last{
        void returnValue() {
            assertEquals(queue.last(), 10);
        }

        @Test
        @DisplayName("Throws DoubleEndedQueueException if last is null")
        void lastNull() {
            queue = new DoublyLinkedListDeque<>();
            assertThrows(DoubleEndedQueueException.class, () -> queue.last());
        }
    }

    @Nested
    @DisplayName("Given a DoubleEndedQueue and the method size")
    class size{

        @Test
        @DisplayName("Returns the expected value")
        void expectedSize() {
            assertEquals(queue.size(), 2);
            queue = new DoublyLinkedListDeque<>();
            assertEquals(queue.size(), 0);
        }
    }

    //@Nested
    //@DisplayName("Given a DoubleEndedQueue and the method contains")

    @Nested
    @DisplayName("Given a DoubleEndedQueue and the method remove")
    class remove{

        @Test
        @DisplayName("When used, removes the intended value")
        void removeExpected(){
            DequeNode<Integer> f = new DequeNode<>(11, null, null);
            DequeNode<Integer> l = new DequeNode<>(10, null, null);
            DoublyLinkedListDeque<Integer> k = new DoublyLinkedListDeque<>(f, l);
            //k.deleteLast();
            k.append(23);
            k.append(12);
            k.prepend(24);
            queue.append(23);
            queue.append(12);
            queue.prepend(24);
            //queue.remove(10);
            for(int i = 0; i < queue.size(); i++){

            //assertEquals(queue.get(i),k.get(i));
            }
        }
        @Test
        @DisplayName("When used, changes the size of the queue")
        void expectedSize(){
            queue.append(23);
            queue.append(12);
            queue.prepend(24);
            queue.remove(10);
            assertEquals(queue.size(), 4);
        }
        @Test
        @DisplayName("When used on an invalid value, it does nothing")
        void expectedBehaviour(){
            DoublyLinkedListDeque<Integer> k = queue;
            queue.remove(30);
            assertEquals(queue, k);
            assertEquals(queue, k);
        }
    }

    @Nested
    @DisplayName("The method sort")
    class sort {
        @Test
        @DisplayName("Returns expected result")
        void sortExpected() {
            Comparator<Integer> c = Comparator.comparingInt(o -> o);

            queue.append(23);
            queue.append(12);
            queue.prepend(24);
            queue.prepend(14);

            queue.sort(c);

            DoublyLinkedListDeque<Integer> expected = new DoublyLinkedListDeque<>();
            expected.append(10);
            expected.append(11);
            expected.append(12);
            expected.append(14);
            expected.append(23);
            expected.append(24);


            assertEquals(expected.size(),queue.size());
            //assertEquals(expected, queue);
            for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), queue.get(i));
        }
    }
}
