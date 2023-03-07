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
    private DequeNode<Integer> node;

    @BeforeEach
    void setUp() {
        node = new DequeNode<>(10, null, null);
    }

    @Nested
    @DisplayName("The method getItem()")
    class getItem {
        @Test
        @DisplayName("returns null when item is null")
        void getItemNull() {
            node = new DequeNode<>(null, null, null);
            assertNull(node.getItem());
        }

        @Test
        @DisplayName("returns the non-null item when item is not null")
        void getItemNotNull() {
            assertNotNull(node.getItem());
            assertEquals(10, node.getItem());
        }
    }

    @Nested
    @DisplayName("El método setItem()")
    class setItem {
        @Test
        @DisplayName("sets the item null when null is given")
        void setItemNull() {
            node.setItem(null);
            assertNull(node.getItem());
        }

        @Test
        @DisplayName("sets the item to the given non-null value")
        void setItemNotNull() {
            int expectedValue = 5;
            node.setItem(expectedValue);
            assertNotNull(node.getItem());
            assertEquals(expectedValue, node.getItem());
        }
    }

    @Nested
    @DisplayName("El método setItem()")
    class getPrevious {
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