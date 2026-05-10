package ed.rdr2.tad;

/**
 * TAD Árbol Binario genérico con recorridos exclusivamente recursivos.
 * Modela el árbol de decisiones narrativas del juego.
 *
 * <p>La búsqueda de nodo padre para inserción también es recursiva.</p>
 *
 * @param <T> tipo de elemento almacenado en cada nodo
 * @author Daniel Palacios Alonso
 */
public interface IBinaryTree<T> {

    /**
     * Establece la raíz del árbol.
     *
     * @param data dato de la raíz
     */
    void setRoot(T data);

    /**
     * Inserta un nuevo nodo como hijo izquierdo del nodo con valor {@code parent}.
     *
     * @param parent dato del nodo padre (búsqueda recursiva)
     * @param data   dato del nuevo nodo
     * @throws IllegalArgumentException si el nodo padre no existe o ya tiene hijo izquierdo
     */
    void insertLeft(T parent, T data);

    /**
     * Inserta un nuevo nodo como hijo derecho del nodo con valor {@code parent}.
     *
     * @param parent dato del nodo padre (búsqueda recursiva)
     * @param data   dato del nuevo nodo
     * @throws IllegalArgumentException si el nodo padre no existe o ya tiene hijo derecho
     */
    void insertRight(T parent, T data);

    /**
     * Recorrido en orden simétrico (izquierda → raíz → derecha). Recursivo.
     *
     * @return lista con los elementos en orden inorden
     */
    java.util.List<T> inOrder();

    /**
     * Recorrido en preorden (raíz → izquierda → derecha). Recursivo.
     *
     * @return lista con los elementos en preorden
     */
    java.util.List<T> preOrder();

    /**
     * Recorrido en postorden (izquierda → derecha → raíz). Recursivo.
     *
     * @return lista con los elementos en postorden
     */
    java.util.List<T> postOrder();

    /**
     * Comprueba si el árbol contiene el dato indicado. Recursivo.
     *
     * @param data dato a buscar
     * @return {@code true} si el dato existe en algún nodo
     */
    boolean contains(T data);

    /** @return {@code true} si el árbol está vacío (sin raíz) */
    boolean isEmpty();
}
