package ed.rdr2.tad;

/**
 * TAD Pila genérica con comportamiento LIFO y operación de deshacer.
 * Modela el historial de acciones de la banda.
 *
 * @param <T> tipo de elemento almacenado
 * @author Daniel Palacios Alonso
 */
public interface IStack<T> {

    /**
     * Apila un elemento en la cima.
     *
     * @param element elemento a apilar
     */
    void push(T element);

    /**
     * Extrae y devuelve el elemento de la cima (LIFO).
     *
     * @return elemento extraído
     * @throws java.util.NoSuchElementException si la pila está vacía
     */
    T pop();

    /**
     * Consulta el elemento de la cima sin extraerlo.
     *
     * @return elemento de la cima
     * @throws java.util.NoSuchElementException si la pila está vacía
     */
    T peek();

    /**
     * Deshace la última acción: extrae y devuelve el elemento de la cima.
     * Semánticamente equivalente a {@link #pop()}, pero con nombre
     * que refleja la intención de deshacer una operación.
     *
     * @return elemento deshecho
     * @throws java.util.NoSuchElementException si la pila está vacía
     */
    T undo();

    /** @return número de elementos en la pila */
    int size();

    /** @return {@code true} si la pila está vacía */
    boolean isEmpty();
}
