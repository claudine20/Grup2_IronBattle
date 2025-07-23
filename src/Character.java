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



    // setters

//    public void setId(String id) {
//        this.id = id;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp; }

    public void setIsAlive(boolean isAlive) {
        this.isAlive = isAlive; }


//    public void setHp(int hp) {
//        //  check if negative, if negative set to 0 for display user experience
//        if (hp < 0) {
//            this.hp = 0;
//        } else {
//            this.hp = hp; //keeps original hp
//        }
//
//        if (this.hp <= 0) {
//           this.isAlive = false; //if hp is less than 0 charactre is killed
//        }
//    }

//    public void setAlive(boolean alive) {
//        isAlive = alive;
//    }






//    public Character(String name, int hp) {
//
//        if (name == null) {
//            throw new IllegalArgumentException("Name cannot be null");
//        }
//
//        // Generate and ID between 1 and 9999
//        Random random = new Random();
//        int randomNum = 1 + random.nextInt(9999);
//
//        this.id = String.format("%04d", randomNum);  // this bit makes numbers under 1000 possible
//
//        this.name = name;
//        this.hp = hp;
//
//    }


    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive + "}";
    }

//    protected void takeDamage(int damage) {
//        if (damage > 0) {
//            setHp(getHp() - damage);
//    }
//}

}