package ed.rdr2;

import ed.rdr2.tad.graph.AdjacencyListGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests unitarios del TAD Grafo — BFS exacto y DFS válido.
 *
 * <p>BFS desde Valentine debe producir <b>exactamente</b>:</p>
 * <pre>
 * Valentine, Colter, Cumberland Falls, Emerald Ranch,
 * Annesburg, Strawberry, Riggs Station, Rhodes,
 * Saint Denis, Van Horn, Sisika Penitentiary
 * </pre>
 *
 * @author Daniel Palacios Alonso
 */
class GraphTest {

    private AdjacencyListGraph map;

    @BeforeEach
    void setUp() {
        map = new AdjacencyListGraph();
        map.addVertex("Valentine");
        map.addVertex("Colter");
        map.addVertex("Cumberland Falls");
        map.addVertex("Emerald Ranch");
        map.addVertex("Annesburg");
        map.addVertex("Strawberry");
        map.addVertex("Riggs Station");
        map.addVertex("Rhodes");
        map.addVertex("Saint Denis");
        map.addVertex("Van Horn");
        map.addVertex("Sisika Penitentiary");

        map.addEdge("Valentine",       "Colter");
        map.addEdge("Valentine",       "Cumberland Falls");
        map.addEdge("Valentine",       "Emerald Ranch");
        map.addEdge("Colter",          "Annesburg");
        map.addEdge("Cumberland Falls","Strawberry");
        map.addEdge("Emerald Ranch",   "Riggs Station");
        map.addEdge("Strawberry",      "Rhodes");
        map.addEdge("Riggs Station",   "Saint Denis");
        map.addEdge("Rhodes",          "Van Horn");
        map.addEdge("Saint Denis",     "Van Horn");
        map.addEdge("Van Horn",        "Sisika Penitentiary");
    }

    // ---- Vértices y aristas ----

    @Test
    void testAddVertex() {
        assertTrue(map.hasVertex("Valentine"));
        assertTrue(map.hasVertex("Sisika Penitentiary"));
        assertFalse(map.hasVertex("Guarma"));
    }

    @Test
    void testAddDuplicateVertexNoEffect() {
        map.addVertex("Valentine");
        assertEquals(11, map.vertexCount());
    }

    @Test
    void testAddEdge() {
        assertTrue(map.hasEdge("Valentine", "Colter"));
        assertTrue(map.hasEdge("Colter", "Valentine")); // no dirigido
    }

    @Test
    void testAddEdgeToNonExistentVertexThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> map.addEdge("Valentine", "Guarma"));
    }

    @Test
    void testHasEdgeFalseForNonAdjacent() {
        assertFalse(map.hasEdge("Valentine", "Annesburg"));
        assertFalse(map.hasEdge("Colter", "Rhodes"));
    }

    // ---- BFS exacto ----

    @Test
    void testBfsExactOrder() {
        List<String> bfs = map.bfs("Valentine");
        List<String> expected = List.of(
                "Valentine", "Colter", "Cumberland Falls", "Emerald Ranch",
                "Annesburg", "Strawberry", "Riggs Station",
                "Rhodes", "Saint Denis", "Van Horn", "Sisika Penitentiary"
        );
        assertEquals(expected, bfs);
    }

    @Test
    void testBfsVisitsAllVertices() {
        assertEquals(11, map.bfs("Valentine").size());
    }

    @Test
    void testBfsFromNonExistentThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> map.bfs("Guarma"));
    }

    @Test
    void testBfsNoRepetitions() {
        List<String> bfs = map.bfs("Valentine");
        long distinct = bfs.stream().distinct().count();
        assertEquals(bfs.size(), distinct);
    }

    // ---- DFS válido ----

    @Test
    void testDfsVisitsAllVertices() {
        List<String> dfs = map.dfs("Valentine");
        assertEquals(11, dfs.size());
    }

    @Test
    void testDfsStartsAtValentine() {
        assertEquals("Valentine", map.dfs("Valentine").get(0));
    }

    @Test
    void testDfsDifferentFromBfs() {
        List<String> bfs = map.bfs("Valentine");
        List<String> dfs = map.dfs("Valentine");
        assertNotEquals(bfs, dfs);
    }

    @Test
    void testDfsNoRepetitions() {
        List<String> dfs = map.dfs("Valentine");
        long distinct = dfs.stream().distinct().count();
        assertEquals(dfs.size(), distinct);
    }

    @Test
    void testDfsFromNonExistentThrows() {
        assertThrows(IllegalArgumentException.class,
                () -> map.dfs("Guarma"));
    }

    // ---- Grafo trivial ----

    @Test
    void testSingleVertexBfs() {
        AdjacencyListGraph g = new AdjacencyListGraph();
        g.addVertex("Solo");
        assertEquals(List.of("Solo"), g.bfs("Solo"));
        assertEquals(List.of("Solo"), g.dfs("Solo"));
    }
}
