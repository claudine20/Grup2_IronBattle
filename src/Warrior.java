import java.util.Scanner;

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
    // New END

//    public void attack(Character opponent){
////        "What kind of attack you want to make? 1-Heavy attack, 2-Weak attack";
//        int typeOfAttack= ((int) (Math.random()*2)+1);
//        int newHp = 0;
////        System.out.println(typeOfAttack);
//        if (typeOfAttack==1&&Stamina>10){
////Heavy attack
//            System.out.println(this.getName()+ " makes a heavy attack on "+opponent.getName());
//            Stamina=getStamina()-5;
//            //newHp = opponent.getHp() - getStrength();
//            opponent.takeDamage(getStrength());  // esto
//
//
//        }else if(Stamina<10){
//            System.out.println(this.getName()+ " does not have the stamina to make an attack he will not inflict any damage and recover his stamina");
//            Stamina=getStamina()+2;
//
//        }
//
//        else {
//            //Weak attack
//            System.out.println(this.getName()+ " makes a weak attack on "+opponent.getName());
//            Stamina=getStamina()+1;
//            newHp = opponent.getHp()- (getStrength()/2);
//
//        }
//        System.out.println(this.getName()+" stamina: "+Stamina);
//        //System.out.println(opponent.getName()+" hp: "+newHp);
//        //System.out.println(this.getName()+" strength: "+ strength);
//
//
//    }
}
