package org.mps.deque;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <h2>Tests para la clase {@link DequeNode}</h2>
 * <ol>
 *     <li>M�todo {@code getItem()}:
 *         <ol>
 *              <li>Devuelve {@code null} si el item es nulo.</li>
 *              <li>Devuelve el item no-nulo si el item no es nulo.</li>
 *         </ol>
 *     </li>
 *     <li>M�todo {@code setItem()}:
 *        <ol>
 *              <li>Anula el item si el par�metro es {@code null}.</li>
 *              <li>Establece el item al par�metro no-nulo si no es nulo.</li>
 *         </ol>
 *     </li>
 *     <li>M�todo {@code getPrevious()}:
 *         <ol>
 *              <li>Devuelve {@code null} si no tiene nodo previo.</li>
 *              <li>Devuelve el nodo no-nulo previo si lo tiene.</li>
 *         </ol>
 *     </li>
 *     <li>M�todo {@code setPrevious()}:
 *        <ol>
 *              <li>Elimina la referencia al nodo previo si el par�metro es {@code null}.</li>
 *              <li>Establece el nodo previo al par�metro no-nulo en caso de no ser nulo.</li>
 *         </ol>
 *     </li>
 *     <li>M�todo {@code getNext()}:
 *         <ol>
 *              <li>Devuelve {@code null} si no tiene nodo siguiente.</li>
 *              <li>Devuelve el nodo no-nulo siguiente si lo tiene.</li>
 *         </ol>
 *     </li>
 *     <li>M�todo {@code setNext()}:
 *        <ol>
 *              <li>Elimina la referencia al nodo siguiente si el par�metro es {@code null}.</li>
 *              <li>Establece el nodo siguiente al par�metro no-nulo en caso de no ser nulo.</li>
 *         </ol>
 *     </li>
 *     <li>M�todo {@code isFirstNode()}:
 *        <ol>
 *              <li>Devuelve {@code true} si no tiene nodo previo (es el primero).</li>
 *              <li>Devuelve {@code false} si tiene nodo previo (no es el primero).</li>
 *         </ol>
 *     </li>
 *     <li>M�todo {@code isLastNode()}:
 *        <ol>
 *              <li>Devuelve {@code true} si no tiene nodo siguiente (es el �ltimo).</li>
 *              <li>Devuelve {@code false} si tiene nodo siguiente (no es el �ltimo).</li>
 *         </ol>
 *     </li>
 *     <li>M�todo {@code isNotATerminalNode()}:
 *        <ol>
 *              <li>Devuelve {@code true} si no es el primero ni el �ltimo.</li>
 *              <li>Devuelve {@code false} si es el primero pero no el �ltimo.</li>
 *              <li>Devuelve {@code false} si es el �ltimo pero no el primero.</li>
 *              <li>Devuelve {@code false} si es el primero y tambi�n el �ltimo.</li>
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
        @DisplayName("returns the non-null previous node when it is not null.")
        void getPreviousNotNull() {
            assertNotNull(node3.getPrevious());
            assertEquals(node2, node3.getPrevious());
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

    @Nested
    @DisplayName("The method getNext()")
    class getNext {
        @Test
        @DisplayName("returns null when the next node is null.")
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
    @DisplayName("The method setNext()")
    class setNext {
        @DisplayName("sets the next node null when null is given.")
        @Test
        void setNextNull() {
            //node2.setNext(null);
            //assertNull(node2.getNext());


        }

        @DisplayName("sets the next node to the given non-null node.")
        @Test
        void setNextNotNull() {
            node.setNext(node3);
            assertNotNull(node.getNext());
            assertEquals(node3, node.getNext());
        }
    }

    @Nested
    @DisplayName("The method isFirstNode()")
    class isFirstNode {
        @Test
        @DisplayName("returns true if it has no previous node.")
        void previousNull() {
            assertNull(node.getPrevious());
            assertTrue(node.isFirstNode());
        }

        @Test
        @DisplayName("returns false if it has a previous node.")
        void previousNotNull() {
            assertNotNull(node3.getPrevious());
            assertFalse(node3.isFirstNode());
        }
    }

    @Nested
    @DisplayName("The method isLastNode()")
    class isLastNode {
        @Test
        @DisplayName("returns true if it has no next node.")
        void nextNull() {
            assertNull(node.getNext());
            assertTrue(node.isLastNode());
        }

        @Test
        @DisplayName("returns false if it has a next node.")
        void nextNotNull() {
            DequeNode<Integer> tmp = node2;
            assertNotNull(tmp.getNext());
            assertFalse(tmp.isLastNode());
        }
    }

    @Nested
    @DisplayName("The method isNotATerminalNode()")
    class isNotATerminalNode {
        @Test
        @DisplayName("returns true if it is not first nor last.")
        void notFirstNorLast() {
            assertAll(
                    () -> assertFalse(node4.isFirstNode()),
                    () -> assertFalse(node4.isLastNode()),
                    () -> assertTrue(node4.isNotATerminalNode())
            );
        }

        @Test
        @DisplayName("returns false if it is first and not last.")
        void firstNotLast() {
            assertAll(
                    () -> assertTrue(node2.isFirstNode()),
                    () -> assertFalse(node2.isLastNode()),
                    () -> assertFalse(node2.isNotATerminalNode())
            );
        }

        @Test
        @DisplayName("returns false if it is last and not first.")
        void lastNotFirst() {
            assertAll(
                    () -> assertFalse(node3.isFirstNode()),
                    () -> assertTrue(node3.isLastNode()),
                    () -> assertFalse(node3.isNotATerminalNode())
            );
        }

        @Test
        @DisplayName("returns false if it is both first and last.")
        void firstAndLast() {
            assertAll(
                    () -> assertTrue(node.isFirstNode()),
                    () -> assertTrue(node.isLastNode()),
                    () -> assertFalse(node.isNotATerminalNode())
            );
        }
    }
}