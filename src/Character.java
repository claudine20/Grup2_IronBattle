import java.util.Random;

//Character
public abstract class Character {
    private String id;
    private String name;
    private int hp;
    private boolean isAlive = true;


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

    public boolean isAlive() {
        return isAlive;
    }


    // setters

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        //  check if negative, if negative set to 0 for display user experience
        if (hp < 0) {
            this.hp = 0;
        } else {
            this.hp = hp; //keeps original hp
        }

        if (this.hp <= 0) {
           this.isAlive = false; //if hp is less than 0 charactre is killed
        }
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }


    //Constructor that takes name and hp
    public Character(String name, int hp) {

        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        // Generate and ID between 1 and 9999
        Random random = new Random();
        int randomNum = 1 + random.nextInt(9999);

        this.id = String.format("%04d", randomNum);  // this bit makes numbers under 1000 possible

        this.name = name;
        this.hp = hp;

    }


    @Override
    public String toString() {
        return "Character{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", hp=" + hp +
                ", isAlive=" + isAlive + "}";
    }

    protected void takeDamage(int damage) {
    }
}