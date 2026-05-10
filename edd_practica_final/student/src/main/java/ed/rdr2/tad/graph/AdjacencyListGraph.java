package ed.rdr2.tad.graph;

import ed.rdr2.tad.IGraph;
import ed.rdr2.tad.list.LinkedList;
import ed.rdr2.tad.queue.LinkedQueue;
import ed.rdr2.tad.stack.LinkedStack;
import java.util.List;

/**
 * Implementación de {@link IGraph} mediante listas de adyacencia.
 * Grafo no dirigido. BFS y DFS son <b>iterativos</b>.
 *
 * <p>
 * <b>OBLIGATORIO:</b>
 * </p>
 * <ul>
 * <li>BFS debe usar internamente {@link LinkedQueue} (tu propia
 * implementación).</li>
 * <li>DFS debe usar internamente {@link LinkedStack} (tu propia
 * implementación).</li>
 * <li>Ambos algoritmos son iterativos (sin recursividad).</li>
 * </ul>
 *
 * <p>
 * <b>TODO:</b> Implementa todos los métodos marcados.
 * </p>
 *
 * @author Daniel Palacios Alonso
 */
public class AdjacencyListGraph implements IGraph {

    private static final int MAX_VERTICES = 50;

    private final String[] vertices;

    @SuppressWarnings("unchecked")
    private final LinkedList<String>[] adjacency = (LinkedList<String>[]) new LinkedList[MAX_VERTICES];

    private int vertexCount;

    /** Construye un grafo vacío. */
    public AdjacencyListGraph() {
        vertices = new String[MAX_VERTICES];
        vertexCount = 0;
    }

    /**
     * Añade un vértice. Si ya existe, no hace nada.
     * Pista: incrementa vertexCount, inicializa adjacency[vertexCount] con new
     * LinkedList<>()
     */
    @Override
    public void addVertex(String name) {
        // TODO: Implementa este método
        throw new UnsupportedOperationException("TODO: Implementar addVertex");
    }

    /**
     * Añade arista no dirigida: añade 'to' a la lista de 'from' y viceversa.
     *
     * @throws IllegalArgumentException si algún vértice no existe
     */
    @Override
    public void addEdge(String from, String to) {
        // TODO: Implementa este método
        // Pista: int fromIdx = indexOf(from); int toIdx = indexOf(to);
        // if (fromIdx == -1) throw new IllegalArgumentException(...)
        throw new UnsupportedOperationException("TODO: Implementar addEdge");
    }

    /** @return true si el vértice existe */
    @Override
    public boolean hasVertex(String name) {
        // TODO: Implementa este método
        // Pista: return indexOf(name) != -1;
        throw new UnsupportedOperationException("TODO: Implementar hasVertex");
    }

    /** @return true si existe la arista entre from y to */
    @Override
    public boolean hasEdge(String from, String to) {
        // TODO: Implementa este método
        // Pista: busca 'to' en la lista de adyacencia de 'from'
        throw new UnsupportedOperationException("TODO: Implementar hasEdge");
    }

    /**
     * BFS iterativo desde {@code start} usando {@link LinkedQueue}.
     *
     * <p>
     * Algoritmo:
     * </p>
     * 
     * <pre>
     *   boolean[] visited = new boolean[MAX_VERTICES];
     *   LinkedQueue&lt;String&gt; queue = new LinkedQueue&lt;&gt;();
     *   marcar start como visitado y encolarlo
     *   mientras cola no vacía:
     *     current = queue.dequeue()
     *     añadir current a result
     *     para cada vecino no visitado de current:
     *       marcarlo visitado y encolarlo
     * </pre>
     *
     * @throws IllegalArgumentException si {@code start} no existe
     */
    @Override
    public List<String> bfs(String start) {
        // TODO: Implementa este método
        throw new UnsupportedOperationException("TODO: Implementar bfs");
    }

    /**
     * DFS iterativo desde {@code start} usando {@link LinkedStack}.
     *
     * <p>
     * Algoritmo (marcar visitado al apilar):
     * </p>
     * 
     * <pre>
     *   boolean[] visited = new boolean[MAX_VERTICES];
     *   LinkedStack&lt;String&gt; stack = new LinkedStack&lt;&gt;();
     *   marcar start como visitado y apilarlo
     *   mientras pila no vacía:
     *     current = stack.pop()
     *     añadir current a result
     *     apilar vecinos no visitados en orden INVERSO de la lista
     *     (así el primer vecino de la lista queda en la cima)
     * </pre>
     *
     * @throws IllegalArgumentException si {@code start} no existe
     */
    @Override
    public List<String> dfs(String start) {
        // TODO: Implementa este método
        throw new UnsupportedOperationException("TODO: Implementar dfs");
    }

    // -------------------------------------------------------------------------
    // Auxiliar proporcionado — NO modificar
    // -------------------------------------------------------------------------

    /**
     * Devuelve el índice del vértice en el array, o -1 si no existe.
     * Puedes usarlo libremente en tus implementaciones.
     *
     * @param name nombre del vértice
     * @return índice o -1
     */
    private int indexOf(String name) {
        for (int i = 0; i < vertexCount; i++) {
            if (vertices[i].equals(name))
                return i;
        }
        return -1;
    }

    /** @return número de vértices del grafo */
    public int vertexCount() {
        return vertexCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Graph:\n");
        for (int i = 0; i < vertexCount; i++) {
            sb.append("  ").append(vertices[i]).append(" → ").append(adjacency[i]).append("\n");
        }
        return sb.toString();
    }
}
