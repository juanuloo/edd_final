package ed.rdr2.tad;

/**
 * TAD Lista genérica con soporte de inserción en posición arbitraria.
 * Modela la lista de misiones activas de la banda.
 *
 * @param <T> tipo de elemento almacenado
 * @author Daniel Palacios Alonso
 */
public interface IList<T> {

    /**
     * Inserta un elemento al final de la lista.
     *
     * @param element elemento a insertar
     */
    void addLast(T element);

    /**
     * Inserta un elemento en la posición indicada (0-based).
     * Los elementos posteriores se desplazan una posición.
     *
     * @param index   posición de inserción (0 ≤ index ≤ size)
     * @param element elemento a insertar
     * @throws IndexOutOfBoundsException si index está fuera de rango
     */
    void addAt(int index, T element);

    /**
     * Elimina la primera ocurrencia del elemento dado.
     *
     * @param element elemento a eliminar
     * @return {@code true} si el elemento existía y fue eliminado
     */
    boolean remove(T element);

    /**
     * Devuelve el elemento en la posición indicada (0-based).
     *
     * @param index posición (0 ≤ index &lt; size)
     * @return elemento en esa posición
     * @throws IndexOutOfBoundsException si index está fuera de rango
     */
    T get(int index);

    /** @return número de elementos en la lista */
    int size();

    /** @return {@code true} si la lista está vacía */
    boolean isEmpty();
}
