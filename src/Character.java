import java.util.Random;
import java.util.UUID;

//Character
public abstract class Character {
    private String id; //  Auto-generated
    private String name; // Fighter name
    private int hp; // Health Points
    private boolean isAlive; // false by default



    //Constructor that takes name and hp

    public Character(String name, int hp) {
        // UUID stands for Universally Unique Identifier. UUID.randomUUID() generates a random, unique 128-bit value; .toString() converts that UUID to a String
        this.id = UUID.randomUUID().toString();;
        this.name = name;
        this.hp = hp;
        this.isAlive = true;
    }

    //getters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public boolean getIsAlive() {
        return isAlive;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp; }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive; }



    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive + "}";
    }

    public abstract void reset(); { // Force subclasses to define it
        Random rand = new Random();
    }

}