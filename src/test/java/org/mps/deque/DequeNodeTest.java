package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeNodeTest {
    private DequeNode<Integer> node;

    @BeforeEach
    void setUp() {
        node = new DequeNode<>(10, null, null);
    }

    @Nested
    @DisplayName("El metodo getItem()")
    class getItem {
        @Test
        @DisplayName("returns null when item is null")
        void getItemNull() {
            node = new DequeNode<>(null, null, null);
            assertNull(node.getItem());
        }

        @Test
        @DisplayName("returns the non-null item when item is not null")
        void getItemNotNull(){
            assertNotNull(node.getItem());
            assertEquals(10,node.getItem());
        }
    }

    @Test
    void setItem() {

    }

    @Test
    void getPrevious() {
    }

    @Test
    void setPrevious() {
    }

    @Test
    void getNext() {
    }

    @Test
    void setNext() {
    }

    @Test
    void isFirstNode() {
    }

    @Test
    void isLastNode() {
    }

    @Test
    void isNotATerminalNode() {
    }
}