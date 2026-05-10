package ed.rdr2;

import ed.rdr2.tad.stack.LinkedStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios del TAD Pila (LIFO + undo).
 *
 * @author Daniel Palacios Alonso
 */
class LinkedStackTest {

    private LinkedStack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new LinkedStack<>();
    }

    @Test
    void testEmptyStackInitially() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void testPushAndSize() {
        stack.push("Aceptar misión");
        stack.push("Moverse a Colter");
        assertEquals(2, stack.size());
        assertFalse(stack.isEmpty());
    }

    @Test
    void testLifoOrder() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("C", stack.pop());
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }

    @Test
    void testPeekDoesNotRemove() {
        stack.push("A");
        stack.push("B");
        assertEquals("B", stack.peek());
        assertEquals(2, stack.size());
    }

    @Test
    void testUndoRemovesTop() {
        stack.push("Aceptar misión");
        stack.push("Abrir inventario");
        String undone = stack.undo();
        assertEquals("Abrir inventario", undone);
        assertEquals(1, stack.size());
        assertEquals("Aceptar misión", stack.peek());
    }

    @Test
    void testUndoEquivalentToPop() {
        stack.push("X");
        stack.push("Y");
        String popped = stack.pop();
        LinkedStack<String> stack2 = new LinkedStack<>();
        stack2.push("X");
        stack2.push("Y");
        String undone = stack2.undo();
        assertEquals(popped, undone);
    }

    @Test
    void testPopOnEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> stack.pop());
    }

    @Test
    void testPeekOnEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> stack.peek());
    }

    @Test
    void testUndoOnEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> stack.undo());
    }

    @Test
    void testSizeAfterMultipleUndos() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.undo();
        stack.undo();
        assertEquals(1, stack.size());
        assertEquals("A", stack.peek());
    }
}
