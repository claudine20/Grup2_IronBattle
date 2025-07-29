import java.util.Scanner;
import java.util.Random;

public class Warrior extends Character implements Attacker  {

    //private String name;
    //private int hp;
    private int stamina;
    private int strength;

    //Constructors
    public Warrior( String name, int hp, int stamina, int strength) {
        //super(value);
        //this.name = name;
        //this.hp = hp;
        super(name, hp);  // Calls Character constructor
        this.stamina = stamina;
        this.strength = strength;
    }
   //Getters and setters
    public int getStamina() {return stamina;}
    public int getStrength() {
        return strength;
    }


    public void setStamina(int stamina) {
        stamina = stamina;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }


    @Override
    // New start
    public void attack(Character opponent) {
        System.out.println(this.getName() + " is attacking " + opponent.getName());

        if (this.stamina >= 5) {
            // Heavy attack
            int damage = this.strength;
            opponent.setHp(opponent.getHp() - damage);
            this.stamina -= 5;
            System.out.println(this.getName() + " uses a Heavy attack for " + damage + " damage! Stamina now: " + this.stamina);
        } else if (this.stamina >= 1) {
            // Weak attack
            int damage = this.strength / 2;
            opponent.setHp(opponent.getHp() - damage);
            this.stamina += 1; // regain
            System.out.println(this.getName() + " uses a Weak attack for " + damage + " damage! Stamina now: " + this.stamina);
        } else {
            // Too tired
            this.stamina += 2; // rest and recover stamina
            System.out.println(this.getName() + " is too tired and recovers 2 stamina. Stamina now: " + this.stamina);
        }

        // If opponent HP falls below 0, mark as dead
        if (opponent.getHp() <= 0) {
            opponent.setIsAlive(false);
            System.out.println(opponent.getName() + " has been defeated!");
        }
    }

    @Override
    public void reset() {
        Random rand = new Random();  // Create a Random object

        // Reset health points to a value between 100 and 200
        this.setHp(rand.nextInt(101) + 100);

        // Reset stamina to a value between 10 and 50
        this.setStamina(rand.nextInt(41) + 10);

        // Reset strength to a value between 1 and 10
        this.setStrength(rand.nextInt(10) + 1);

        // Set the warrior as alive
        this.setIsAlive(true);
    }

}
