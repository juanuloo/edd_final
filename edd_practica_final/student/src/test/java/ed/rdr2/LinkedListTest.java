package ed.rdr2;

import ed.rdr2.model.Mission;
import ed.rdr2.model.MissionStatus;
import ed.rdr2.tad.list.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios del TAD Lista enlazada.
 *
 * @author Daniel Palacios Alonso
 */
class LinkedListTest {

    private LinkedList<Mission> list;
    private Mission m1, m2, m3;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
        m1 = new Mission("Train Robbery", "desc1", MissionStatus.PENDING);
        m2 = new Mission("Hunting",       "desc2", MissionStatus.PENDING);
        m3 = new Mission("Rescue",        "desc3", MissionStatus.PENDING);
    }

    @Test
    void testEmptyListInitially() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testAddLast() {
        list.addLast(m1);
        list.addLast(m2);
        list.addLast(m3);
        assertEquals(3, list.size());
        assertEquals(m1, list.get(0));
        assertEquals(m2, list.get(1));
        assertEquals(m3, list.get(2));
    }

    @Test
    void testAddAtMiddle() {
        list.addLast(m1);
        list.addLast(m2);
        list.addLast(m3);
        Mission ambush = new Mission("Ambush", "emboscada", MissionStatus.ACTIVE);
        list.addAt(1, ambush);
        assertEquals(4, list.size());
        assertEquals(m1,    list.get(0));
        assertEquals(ambush,list.get(1));
        assertEquals(m2,    list.get(2));
        assertEquals(m3,    list.get(3));
    }

    @Test
    void testAddAtHead() {
        list.addLast(m1);
        list.addLast(m2);
        Mission head = new Mission("Head", "primero", MissionStatus.PENDING);
        list.addAt(0, head);
        assertEquals(head, list.get(0));
        assertEquals(m1,   list.get(1));
        assertEquals(3,    list.size());
    }

    @Test
    void testAddAtTail() {
        list.addLast(m1);
        list.addLast(m2);
        Mission tail = new Mission("Tail", "último", MissionStatus.PENDING);
        list.addAt(2, tail);
        assertEquals(tail, list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    void testAddAtOutOfBoundsThrows() {
        list.addLast(m1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.addAt(5, m2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.addAt(-1, m2));
    }

    @Test
    void testRemoveExisting() {
        list.addLast(m1);
        list.addLast(m2);
        list.addLast(m3);
        assertTrue(list.remove(m2));
        assertEquals(2, list.size());
        assertEquals(m1, list.get(0));
        assertEquals(m3, list.get(1));
    }

    @Test
    void testRemoveHead() {
        list.addLast(m1);
        list.addLast(m2);
        assertTrue(list.remove(m1));
        assertEquals(1, list.size());
        assertEquals(m2, list.get(0));
    }

    @Test
    void testRemoveNonExisting() {
        list.addLast(m1);
        Mission notInList = new Mission("Ghost", "desc", MissionStatus.FAILED);
        assertFalse(list.remove(notInList));
        assertEquals(1, list.size());
    }

    @Test
    void testGetOutOfBoundsThrows() {
        list.addLast(m1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void testNotEmptyAfterAdd() {
        list.addLast(m1);
        assertFalse(list.isEmpty());
    }

    @Test
    void testSizeAfterRemoveAll() {
        list.addLast(m1);
        list.addLast(m2);
        list.remove(m1);
        list.remove(m2);
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }
}
