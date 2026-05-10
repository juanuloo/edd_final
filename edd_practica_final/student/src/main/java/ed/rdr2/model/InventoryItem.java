package ed.rdr2.model;

import java.util.Objects;

/**
 * Ítem del inventario de la banda. La igualdad se determina por nombre,
 * lo que permite al TAD Conjunto detectar duplicados correctamente.
 *
 * @author Daniel Palacios Alonso
 */
public class InventoryItem {

    private final String name;
    private final ItemCategory category;

    /**
     * Construye un ítem de inventario.
     *
     * @param name     nombre del ítem
     * @param category categoría del ítem
     */
    public InventoryItem(String name, ItemCategory category) {
        this.name = name;
        this.category = category;
    }

    /** @return nombre del ítem */
    public String getName() { return name; }

    /** @return categoría del ítem */
    public ItemCategory getCategory() { return category; }

    @Override
    public String toString() {
        return name + " (" + category + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventoryItem i)) return false;
        return Objects.equals(name, i.name);
    }

    @Override
    public int hashCode() { return Objects.hash(name); }
}
