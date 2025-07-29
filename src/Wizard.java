/**
 ==WIZARD:==
This class represents a Wizard character, specializing in magical spells.
*/
import java.util.Random;


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
    // New start
    public void attack(Character opponent) {
        System.out.println(this.getName() + " is attacking " + opponent.getName());

        if (this.mana >= 5) {
            // Fireball
            int damage = this.intelligence;
            opponent.setHp(opponent.getHp() - damage);
            this.mana -= 5;
            System.out.println(this.getName() + " casts Fireball for " + damage + " damage! Mana now: " + this.mana);
        } else if (this.mana >= 1) {
            // Staff hit
            //int damage = this.intelligence / 2;
            int damage = 2;
            opponent.setHp(opponent.getHp() - damage);
            this.mana += 1; // regain mana
            System.out.println(this.getName() + " hits with staff for " + damage + " damage! Mana now: " + this.mana);
        } else {
            // Not enough mana
            this.mana += 2; // rest and recover mana
            System.out.println(this.getName() + " is too exhausted and recovers 2 mana. Mana now: " + this.mana);
        }

        // If opponent HP falls below 0, mark as dead
        if (opponent.getHp() <= 0) {
            opponent.setIsAlive(false);
            System.out.println(opponent.getName() + " has been defeated!");
        }

    }

    @Override
    public void reset() {
        Random rand = new Random(); // Create Random object

        // Reset health points to a value between 50 and 100
        this.setHp(rand.nextInt(51) + 50);

        // Reset mana to a value between 10 and 50
        this.setMana(rand.nextInt(41) + 10);

        // Ensure the wizard is alive again
        this.setIsAlive(true);
    }


  }



