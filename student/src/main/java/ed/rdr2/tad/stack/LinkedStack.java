package ed.rdr2.tad.stack;

import ed.rdr2.tad.IStack;
import java.util.NoSuchElementException;

/**
 * Implementación de {@link IStack} mediante lista enlazada simple.
 * Comportamiento LIFO: {@code push} y {@code pop/undo} operan sobre la cima.
 *
 * <p><b>TODO:</b> Implementa todos los métodos marcados con TODO.
 * El puntero {@code top} apunta siempre al nodo de la cima.</p>
 *
 * <p><b>PROHIBIDO:</b> usar colecciones de {@code java.util.*} como estructura interna.</p>
 *
 * @param <T> tipo de elemento almacenado
 * @author Daniel Palacios Alonso
 */
public class LinkedStack<T> implements IStack<T> {

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> top;
    private int size;

    /** Construye una pila vacía. */
    public LinkedStack() {
        top  = null;
        size = 0;
    }

    /**
     * Apila un elemento en la cima (LIFO).
     * El nuevo nodo apunta al antiguo top; top pasa a ser el nuevo nodo.
     */
    @Override
    public void push(T element) {
        // TODO: Implementa este método
        Node<T> nuevo = new Node<T>(element);
        
        if(isEmpty()){
            top = nuevo;
            size++;
            return;
        }
        nuevo.next = top;
        top = nuevo;
        size++;
        return;
    }

    /**
     * Extrae y devuelve el elemento de la cima (LIFO).
     *
     * @throws NoSuchElementException si la pila está vacía
     */
    @Override
    public T pop() {
        // TODO: Implementa este método
        if(isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        
        Node<T> devolver = null;
        
        devolver = top;
        top = top.next;
        size--;
        return devolver.data;
    }

    /**
     * Consulta la cima sin extraerla.
     *
     * @throws NoSuchElementException si la pila está vacía
     */
    @Override
    public T peek() {
        // TODO: Implementa este método
        if(isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        
        return top.data;
    }

    /**
     * Deshace la última acción. Semánticamente equivalente a {@link #pop()}.
     *
     * @throws NoSuchElementException si la pila está vacía
     */
    @Override
    public T undo() {
        // TODO: Implementa este método (pista: llama a pop())
        return pop();
    }

    @Override
    public int size() {
        // TODO: Implementa este método
        return size;
    }

    @Override
    public boolean isEmpty() {
        // TODO: Implementa este método
        if (size == 0){
            return true;
        }
        return false;
    }
}
