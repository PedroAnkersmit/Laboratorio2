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
        @DisplayName("has the proper size.")
        void size() {
            assertEquals(queue.size(), 2);
        }

        @Test
        @DisplayName("is not null.")
        void isNotNull() {
            assertNotNull(queue.first());
            assertNotNull(queue.last());
        }
    }

    @Nested
    @DisplayName("Given the method prepend")
    class prepend {
        @Test
        @DisplayName("when called, then makes the new node the first in the qeue.")
        void newNodeIsFirst() {
            queue.prepend(2);
            assertEquals(queue.first(), 2);
        }

        @Test
        @DisplayName("when called, then increments the size of the qeue.")
        void qeueSize() {
            queue.prepend(2);
            assertEquals(queue.size(), 3);
        }
    }

    @Nested
    @DisplayName("Given the method append")
    class append {
        @Test
        @DisplayName("when called, then makes the new node the last in the qeue.")
        void newNodeIsFirst() {
            queue.append(2);
            assertEquals(queue.last(), 2);
        }

        @Test
        @DisplayName("when called, then increments the size of the qeue.")
        void qeueSize() {
            queue.append(2);
            assertEquals(queue.size(), 3);
        }
    }

    @Nested
    @DisplayName("Given the method delete first")
    class deleteFirst {
        @Test
        @DisplayName("when first is not null, then deletes the first value.")
        void deletedFirst() {
            queue.deleteFirst();
            assertEquals(queue.first(), queue.last());
        }

        @Test
        @DisplayName("when first is not null, then decrements the size of the qeue.")
        void qeueSize() {
            queue.deleteFirst();
            assertEquals(queue.size(), 1);
        }

        @Test
        @DisplayName("when first is null, then throws DoubleEndedQueueException.")
        void firstNull() {
            queue = new DoublyLinkedListDeque<>();
            assertThrows(DoubleEndedQueueException.class, () -> queue.deleteFirst());
        }
    }

    @Nested
    @DisplayName("Given the method delete last")
    class deleteLast {
        @Test
        @DisplayName("when last is not null, then deletes the last value")
        void deletedFirst() {
            queue.deleteLast();
            assertEquals(queue.first(), queue.last());
        }

        @Test
        @DisplayName("when last is not null, then decrements the size of the qeue.")
        void qeueSize() {
            queue.deleteLast();
            assertEquals(queue.size(), 1);
        }

        @Test
        @DisplayName("when last is null, then throws DoubleEndedQueueException.")
        void lastNull() {
            queue = new DoublyLinkedListDeque<>();
            assertThrows(DoubleEndedQueueException.class, () -> queue.deleteLast());
        }
    }

    @Nested
    @DisplayName("Given the method first")
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
        @Test
        @DisplayName("Returns the correct value")
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

    @Nested
    @DisplayName("Given a DoubleEndedQueue and the method get")
    class get{
        @Test
        @DisplayName("When used on a valid index, returns the expected value")
        void returnsExpected(){
            int i = queue.get(0);
            assertEquals(i, 11);
        }
        @Test
        @DisplayName("When used on an invalid index, throws a DoubleEndedQueueException")
        void throwsException(){
            assertThrows(DoubleEndedQueueException.class, () -> queue.get(3));
        }
    }
    @Nested
    @DisplayName("Given a DoubleEndedQueue and the method contains")
    class contains{
        @Test
        @DisplayName("When used with a value that's contained in the queue, returns True")
        void returnsTrue(){
            assertTrue(queue.contains(10));
        }
        @Test
        @DisplayName("When used with a value that's not contained in the queue, returns False")
        void returnsFalse(){
            assertFalse(queue.contains(30));
        }
    }
    @Nested
    @DisplayName("Given a DoubleEndedQueue and the method remove")
    class remove{

        @Test
        @DisplayName("When used, removes the intended value")
        void removeExpected(){
            DequeNode<Integer> f = new DequeNode<>(11, null, null);
            DequeNode<Integer> l = new DequeNode<>(10, null, null);
            DoublyLinkedListDeque<Integer> k = new DoublyLinkedListDeque<>(f, l);
            k.deleteLast();
            k.append(23);
            k.append(12);
            k.prepend(24);
            queue.append(23);
            queue.append(12);
            queue.prepend(24);
            queue.remove(10);
            for(int i = 0; i < queue.size(); i++){

            assertEquals(queue.get(i),k.get(i));
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
        }
    }

    @Nested
    @DisplayName("Given the method sort")
    class sort {
        @Test
        @DisplayName("Returns expected result")
        void sortExpected() {
            Comparator<Integer> c = Comparator.comparingInt(o -> o);
            // 14 24 11 10 23 12
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
            for (int i = 0; i < expected.size(); i++) assertEquals(expected.get(i), queue.get(i));
        }
    }
}
