/**
 * Attacker interface.
 * All characters that can attack must implement this.
 */
public interface Attacker {
    /**
     * Attack the given opponent.
     * @param opponent The character to attack.
     */
    void attack(Character opponent);
}
