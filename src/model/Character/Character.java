package model.Character;

import model.Monster.Monster;
import java.util.Random;

import java.util.concurrent.ThreadLocalRandom;

public class Character {
    private String classType;
    private String name;
    private int initiative;
    private int hp;
    private int attack;
    private int agility;
    private int coin;
    private int coinBag;
    private int goldJewelry;
    private int gemstone;
    private int treasureBox;
    private boolean firstHit = true;


    //Character constructor and all get and setters.



    public Character(String classType,String name, int initiative, int hp, int attack, int agility, int coin, int coinBag, int goldJewelry, int gemstone, int treasureBox) {
        this.classType = classType;
        this.name =name;
        this.initiative = initiative;
        this.hp = hp;
        this.attack = attack;
        this.agility = agility;
        this.coin = coin;
        this.coinBag = coinBag;
        this.goldJewelry = goldJewelry;
        this.gemstone = gemstone;
        this.treasureBox = treasureBox;
    }

    public Character() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void setCoinBag(int coinBag) {
        this.coinBag = coinBag;
    }

    public void setGoldJewelry(int goldJewelry) {
        this.goldJewelry = goldJewelry;
    }

    public void setGemstone(int gemstone) {
        this.gemstone = gemstone;
    }

    public void setTreasureBox(int treasureBox) {
        this.treasureBox = treasureBox;
    }

    public int getCoin() {
        return coin;
    }

    public void raiseCoin() {
        this.coin+=1;
    }

    public int getCoinBag() {
        return coinBag;
    }

    public void raiseCoinBag() {
        this.coinBag+=1;
    }

    public int getGoldJewelry() {
        return goldJewelry;
    }

    public void raiseGoldJewelry() {
        this.goldJewelry+=1;
    }

    public int getGemstone() {
        return gemstone;
    }

    public void raiseGemstone() {
        this.gemstone+=1;
    }

    public int getTreasureBox() {
        return treasureBox;
    }

    public void raiseTreasureBox() {
        this.treasureBox+=1;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public String getClassType() {
        return classType;
    }

    //Reglera om det ska vara det första slaget i en strid
    public void setFirstHit(boolean trueFalse){
        this.firstHit = trueFalse;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public void attackMonster(Monster monster){
        int attackDamage = 0;
        int monsterAgility = 0;
        for (int i = 1; i <= this.attack; i++){
            attackDamage = ThreadLocalRandom.current().nextInt(1, 6 + 1) + attackDamage;
        }
        for (int i = 1; i <= monster.getAgility(); i++){
            monsterAgility = ThreadLocalRandom.current().nextInt(1, 6 + 1) + monsterAgility ;
        }
        //bara development syfte för att se rollsen
        System.out.println("Your attack: " + attackDamage);
        System.out.println("Monster agility: " + monsterAgility);
        System.out.println(" ");

        if (attackDamage>monsterAgility){
            if(this.classType.equals("Thief")){
                int critChance = ThreadLocalRandom.current().nextInt(1,4);
                if(critChance == 1){
                    System.out.println("You crit the " + monster.getClassType());
                    monster.setHp(monster.getHp()- 2);
                }
            }
            else {
                System.out.println("You attack the " + monster.getClassType());

            }
        }
        else if (attackDamage < monsterAgility){
            System.out.println("Your attack missed! ");
        }
    }
    //Tar in ett monster objekt och använder dens attribut och funktioner
    public void defendAttack(Monster monster){
        int monsterAttackDamage = 0;
        int playerAgility = 0;
        //Rollar varje tärning och adderar det till den totala monster skadan
        for (int i = 1; i <=monster.getAttack(); i++){
            monsterAttackDamage = ThreadLocalRandom.current().nextInt(1, 6 + 1) + monsterAttackDamage;
        }
        for (int i = 1; i <= this.agility; i++){
            playerAgility  = ThreadLocalRandom.current().nextInt(1, 6 + 1) + playerAgility;
        }
        System.out.println(" ");
        if(monsterAttackDamage<playerAgility){
            System.out.println(monster.getClassType() + "s attack missed!");
        }
        else if(monsterAttackDamage>playerAgility){
            if(firstHit && this.classType.equals("Knight")){
                System.out.println("You block " + monster.getClassType() + " attack");
                firstHit = false;
            }
            else {
                System.out.println(monster.getClassType() + "s hit!");
                this.hp = this.hp - 1;
            }
        }
    }
    //Returnar true om spelaren kan fly och false om inte
    public boolean flee(){
        Random rand = new Random();
        if(rand.nextInt(100)<(this.agility*10)){
            return true;
        }
        else{
            return false;
        }
    }
}
