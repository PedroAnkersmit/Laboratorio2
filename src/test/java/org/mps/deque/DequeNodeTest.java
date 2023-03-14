package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h2>Tests para la clase {@link DequeNode}</h2>
 * <ol>
 *     <li>Método {@code getItem()}:
 *         <ol>
 *              <li>Devuelve {@code null} si el item es nulo.</li>
 *              <li>Devuelve el item no-nulo si el item no es nulo.</li>
 *         </ol>
 *     </li>
 *     <li>Método {@code setItem()}:
 *        <ol>
 *              <li>Anula el item si el parámetro es {@code null}.</li>
 *              <li>Establece el item al parámetro no-nulo si no es nulo.</li>
 *         </ol>
 *     </li>
 *     <li>Método {@code getPrevious()}:
 *         <ol>
 *              <li>Devuelve {@code null} si no tiene nodo previo.</li>
 *              <li>Devuelve el nodo no-nulo previo si lo tiene.</li>
 *         </ol>
 *     </li>
 *     <li>Método {@code setPrevious()}:
 *        <ol>
 *              <li>Elimina la referencia al nodo previo si el parámetro es {@code null}.</li>
 *              <li>Establece el nodo previo al parámetro no-nulo en caso de no ser nulo.</li>
 *         </ol>
 *     </li>
 *     <li>Método {@code getNext()}:
 *         <ol>
 *              <li>Devuelve {@code null} si no tiene nodo siguiente.</li>
 *              <li>Devuelve el nodo no-nulo siguiente si lo tiene.</li>
 *         </ol>
 *     </li>
 *     <li>Método {@code setNext()}:
 *        <ol>
 *              <li>Elimina la referencia al nodo siguiente si el parámetro es {@code null}.</li>
 *              <li>Establece el nodo siguiente al parámetro no-nulo en caso de no ser nulo.</li>
 *         </ol>
 *     </li>
 *     <li>Método {@code isFirstNode()}:
 *        <ol>
 *              <li>Devuelve {@code true} si no tiene nodo previo (es el primero).</li>
 *              <li>Devuelve {@code false} si tiene nodo previo (no es el primero).</li>
 *         </ol>
 *     </li>
 *     <li>Método {@code isLastNode()}:
 *        <ol>
 *              <li>Devuelve {@code true} si no tiene nodo siguiente (es el último).</li>
 *              <li>Devuelve {@code false} si tiene nodo siguiente (no es el último).</li>
 *         </ol>
 *     </li>
 *     <li>Método {@code isNotATerminalNode()}:
 *        <ol>
 *              <li>Devuelve {@code true} si no es el primero ni el último.</li>
 *              <li>Devuelve {@code false} si es el primero pero no el último.</li>
 *              <li>Devuelve {@code false} si es el último pero no el primero.</li>
 *              <li>Devuelve {@code false} si es el primero y también el último.</li>
 *         </ol>
 *     </li>
 * </ol>
 * @author Pedro Ankersmit Carrion
 * @author Daniel Garcia Rodriguez
 */
class DequeNodeTest {
    private DequeNode<Integer> node, node2, node3, node4;

    @BeforeEach
    void setUp() {
        node = new DequeNode<>(10, null, null);
        node2 = new DequeNode<>(null, null, node3);
        node3 = new DequeNode<>(-7, node2, null);
        node4 = new DequeNode<>(1, node3, node2);
        node2.setNext(node3);
    }

    @AfterEach
    void destroy() {
        node = null;
        node2 = null;
        node3 = null;
        node4 = null;
    }

    @Nested
    @DisplayName("Given the method getItem()")
    class getItem {
        @Test
        @DisplayName("when item is null, then returns null.")
        void getItemNull() {
            assertNull(node2.getItem());
        }

        @Test
        @DisplayName("when item is not null, then returns the non-null item.")
        void getItemNotNull() {
            assertNotNull(node.getItem());
            assertEquals(10, node.getItem());
        }
    }

    @Nested
    @DisplayName("Given the method setItem()")
    class setItem {
        @Test
        @DisplayName("when null is given, then sets the item null .")
        void setItemNull() {
            node.setItem(null);
            assertNull(node.getItem());
        }

        @Test
        @DisplayName("when a non-null value is given, then sets the item to that value.")
        void setItemNotNull() {
            int expectedValue = 5;
            node.setItem(expectedValue);
            assertNotNull(node.getItem());
            assertEquals(expectedValue, node.getItem());
        }
    }

    @Nested
    @DisplayName("Given the method getPrevious()")
    class getPrevious {
        @Test
        @DisplayName("when the previous node is null, then returns null.")
        void getPreviousNull() {
            assertNull(node.getPrevious());
        }

        @Test
        @DisplayName("when the previous node is not null, then returns it.")
        void getPreviousNotNull() {
            assertNotNull(node3.getPrevious());
            assertEquals(node2, node3.getPrevious());
        }
    }

    @Nested
    @DisplayName("Given the method setPrevious()")
    class setPrevious {
        @Test
        @DisplayName("when null is given, then sets the previous node to null.")
        void setPreviousNull() {
            node3.setPrevious(null);
            assertNull(node3.getPrevious());
        }

        @Test
        @DisplayName("when a non-null node is given, then sets the previous node to the given node.")
        void setPreviousNotNull() {
            node.setPrevious(node3);
            assertNotNull(node.getPrevious());
            assertEquals(node3, node.getPrevious());
        }
    }

    @Nested
    @DisplayName("Given the method getNext()")
    class getNext {
        @Test
        @DisplayName("when the next node is null, then returns null.")
        void getNextNull() {
            assertNull(node.getNext());
        }

        @Test
        @DisplayName("returns the non-null next node when it is not null.")
        void getNextNotNull() {
            assertNotNull(node2.getNext());
            assertEquals(node3, node2.getNext());
        }
    }

    @Nested
    @DisplayName("Given the method setNext()")
    class setNext {
        @DisplayName("when null is given, then sets the next node null.")
        @Test
        void setNextNull() {
            node2.setNext(null);
            assertNull(node2.getNext());
        }

        @DisplayName("when a non-null node is given, then sets the next node to the given node.")
        @Test
        void setNextNotNull() {
            node.setNext(node3);
            assertNotNull(node.getNext());
            assertEquals(node3, node.getNext());
        }
    }

    @Nested
    @DisplayName("Given the method isFirstNode()")
    class isFirstNode {
        @Test
        @DisplayName("when it has no previous node, then returns true.")
        void previousNull() {
            assertNull(node.getPrevious());
            assertTrue(node.isFirstNode());
        }

        @Test
        @DisplayName("when it has a previous node, then returns false.")
        void previousNotNull() {
            assertNotNull(node3.getPrevious());
            assertFalse(node3.isFirstNode());
        }
    }

    @Nested
    @DisplayName("Given the method isLastNode()")
    class isLastNode {
        @Test
        @DisplayName("when it has no next node, then returns true.")
        void nextNull() {
            assertNull(node.getNext());
            assertTrue(node.isLastNode());
        }

        @Test
        @DisplayName("when it has a next node, then returns false.")
        void nextNotNull() {
            DequeNode<Integer> tmp = node2;
            assertNotNull(tmp.getNext());
            assertFalse(tmp.isLastNode());
        }
    }

    @Nested
    @DisplayName("Given the method isNotATerminalNode()")
    class isNotATerminalNode {
        @Test
        @DisplayName("when it is not first nor last, then returns true.")
        void notFirstNorLast() {
            assertAll(
                    () -> assertFalse(node4.isFirstNode()),
                    () -> assertFalse(node4.isLastNode()),
                    () -> assertTrue(node4.isNotATerminalNode())
            );
        }

        @Test
        @DisplayName("when it is first and not last, then returns false.")
        void firstNotLast() {
            assertAll(
                    () -> assertTrue(node2.isFirstNode()),
                    () -> assertFalse(node2.isLastNode()),
                    () -> assertFalse(node2.isNotATerminalNode())
            );
        }

        @Test
        @DisplayName("when it is last and not first, then returns false.")
        void lastNotFirst() {
            assertAll(
                    () -> assertFalse(node3.isFirstNode()),
                    () -> assertTrue(node3.isLastNode()),
                    () -> assertFalse(node3.isNotATerminalNode())
            );
        }

        @Test
        @DisplayName("when it is both first and last, then returns false.")
        void firstAndLast() {
            assertAll(
                    () -> assertTrue(node.isFirstNode()),
                    () -> assertTrue(node.isLastNode()),
                    () -> assertFalse(node.isNotATerminalNode())
            );
        }
    }
}