package ed.rdr2;

import ed.rdr2.model.Character;
import ed.rdr2.model.CharacterRole;
import ed.rdr2.model.Event;
import ed.rdr2.model.EventType;
import ed.rdr2.model.InventoryItem;
import ed.rdr2.model.ItemCategory;
import ed.rdr2.model.Mission;
import ed.rdr2.model.MissionStatus;
import ed.rdr2.tad.list.LinkedList;
import ed.rdr2.tad.queue.LinkedQueue;
import ed.rdr2.tad.stack.LinkedStack;
import ed.rdr2.tad.set.LinkedSet;
import ed.rdr2.tad.tree.BinaryTree;
import ed.rdr2.tad.graph.AdjacencyListGraph;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests de integración: verifican que todos los TADs interactúan
 * correctamente en el escenario completo de la simulación RDR2.
 *
 * @author Daniel Palacios Alonso
 */
class IntegrationTest {

    @Test
    void testFullMissionScenario() {
        LinkedList<Mission> missions = new LinkedList<>();
        missions.addLast(new Mission("Train Robbery", "desc", MissionStatus.PENDING));
        missions.addLast(new Mission("Hunting",       "desc", MissionStatus.PENDING));
        missions.addLast(new Mission("Rescue",        "desc", MissionStatus.PENDING));
        missions.addAt(1, new Mission("Ambush", "desc", MissionStatus.ACTIVE));

        assertEquals(4, missions.size());
        assertEquals("Train Robbery", missions.get(0).getTitle());
        assertEquals("Ambush",        missions.get(1).getTitle());
        assertEquals("Hunting",       missions.get(2).getTitle());
        assertEquals("Rescue",        missions.get(3).getTitle());
    }

    @Test
    void testEventQueueFifo() {
        LinkedQueue<Event> q = new LinkedQueue<>();
        q.enqueue(new Event(EventType.AMBUSH,         "Ataque"));
        q.enqueue(new Event(EventType.ENCOUNTER,      "Encuentro"));
        q.enqueue(new Event(EventType.CAMP_EMERGENCY, "Urgencia"));

        assertEquals(EventType.AMBUSH,         q.dequeue().getType());
        assertEquals(EventType.ENCOUNTER,      q.dequeue().getType());
        assertEquals(EventType.CAMP_EMERGENCY, q.dequeue().getType());
        assertTrue(q.isEmpty());
    }

    @Test
    void testActionStackUndo() {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("Aceptar misión");
        stack.push("Moverse a Colter");
        stack.push("Abrir inventario");

        assertEquals("Abrir inventario", stack.undo());
        assertEquals(2, stack.size());
        assertEquals("Moverse a Colter", stack.peek());
    }

    @Test
    void testInventoryNoDuplicates() {
        LinkedSet<InventoryItem> inv = new LinkedSet<>();
        inv.add(new InventoryItem("Bread", ItemCategory.FOOD));
        inv.add(new InventoryItem("Bread", ItemCategory.FOOD));
        inv.add(new InventoryItem("Revolver", ItemCategory.WEAPON));

        assertEquals(2, inv.size());
        assertTrue(inv.contains(new InventoryItem("Bread", ItemCategory.FOOD)));
    }

    @Test
    void testDecisionTreeIntegration() {
        BinaryTree<String> tree = new BinaryTree<>();
        tree.setRoot("¿Ayudar a la banda o huir?");
        tree.insertLeft("¿Ayudar a la banda o huir?", "Ayudar → Lealtad+");
        tree.insertRight("¿Ayudar a la banda o huir?", "Huir → Supervivencia+");
        tree.insertLeft("Ayudar → Lealtad+", "La banda sobrevive");
        tree.insertRight("Ayudar → Lealtad+", "Arthur resulta herido");
        tree.insertLeft("Huir → Supervivencia+", "Arthur escapa ileso");
        tree.insertRight("Huir → Supervivencia+", "La banda se debilita");

        assertEquals(7, tree.inOrder().size());
        assertTrue(tree.contains("La banda sobrevive"));
        // La raíz es el primer elemento del preorden
        assertEquals("¿Ayudar a la banda o huir?", tree.preOrder().get(0));
        // Las hojas son el primer y el último en el postorden
        List<String> post = tree.postOrder();
        assertEquals("La banda sobrevive", post.get(0));
        assertEquals("¿Ayudar a la banda o huir?", post.get(post.size() - 1));
    }

    @Test
    void testGraphBfsAndDfsIntegration() {
        AdjacencyListGraph g = new AdjacencyListGraph();
        g.addVertex("Valentine"); g.addVertex("Colter");
        g.addVertex("Cumberland Falls"); g.addVertex("Emerald Ranch");
        g.addVertex("Annesburg"); g.addVertex("Strawberry");
        g.addVertex("Riggs Station"); g.addVertex("Rhodes");
        g.addVertex("Saint Denis"); g.addVertex("Van Horn");
        g.addVertex("Sisika Penitentiary");

        g.addEdge("Valentine", "Colter");
        g.addEdge("Valentine", "Cumberland Falls");
        g.addEdge("Valentine", "Emerald Ranch");
        g.addEdge("Colter", "Annesburg");
        g.addEdge("Cumberland Falls", "Strawberry");
        g.addEdge("Emerald Ranch", "Riggs Station");
        g.addEdge("Strawberry", "Rhodes");
        g.addEdge("Riggs Station", "Saint Denis");
        g.addEdge("Rhodes", "Van Horn");
        g.addEdge("Saint Denis", "Van Horn");
        g.addEdge("Van Horn", "Sisika Penitentiary");

        List<String> bfs = g.bfs("Valentine");
        List<String> dfs = g.dfs("Valentine");

        assertEquals(11, bfs.size());
        assertEquals(11, dfs.size());
        assertNotEquals(bfs, dfs);
        assertEquals("Valentine", bfs.get(0));
        assertEquals("Valentine", dfs.get(0));
        // Primer vecino de Valentine en BFS
        assertEquals("Colter", bfs.get(1));
    }

    @Test
    void testFullSystemTogether() {
        // Personaje
        Character arthur = new Character("Arthur Morgan", CharacterRole.OUTLAW);
        assertEquals("Arthur Morgan", arthur.getName());

        // Misiones
        LinkedList<Mission> missions = new LinkedList<>();
        missions.addLast(new Mission("Train Robbery", "d", MissionStatus.PENDING));
        missions.addAt(0, new Mission("Ambush", "d", MissionStatus.ACTIVE));

        // Inventario
        LinkedSet<InventoryItem> inv = new LinkedSet<>();
        inv.add(new InventoryItem("Revolver", ItemCategory.WEAPON));
        inv.add(new InventoryItem("Revolver", ItemCategory.WEAPON)); // duplicado

        // Pila
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("Acción 1");
        stack.push("Acción 2");
        stack.undo();

        // Aserciones integradas
        assertEquals(2, missions.size());
        assertEquals(1, inv.size());
        assertEquals(1, stack.size());
    }
}
