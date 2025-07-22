/**
 ==WIZARD:==
This class represents a Wizard character, specializing in magical spells.
*/


public class Wizard extends Character implements Attacker {

    //-- Properties --
    private int mana; //Used for spells
    private int intelligence; //Determine spell damage


    //-- Getters --

    public int getMana() {
        return mana;
    }

    public int getIntelligence() {
        return intelligence;
    }


    //-- Setters--

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


    //-- Constructors --

    public Wizard(String name, int hp, int mana, int intelligence) {
        super(name, hp); // Calls Character constructor

        this.mana = mana;
        this.intelligence = intelligence;
    }


    //-- Overrides --

    /**
     * Overrides the attack method from the Attacker interface.
     * Wizards perform either Fireball or Staff Hit attacks based on mana and randomness.
     */

    @Override
    //public void attack(Character target)
    public void attack(Character opponent) {

        int damage = 0;
        String attackType = "";
        int manaCost = 0;
        int manaRecovery = 0;

        // Determine spell type: 0 for Fireball, 1 for Staff Hit
        // Math.random() returns a double between 0.0 (inclusive) and 1.0 (exclusive)
        int spellChoice = (Math.random() < 0.5) ? 0 : 1;

        if (spellChoice == 0) { // Try Fireball
            if (mana >= 5) {
                attackType = "Fireball";
                damage = intelligence;
                manaCost = 5;
            } else { // Not enough mana for Fireball, default to Staff Hit
                attackType = "Staff Hit (due to low mana)";
                damage = 2;
                manaRecovery = 1;
            }
        } else { // Try Staff Hit
            if (mana >= 0) { // Staff hit always possible if mana >= 0
                attackType = "Staff Hit";
                damage = 2;
                manaRecovery = 1;
            }
        }

        // Final check for mana to perform any attack
        if (damage == 0 && mana < 0) { // If no damage was assigned and mana is negative
            attackType = "No Attack (recovering mana)";
            manaRecovery = 2;
            System.out.println(this.getName() + " has too little mana and cannot attack. Recovering mana.");
        } else if (damage > 0) {
            opponent.takeDamage(damage);
            System.out.println(this.getName() + " casts a " + attackType + " on " + opponent.getName() + ", dealing " + damage + " damage.");
            this.mana -= manaCost;
        }

        this.mana += manaRecovery; // Apply mana recovery

        if (this.mana < 0) {
            this.mana = 0;
        }
        System.out.println(this.getName() + "'s mana: " + this.getMana());
    }

    @Override
    public String toString() {
        return super.toString() + " (Mana: " + mana + ", Intelligence: " + intelligence + ")";
    }
}


