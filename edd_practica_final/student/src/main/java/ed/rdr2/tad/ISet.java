package ed.rdr2.tad;

/**
 * TAD Conjunto genérico sin duplicados.
 * Modela el inventario de la banda; la igualdad de elementos
 * depende del método {@code equals} del tipo T.
 *
 * @param <T> tipo de elemento almacenado
 * @author Daniel Palacios Alonso
 */
public interface ISet<T> {

    /**
     * Añade un elemento al conjunto.
     * Si el elemento ya existe (según {@code equals}), la operación
     * no tiene ningún efecto.
     *
     * @param element elemento a añadir
     */
    void add(T element);

    /**
     * Elimina el elemento del conjunto si existe.
     *
     * @param element elemento a eliminar
     * @return {@code true} si el elemento existía y fue eliminado
     */
    boolean remove(T element);

    /**
     * Comprueba si el elemento pertenece al conjunto.
     *
     * @param element elemento a buscar
     * @return {@code true} si el elemento está en el conjunto
     */
    boolean contains(T element);

    /** @return número de elementos en el conjunto */
    int size();

    /** @return {@code true} si el conjunto está vacío */
    boolean isEmpty();

    /**
     * Devuelve los elementos como lista de Java (solo para salida/tests).
     *
     * @return lista con los elementos del conjunto en orden de inserción
     */
    java.util.List<T> toList();
}
