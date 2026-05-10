package ed.rdr2.model;

/**
 * Estado de una misión en la simulación.
 *
 * @author Daniel Palacios Alonso
 */
public enum MissionStatus {
    /** Misión registrada pero no iniciada. */
    PENDING,
    /** Misión en curso. */
    ACTIVE,
    /** Misión superada con éxito. */
    COMPLETED,
    /** Misión fallida. */
    FAILED
}
