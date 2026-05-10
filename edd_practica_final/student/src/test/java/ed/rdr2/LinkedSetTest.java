package ed.rdr2;

import ed.rdr2.model.InventoryItem;
import ed.rdr2.model.ItemCategory;
import ed.rdr2.tad.set.LinkedSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios del TAD Conjunto (sin duplicados).
 *
 * @author Daniel Palacios Alonso
 */
class LinkedSetTest {

    private LinkedSet<InventoryItem> inventory;
    private InventoryItem revolver, bread, cure, breadDuplicate;

    @BeforeEach
    void setUp() {
        inventory = new LinkedSet<>();
        revolver      = new InventoryItem("Cattleman Revolver", ItemCategory.WEAPON);
        bread         = new InventoryItem("Bread",              ItemCategory.FOOD);
        cure          = new InventoryItem("Health Cure",        ItemCategory.MEDICINE);
        breadDuplicate= new InventoryItem("Bread",              ItemCategory.FOOD);
    }

    @Test
    void testEmptySetInitially() {
        assertTrue(inventory.isEmpty());
        assertEquals(0, inventory.size());
    }

    @Test
    void testAddElements() {
        inventory.add(revolver);
        inventory.add(bread);
        assertEquals(2, inventory.size());
    }

    @Test
    void testDuplicateIgnored() {
        inventory.add(bread);
        inventory.add(breadDuplicate);   // mismo nombre → ignorado
        assertEquals(1, inventory.size());
    }

    @Test
    void testContains() {
        inventory.add(revolver);
        assertTrue(inventory.contains(revolver));
        assertFalse(inventory.contains(bread));
    }

    @Test
    void testContainsDuplicate() {
        inventory.add(bread);
        assertTrue(inventory.contains(breadDuplicate)); // misma clave
    }

    @Test
    void testRemoveExisting() {
        inventory.add(revolver);
        inventory.add(bread);
        assertTrue(inventory.remove(revolver));
        assertEquals(1, inventory.size());
        assertFalse(inventory.contains(revolver));
    }

    @Test
    void testRemoveNonExisting() {
        inventory.add(revolver);
        assertFalse(inventory.remove(bread));
        assertEquals(1, inventory.size());
    }

    @Test
    void testToListSize() {
        inventory.add(revolver);
        inventory.add(bread);
        inventory.add(cure);
        inventory.add(breadDuplicate); // duplicado
        assertEquals(3, inventory.toList().size());
    }

    @Test
    void testInsertionOrder() {
        inventory.add(revolver);
        inventory.add(bread);
        inventory.add(cure);
        var list = inventory.toList();
        assertEquals(revolver, list.get(0));
        assertEquals(bread,    list.get(1));
        assertEquals(cure,     list.get(2));
    }

    @Test
    void testFullScenario() {
        inventory.add(revolver);
        inventory.add(bread);
        inventory.add(cure);
        inventory.add(breadDuplicate);
        assertEquals(3, inventory.size());
        assertTrue(inventory.contains(bread));
        inventory.remove(bread);
        assertFalse(inventory.contains(bread));
        assertEquals(2, inventory.size());
    }
}
