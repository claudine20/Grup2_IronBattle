import java.util.Scanner;

public class Warrior extends Character implements Atacker  {

    private String name;
    private int hp;
    private int Stamina;
    private int strength;

//Constructors
    public Warrior(char value, String name, int hp, int stamina, int strength) {
        super(value);
        this.name = name;
        this.hp = hp;
        this.Stamina = stamina;
        this.strength = strength;
    }
//Getters and setters
    public int getStamina() {
        return Stamina;
    }

    public void setStamina(int stamina) {
        Stamina = stamina;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    @Override
    public void attack(){

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void attack(Character opponent){
//        "What kind of attack you want to make? 1-Heavy attack, 2-Weak attack";
        int typeOfAttack= ((int) (Math.random()*2)+1);
        int newHp;
        System.out.println(typeOfAttack);
        if (typeOfAttack==1&&Stamina>10){
//Heavy attack
            Stamina=getStamina()-5;
            newHp = opponent.getHp() - getStrength();
            System.out.println(newHp);
            System.out.println(Stamina);

        }else if(Stamina<10){

            Stamina=getStamina()+2;
            System.out.println(Stamina);
        }else {
            //Weak attack
            Stamina=getStamina()+1;
            newHp = opponent.getHp()- (getStrength()/2);
            System.out.println(Stamina);
            System.out.println(newHp);
        }



    }
}
