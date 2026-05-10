package ed.rdr2.model;

/**
 * Localización del mapa de RDR2, representada como vértice del grafo.
 *
 * @author Daniel Palacios Alonso
 */
public class Location {

    private final String name;

    /**
     * Construye una localización.
     *
     * @param name nombre de la localización
     */
    public Location(String name) {
        this.name = name;
    }

    /** @return nombre de la localización */
    public String getName() { return name; }

    @Override
    public String toString() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location l)) return false;
        return name.equals(l.name);
    }

    @Override
    public int hashCode() { return name.hashCode(); }
}
