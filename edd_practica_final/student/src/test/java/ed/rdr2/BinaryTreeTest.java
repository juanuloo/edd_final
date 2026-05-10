package ed.rdr2;

import ed.rdr2.tad.tree.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios del TAD Árbol Binario (recorridos recursivos).
 *
 * Árbol de prueba:
 * <pre>
 *             Root
 *            /    \
 *          L1      R1
 *         /  \    /  \
 *        L2  R2  L3  R3
 * </pre>
 * InOrden  : L2, L1, R2, Root, L3, R1, R3
 * PreOrden : Root, L1, L2, R2, R1, L3, R3
 * PostOrden: L2, R2, L1, L3, R3, R1, Root
 *
 * @author Daniel Palacios Alonso
 */
class BinaryTreeTest {

    private BinaryTree<String> tree;

    @BeforeEach
    void setUp() {
        tree = new BinaryTree<>();
        tree.setRoot("Root");
        tree.insertLeft("Root", "L1");
        tree.insertRight("Root", "R1");
        tree.insertLeft("L1", "L2");
        tree.insertRight("L1", "R2");
        tree.insertLeft("R1", "L3");
        tree.insertRight("R1", "R3");
    }

    @Test
    void testNotEmpty() {
        assertFalse(tree.isEmpty());
    }

    @Test
    void testEmptyTree() {
        BinaryTree<String> empty = new BinaryTree<>();
        assertTrue(empty.isEmpty());
        assertTrue(empty.inOrder().isEmpty());
        assertTrue(empty.preOrder().isEmpty());
        assertTrue(empty.postOrder().isEmpty());
    }

    @Test
    void testInOrder() {
        List<String> result = tree.inOrder();
        assertEquals(List.of("L2", "L1", "R2", "Root", "L3", "R1", "R3"), result);
    }

    @Test
    void testPreOrder() {
        List<String> result = tree.preOrder();
        assertEquals(List.of("Root", "L1", "L2", "R2", "R1", "L3", "R3"), result);
    }

    @Test
    void testPostOrder() {
        List<String> result = tree.postOrder();
        assertEquals(List.of("L2", "R2", "L1", "L3", "R3", "R1", "Root"), result);
    }

    @Test
    void testContainsExisting() {
        assertTrue(tree.contains("Root"));
        assertTrue(tree.contains("L2"));
        assertTrue(tree.contains("R3"));
    }

    @Test
    void testContainsNonExisting() {
        assertFalse(tree.contains("Ghost"));
        assertFalse(tree.contains(""));
    }

    @Test
    void testAllNodesInAllTraversals() {
        List<String> all = List.of("Root", "L1", "R1", "L2", "R2", "L3", "R3");
        assertTrue(tree.inOrder().containsAll(all));
        assertTrue(tree.preOrder().containsAll(all));
        assertTrue(tree.postOrder().containsAll(all));
    }

    @Test
    void testSizeOfTraversals() {
        assertEquals(7, tree.inOrder().size());
        assertEquals(7, tree.preOrder().size());
        assertEquals(7, tree.postOrder().size());
    }

    @Test
    void testInsertLeftOnExistingChildThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> tree.insertLeft("L1", "NewNode")); // L1 ya tiene hijo izq
    }

    @Test
    void testInsertOnNonExistentParentThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> tree.insertLeft("NoExiste", "X"));
    }

    @Test
    void testDecisionTreeScenario() {
        BinaryTree<String> dt = new BinaryTree<>();
        dt.setRoot("¿Ayudar a la banda o huir?");
        dt.insertLeft("¿Ayudar a la banda o huir?", "Ayudar → Lealtad+");
        dt.insertRight("¿Ayudar a la banda o huir?", "Huir → Supervivencia+");
        dt.insertLeft("Ayudar → Lealtad+", "La banda sobrevive");
        dt.insertRight("Ayudar → Lealtad+", "Arthur resulta herido");
        dt.insertLeft("Huir → Supervivencia+", "Arthur escapa ileso");
        dt.insertRight("Huir → Supervivencia+", "La banda se debilita");

        assertTrue(dt.contains("Arthur escapa ileso"));
        assertFalse(dt.contains("Rendirse"));
        assertEquals(7, dt.inOrder().size());
        assertEquals("¿Ayudar a la banda o huir?", dt.preOrder().get(0));
    }
}
