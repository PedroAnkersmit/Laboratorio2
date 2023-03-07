package org.mps.deque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pedro Ankersmit Carri�n
 * @author Daniel Garc�a Rodr�guez
 */

class DoublyLinkedListDequeTest {
    private DoublyLinkedListDeque<Integer> qeue;
    @BeforeEach
    void construct(){
        DequeNode<Integer> f = new DequeNode<Integer>(11, null, null);
        DequeNode<Integer> l = new DequeNode<>(10, null, null);
        qeue = new DoublyLinkedListDeque<Integer>(f,l);
    }
    @Nested
    @DisplayName("The constructed doubly linked list deque")
    class constructor{
        @Test
        @DisplayName("Has the proper size")
        void size() {
            assertEquals(qeue.size(), 2);
        }
        @Test
        @DisplayName("Is not null")
        void isNotNull(){
            assertNotNull(qeue.first());
            assertNotNull(qeue.last());
        }
    }
    @Nested
    @DisplayName("The method prepend")
    class prepend{
        @Test
        @DisplayName("Makes the new node the first in the qeue")
        void newNodeIsFirst(){
            qeue.prepend(2);
            assertEquals(qeue.first(), 2);
        }
        @Test
        @DisplayName("Increments the size of the qeue")
        void qeueSize(){
            qeue.prepend(2);
            assertEquals(qeue.size(), 3);
        }
    }
    @Nested
    @DisplayName("The method append")
    class append{
        @Test
        @DisplayName("Makes the new node the last in the qeue")
        void newNodeIsFirst(){
            qeue.append(2);
            assertEquals(qeue.last(), 2);
        }
        @Test
        @DisplayName("Increments the size of the qeue")
        void qeueSize(){
            qeue.append(2);
            assertEquals(qeue.size(), 3);
        }
    }
    @Nested
    @DisplayName("The method delete first")
    class deleteFirst{
        @Test
        @DisplayName("Deletes the first value")
        void deletedFirst(){
            qeue.deleteFirst();
            assertEquals(qeue.first(), qeue.last());
        }
        @Test
        @DisplayName("Decrements the size of the qeue")
        void qeueSize(){
            qeue.deleteFirst();
            assertEquals(qeue.size(), 1);
        }
        @Test
        @DisplayName("Throws DoubleEndedQueueException if first is null")
        void firstNull(){
            qeue = new DoublyLinkedListDeque<Integer>();
            assertThrows(DoubleEndedQueueException.class,() -> qeue.deleteFirst());
        }
    }

    @Nested
    @DisplayName("The method delete last")
    class deleteLast{
        @Test
        @DisplayName("Deletes the last value")
        void deletedFirst(){
            qeue.deleteLast();
            assertEquals(qeue.first(), qeue.last());
        }
        @Test
        @DisplayName("Decrements the size of the qeue")
        void qeueSize(){
            qeue.deleteLast();
            assertEquals(qeue.size(), 1);
        }
        @Test
        @DisplayName("Throws DoubleEndedQueueException if last is null")
        void lastNull(){
            qeue = new DoublyLinkedListDeque<Integer>();
            assertThrows(DoubleEndedQueueException.class,() -> qeue.deleteLast());
        }
    }
    @Nested
    @DisplayName("The method first")
    class first{
        @Test
        @DisplayName("Returns the correct value")
        void returnValue(){
            assertEquals(qeue.first(), 11);
        }
        @Test
        @DisplayName("Throws DoubleEndedQueueException if first is null")
        void firstNull(){
            qeue = new DoublyLinkedListDeque<Integer>();
            assertThrows(DoubleEndedQueueException.class,() -> qeue.first());
        }
    }
    @Nested
    @DisplayName("The method last")
    class last{
        @Test
        @DisplayName("Returns the correct value")
        void returnValue(){
            assertEquals(qeue.last(), 10);
        }
        @Test
        @DisplayName("Throws DoubleEndedQueueException if last is null")
        void lastNull(){
            qeue = new DoublyLinkedListDeque<Integer>();
            assertThrows(DoubleEndedQueueException.class,() -> qeue.last());
        }
    }
    @Nested
    @DisplayName("The method size")
    class size{
        @Test
        @DisplayName("Returns the expected value")
        void expectedSize(){
            assertEquals(qeue.size(), 2);
            qeue = new DoublyLinkedListDeque<Integer>();
            assertEquals(qeue.size(), 0);
        }
    }
}
