package org.mps.deque;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Pedro Ankersmit Carrión
 * @author Daniel García Rodríguez
 */
class DequeNodeTest {
    private DequeNode<Integer> node, node2, node3;

    @BeforeEach
    void setUp() {
        node = new DequeNode<>(10, null, null);
        node2 = new DequeNode<>(null, null, node3);
        node3 = new DequeNode<>(-7, node2, null);
    }

    @Nested
    @DisplayName("The method getItem()")
    class getItem {
        @Test
        @DisplayName("returns null when item is null.")
        void getItemNull() {
            assertNull(node2.getItem());
        }

        @Test
        @DisplayName("returns the non-null item when item is not null.")
        void getItemNotNull() {
            assertNotNull(node.getItem());
            assertEquals(10, node.getItem());
        }
    }

    @Nested
    @DisplayName("The method setItem()")
    class setItem {
        @Test
        @DisplayName("sets the item null when null is given.")
        void setItemNull() {
            node.setItem(null);
            assertNull(node.getItem());
        }

        @Test
        @DisplayName("sets the item to the given non-null value.")
        void setItemNotNull() {
            int expectedValue = 5;
            node.setItem(expectedValue);
            assertNotNull(node.getItem());
            assertEquals(expectedValue, node.getItem());
        }
    }

    @Nested
    @DisplayName("The method getPrevious()")
    class getPrevious {
        @Test
        @DisplayName("returns null when the previous node is null.")
        void getPreviousNull() {
            assertNull(node.getPrevious());
        }

        @Test
        @DisplayName("returns the non-null node when it is not null.")
        void getPreviousNotNull() {
            assertNotNull(node3.getPrevious());
            assertEquals(10, node.getItem());
        }
    }

    @Nested
    @DisplayName("The method setPrevious()")
    class setPrevious {
        @Test
        @DisplayName("sets the previous node null when null is given.")
        void setPreviousNull() {
            node3.setPrevious(null);
            assertNull(node3.getPrevious());
        }

        @Test
        @DisplayName("sets the previous node to the given non-null node.")
        void setPreviousNotNull() {
            node.setPrevious(node3);
            assertNotNull(node.getPrevious());
            assertEquals(node3, node.getPrevious());
        }
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