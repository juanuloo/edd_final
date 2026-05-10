package ed.rdr2.tad.tree;

import ed.rdr2.tad.IBinaryTree;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de {@link IBinaryTree} mediante nodos enlazados.
 *
 * <p><b>OBLIGATORIO:</b> Todos los recorridos y búsquedas deben ser
 * exclusivamente <b>recursivos</b> (implementados en métodos privados auxiliares).</p>
 *
 * <p><b>TODO:</b> Implementa todos los métodos marcados.</p>
 *
 * @param <T> tipo de elemento almacenado en cada nodo
 * @author Daniel Palacios Alonso
 */
public class BinaryTree<T> implements IBinaryTree<T> {

    private static class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;
        Node(T data) { this.data = data; }
    }

    private Node<T> root;

    public BinaryTree() { root = null; }

    @Override
    public void setRoot(T data) {
        // TODO: Crea un nuevo Node<>(data) y asígnalo a root
        Node<T> newRoot = root;
    }

    @Override
    public void insertLeft(T parent, T data) {
        // TODO: Usa findNode(root, parent) para obtener el nodo padre.
        // Si es null → IllegalArgumentException. Si ya tiene hijo izq → IllegalArgumentException.
        // Si no → parentNode.left = new Node<>(data)
        throw new UnsupportedOperationException("TODO: Implementar insertLeft");
    }

    @Override
    public void insertRight(T parent, T data) {
        // TODO: Análogo a insertLeft pero para hijo derecho
        throw new UnsupportedOperationException("TODO: Implementar insertRight");
    }

    @Override
    public List<T> inOrder() {
        // TODO: List<T> result = new ArrayList<>(); inOrderRec(root, result); return result;
        throw new UnsupportedOperationException("TODO: Implementar inOrder");
    }

    @Override
    public List<T> preOrder() {
        // TODO: Delega en preOrderRec
        throw new UnsupportedOperationException("TODO: Implementar preOrder");
    }

    @Override
    public List<T> postOrder() {
        // TODO: Delega en postOrderRec
        throw new UnsupportedOperationException("TODO: Implementar postOrder");
    }

    @Override
    public boolean contains(T data) {
        // TODO: return containsRec(root, data);
        throw new UnsupportedOperationException("TODO: Implementar contains");
    }

    @Override
    public boolean isEmpty() {
        // TODO: return root == null;
        throw new UnsupportedOperationException("TODO: Implementar isEmpty");
    }

    // ---- Métodos auxiliares recursivos PRIVADOS — TODO implementar ----

    /** Búsqueda recursiva. Base: null → null | data.equals → node. Recursivo: left luego right. */
    private Node<T> findNode(Node<T> node, T target) { //T x = target, NodoBinario<T> t = node
        // TODO: Implementa de forma recursiva
        throw new UnsupportedOperationException("TODO: Implementar insertRight");
        /* if(node.data.equals(target)){
            return node;
        }
        
        int comparar = target.compareTo(node.data);
        
        if(comparar < 0){
            encontrar(x, t.hi);
        }else if(comparar > 0){
            encontrar(x, t.hd);
        }
        
        
        return null;*/
    }

    /** InOrden: left → visit → right. Base: node == null → return. */
    private void inOrderRec(Node<T> node, List<T> result) {
        // TODO: Implementa de forma recursiva
        throw new UnsupportedOperationException("TODO: Implementar inOrderRec (recursivo)");
    }

    /** PreOrden: visit → left → right. Base: node == null → return. */
    private void preOrderRec(Node<T> node, List<T> result) {
        // TODO: Implementa de forma recursiva
        throw new UnsupportedOperationException("TODO: Implementar preOrderRec (recursivo)");
    }

    /** PostOrden: left → right → visit. Base: node == null → return. */
    private void postOrderRec(Node<T> node, List<T> result) {
        // TODO: Implementa de forma recursiva
        throw new UnsupportedOperationException("TODO: Implementar postOrderRec (recursivo)");
    }

    /** Existencia recursiva. Base: null → false | equals → true. Recursivo: left || right. */
    private boolean containsRec(Node<T> node, T target) {
        // TODO: Implementa de forma recursiva
        throw new UnsupportedOperationException("TODO: Implementar containsRec (recursivo)");
    }
}
