package ed.rdr2.tad.set;

import ed.rdr2.tad.ISet;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de {@link ISet} mediante lista enlazada simple sin duplicados.
 *
 * <p>
 * <b>TODO:</b> Implementa todos los métodos marcados con TODO. Recuerda que la
 * unicidad se garantiza comprobando {@code contains} antes de insertar, usando
 * el método {@code equals} del tipo T.
 * </p>
 *
 * @param <T> tipo de elemento almacenado
 * @author Daniel Palacios Alonso
 */
public class LinkedSet<T> implements ISet<T> {

    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private int size;

    /**
     * Construye un conjunto vacío.
     */
    public LinkedSet() {
        head = null;
        size = 0;
    }

    /**
     * Añade el elemento si no existe ya en el conjunto (usa equals). Si ya
     * existe, la operación no tiene ningún efecto.
     */
    @Override
    public void add(T element) {
        // TODO: Implementa este método
        // Pista: if (contains(element)) return; → luego añade al final
        // NOTA: Usando el contains, la complejidad de este método sube a O(2N),
        // si no se usase, solamente sería O(1N), ya que recorrería la lista 1
        // vez solo.
        if (contains(element)) {
            return;
        }

        Node<T> nuevo = new Node<T>(element);

        if (isEmpty()) {
            head = nuevo;
            size++;
            return;
        }

        Node<T> current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = nuevo;
        size++;
    }

    /**
     * Elimina la primera ocurrencia del elemento.
     *
     * @return true si se eliminó, false si no existía
     */
    @Override
    public boolean remove(T element) {
        // TODO: Implementa este método
        // NOTA: Como en la nota del método add, en este caso no hemos usado 
        // el método contains por mejorar la complejidad explicada en la otra
        // nota.
        if (isEmpty()) {
            return false;
        }

        Node<T> current = head;
        Node<T> anterior = null;

        while (current != null) {
            if (current.data.equals(element)) {
                if (anterior == null) {
                    head = head.next;
                    size--;
                    return true;
                }
                anterior.next = current.next;
                size--;
                return true;
            }
            anterior = current;
            current = current.next;
        }

        return false;
    }

    /**
     * Comprueba si el elemento pertenece al conjunto (usa equals).
     *
     * @return true si el elemento está en el conjunto
     */
    @Override
    public boolean contains(T element) {
        // TODO: Implementa este método
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        // TODO: Implementa este método
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO: Implementa este método
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Devuelve los elementos como lista de Java (solo para salida/tests).
     * Recorre la lista enlazada y añade cada elemento a un ArrayList.
     */
    @Override
    public List<T> toList() {
        // TODO: Implementa este método
        List<T> listaSalida = new ArrayList<>();

        Node<T> current = head;

        while (current != null) {
            listaSalida.add(current.data);
            current = current.next;
        }
        return listaSalida;
    }
}
