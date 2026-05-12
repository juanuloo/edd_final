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
        Node<T> newRoot = new Node<>(data);
        root = newRoot;
        
    }

    @Override
    public void insertLeft(T parent, T data) {
        // TODO: Usa findNode(root, parent) para obtener el nodo padre.
        // Si es null → IllegalArgumentException. Si ya tiene hijo izq → IllegalArgumentException.
        // Si no → parentNode.left = new Node<>(data)
        
        Node<T> parentNode = findNode(root, parent);
        
        if (parentNode == null) throw new IllegalArgumentException("Padre no encontrado");
        else if (parentNode.left != null) throw new IllegalArgumentException("Padre ya tiene hijo izquierdo");
        else parentNode.left = new Node<>(data);
        
    }

    @Override
    public void insertRight(T parent, T data) {
        // TODO: Análogo a insertLeft pero para hijo derecho
        
        Node<T> parentNode = findNode(root, parent);
        
        if (parentNode == null) throw new IllegalArgumentException("Padre no encontrado");
        else if (parentNode.right != null) throw new IllegalArgumentException("Padre ya tiene hijo derecho");
        else parentNode.right = new Node<>(data);
        
    }

    @Override
    public List<T> inOrder() {
        // TODO: List<T> result = new ArrayList<>(); inOrderRec(root, result); return result;
        
        List<T> result = new ArrayList<>();
        inOrderRec(root, result);
        return result;
    }

    @Override
    public List<T> preOrder() {
        // TODO: Delega en preOrderRec
        
        List<T> result = new ArrayList<>();
        preOrderRec(root, result);
        return result;
        
    }

    @Override
    public List<T> postOrder() {
        // TODO: Delega en postOrderRec
        
        List<T> result = new ArrayList<>();
        postOrderRec(root, result);
        return result;
        
    }

    @Override
    public boolean contains(T data) {
        // TODO: return containsRec(root, data);
        return containsRec(root, data);
    }

    @Override
    public boolean isEmpty() {
        // TODO: return root == null;
        return root == null;
    }

    // ---- Métodos auxiliares recursivos PRIVADOS — TODO implementar ----

    /** Búsqueda recursiva. Base: null → null | data.equals → node. Recursivo: left luego right. */
    private Node<T> findNode(Node<T> node, T target) { //T x = target, NodoBinario<T> t = node
        // TODO: Implementa de forma recursiva
        
        if (node == null) return null;

        if(node.data.equals(target)){
            return node;
        }
        
        Node<T> aux = findNode(node.left, target);
        
        if (aux != null) return aux;
        else return findNode(node.right, target);
    }

    /** InOrden: left → visit → right. Base: node == null → return. */
    private void inOrderRec(Node<T> node, List<T> result) {
        // TODO: Implementa de forma recursiva
        
        if (node != null) {
            
            inOrderRec(node.left, result);
            result.add(node.data);
            inOrderRec(node.right, result);
            
        }
        
    }

    /** PreOrden: visit → left → right. Base: node == null → return. */
    private void preOrderRec(Node<T> node, List<T> result) {
        // TODO: Implementa de forma recursiva
        
        if (node != null) {
            
            result.add(node.data);
            preOrderRec(node.left, result);
            preOrderRec(node.right, result);
            
        }
    }

    /** PostOrden: left → right → visit. Base: node == null → return. */
    private void postOrderRec(Node<T> node, List<T> result) {
        // TODO: Implementa de forma recursiva
        
        if (node != null) {
            
            postOrderRec(node.left, result);
            postOrderRec(node.right, result);
            result.add(node.data);
            
        }
        
    }

    /** Existencia recursiva. Base: null → false | equals → true. Recursivo: left || right. */
    private boolean containsRec(Node<T> node, T target) {
        // TODO: Implementa de forma recursiva
        
        if  (node == null) return false;
        
        if (node.data.equals(target)) return true;
        
        boolean aux = containsRec(node.left, target);
        
        if (aux) return aux;
        else return containsRec(node.right, target);
        
    }
}
