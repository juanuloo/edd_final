package ed.rdr2.model;

/**
 * Representa una misión de la banda en RDR2.
 *
 * @author Daniel Palacios Alonso
 */
public class Mission {

    private final String title;
    private final String description;
    private MissionStatus status;

    /**
     * Construye una misión.
     *
     * @param title       título de la misión
     * @param description descripción breve
     * @param status      estado inicial
     */
    public Mission(String title, String description, MissionStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    /** @return título de la misión */
    public String getTitle() { return title; }

    /** @return descripción de la misión */
    public String getDescription() { return description; }

    /** @return estado actual */
    public MissionStatus getStatus() { return status; }

    /** @param status nuevo estado */
    public void setStatus(MissionStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "[" + status + "] " + title + ": " + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mission m)) return false;
        return title.equals(m.title);
    }

    @Override
    public int hashCode() { return title.hashCode(); }
}
