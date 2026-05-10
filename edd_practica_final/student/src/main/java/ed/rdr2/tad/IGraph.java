package ed.rdr2.tad;

/**
 * TAD Grafo no dirigido con representación por listas de adyacencia.
 * Modela el mapa de localizaciones de RDR2.
 *
 * <p>Los recorridos BFS y DFS se implementan de forma <b>iterativa</b>
 * usando los TADs propios {@code LinkedQueue} y {@code LinkedStack}.</p>
 *
 * @author Daniel Palacios Alonso
 */
public interface IGraph {

    /**
     * Añade un vértice (localización) al grafo.
     * Si ya existe, la operación no tiene efecto.
     *
     * @param name nombre de la localización
     */
    void addVertex(String name);

    /**
     * Añade una arista no dirigida entre dos localizaciones.
     * Si alguno de los vértices no existe o la arista ya existe, lanza excepción.
     *
     * @param from nombre del primer vértice
     * @param to   nombre del segundo vértice
     * @throws IllegalArgumentException si algún vértice no existe
     */
    void addEdge(String from, String to);

    /**
     * Comprueba si una localización está en el grafo.
     *
     * @param name nombre de la localización
     * @return {@code true} si el vértice existe
     */
    boolean hasVertex(String name);

    /**
     * Comprueba si existe una conexión directa entre dos localizaciones.
     *
     * @param from nombre del primer vértice
     * @param to   nombre del segundo vértice
     * @return {@code true} si existe la arista
     */
    boolean hasEdge(String from, String to);

    /**
     * Recorrido en anchura (BFS) desde la localización inicial.
     * Usa internamente el TAD {@code LinkedQueue}.
     *
     * @param start nombre de la localización de inicio
     * @return lista con los vértices en orden de visita BFS
     * @throws IllegalArgumentException si {@code start} no existe
     */
    java.util.List<String> bfs(String start);

    /**
     * Recorrido en profundidad (DFS) iterativo desde la localización inicial.
     * Usa internamente el TAD {@code LinkedStack}.
     *
     * @param start nombre de la localización de inicio
     * @return lista con los vértices en orden de visita DFS
     * @throws IllegalArgumentException si {@code start} no existe
     */
    java.util.List<String> dfs(String start);
}
