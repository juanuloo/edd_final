package ed.rdr2.tad;

/**
 * TAD Cola genérica con comportamiento FIFO estricto.
 * Modela la cola de eventos del mundo del juego.
 *
 * @param <T> tipo de elemento almacenado
 * @author Daniel Palacios Alonso
 */
public interface IQueue<T> {

    /**
     * Inserta un elemento al final de la cola.
     *
     * @param element elemento a encolar
     */
    void enqueue(T element);

    /**
     * Extrae y devuelve el elemento del frente de la cola (FIFO).
     *
     * @return elemento extraído
     * @throws java.util.NoSuchElementException si la cola está vacía
     */
    T dequeue();

    /**
     * Consulta el elemento del frente sin extraerlo.
     *
     * @return elemento del frente
     * @throws java.util.NoSuchElementException si la cola está vacía
     */
    T peek();

    /** @return número de elementos en la cola */
    int size();

    /** @return {@code true} si la cola está vacía */
    boolean isEmpty();
}
