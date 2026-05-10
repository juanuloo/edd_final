package ed.rdr2.model;

/**
 * Evento dinámico que ocurre en el mundo del juego.
 *
 * @author Daniel Palacios Alonso
 */
public class Event {

    private final EventType type;
    private final String description;

    /**
     * Construye un evento.
     *
     * @param type        tipo de evento
     * @param description descripción del evento
     */
    public Event(EventType type, String description) {
        this.type = type;
        this.description = description;
    }

    /** @return tipo de evento */
    public EventType getType() { return type; }

    /** @return descripción del evento */
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "[" + type + "] " + description;
    }
}
