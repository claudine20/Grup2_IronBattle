import java.util.Scanner;

public class Warrior extends Character implements Attacker  {

    private String name;
    private int hp;
    private int Stamina;
    private int strength;

//Constructors
    public Warrior( String name, int hp, int stamina, int strength) {
        super(name,hp);
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
        int newHp = 0;
//        System.out.println(typeOfAttack);
        if (typeOfAttack==1&&Stamina>10){
//Heavy attack
            System.out.println(this.getName()+ " makes a heavy attack on "+opponent.getName());
            Stamina=getStamina()-5;
            newHp = opponent.getHp() - getStrength();
          

        }else if(Stamina<10){
            System.out.println(this.getName()+ " does not have the stamina to make an attack he will not inflict any damage and recover his stamina");
            Stamina=getStamina()+2;
           
        }
//        else if (this.hp==0) {
//            System.out.println(this.getName()+ " is not alive");
//
//        }
        else {
            //Weak attack
            System.out.println(this.getName()+ " makes a weak attack on "+opponent.getName());
            Stamina=getStamina()+1;
            newHp = opponent.getHp()- (getStrength()/2);
           
        }
        System.out.println(this.getName()+" stamina: "+Stamina);
        System.out.println(opponent.getName()+" hp: "+newHp);
        System.out.println(this.getName()+" strength: "+ strength);


    }
}
