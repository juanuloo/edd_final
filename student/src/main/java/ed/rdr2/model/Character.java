package ed.rdr2.model;

/**
 * Representa un personaje del universo RDR2.
 *
 * @author Daniel Palacios Alonso
 */
public class Character {

    private final String name;
    private final CharacterRole role;

    /**
     * Construye un personaje con nombre y rol.
     *
     * @param name nombre del personaje
     * @param role rol en la narrativa
     */
    public Character(String name, CharacterRole role) {
        this.name = name;
        this.role = role;
    }

    /** @return nombre del personaje */
    public String getName() { return name; }

    /** @return rol del personaje */
    public CharacterRole getRole() { return role; }

    @Override
    public String toString() {
        return name + " [" + role + "]";
    }
}
