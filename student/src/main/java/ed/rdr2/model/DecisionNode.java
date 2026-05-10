package ed.rdr2.model;

/**
 * Nodo del árbol binario de decisiones narrativas.
 * Cada nodo representa una elección posible; las ramas
 * izquierda y derecha son las consecuencias de esa elección.
 *
 * <p>Esta clase es el tipo de dato almacenado en {@code BinaryTree<String>};
 * la estructura del árbol la gestiona el TAD.</p>
 *
 * @author Daniel Palacios Alonso
 */
public class DecisionNode {

    private final String description;
    private DecisionNode left;
    private DecisionNode right;

    /**
     * Construye un nodo de decisión sin hijos.
     *
     * @param description texto de la decisión o consecuencia
     */
    public DecisionNode(String description) {
        this.description = description;
    }

    /** @return descripción de este nodo */
    public String getDescription() { return description; }

    /** @return hijo izquierdo (puede ser null) */
    public DecisionNode getLeft() { return left; }

    /** @param left hijo izquierdo */
    public void setLeft(DecisionNode left) { this.left = left; }

    /** @return hijo derecho (puede ser null) */
    public DecisionNode getRight() { return right; }

    /** @param right hijo derecho */
    public void setRight(DecisionNode right) { this.right = right; }

    @Override
    public String toString() { return description; }
}
