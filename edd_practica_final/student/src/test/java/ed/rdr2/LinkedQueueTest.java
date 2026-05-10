package ed.rdr2;

import ed.rdr2.model.Event;
import ed.rdr2.model.EventType;
import ed.rdr2.tad.queue.LinkedQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios del TAD Cola (FIFO).
 *
 * @author Daniel Palacios Alonso
 */
class LinkedQueueTest {

    private LinkedQueue<Event> queue;
    private Event e1, e2, e3;

    @BeforeEach
    void setUp() {
        queue = new LinkedQueue<>();
        e1 = new Event(EventType.AMBUSH,         "Pinkertons atacan");
        e2 = new Event(EventType.ENCOUNTER,      "Forastero encontrado");
        e3 = new Event(EventType.CAMP_EMERGENCY, "Urgencia en campamento");
    }

    @Test
    void testEmptyQueueInitially() {
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void testEnqueueAndSize() {
        queue.enqueue(e1);
        queue.enqueue(e2);
        assertEquals(2, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    void testFifoOrder() {
        queue.enqueue(e1);
        queue.enqueue(e2);
        queue.enqueue(e3);
        assertSame(e1, queue.dequeue());
        assertSame(e2, queue.dequeue());
        assertSame(e3, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testPeekDoesNotRemove() {
        queue.enqueue(e1);
        queue.enqueue(e2);
        assertSame(e1, queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    void testDequeueOnEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> queue.dequeue());
    }

    @Test
    void testPeekOnEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> queue.peek());
    }

    @Test
    void testDequeueReducesSize() {
        queue.enqueue(e1);
        queue.enqueue(e2);
        queue.dequeue();
        assertEquals(1, queue.size());
    }

    @Test
    void testSingleEnqueueDequeue() {
        queue.enqueue(e1);
        assertSame(e1, queue.dequeue());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testReEnqueueAfterEmpty() {
        queue.enqueue(e1);
        queue.dequeue();
        queue.enqueue(e2);
        assertSame(e2, queue.peek());
        assertEquals(1, queue.size());
    }
}
