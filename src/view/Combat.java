package view;

import model.Monster.Monster;
import model.Character.Character;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Combat {

    private int currentTurn;

    public void combatStart(Monster monster, Character character){
        Scanner scan = new Scanner(System.in);
        int playerInitiativeRoll = 0;
        int monsterInitiativeRoll = 0;

        for (int i = 1; i <=monster.getInitiative(); i++){
            monsterInitiativeRoll = ThreadLocalRandom.current().nextInt(1, 6 + 1) + monsterInitiativeRoll;
        }
        for (int i = 1; i<=character.getInitiative(); i++){
            playerInitiativeRoll = ThreadLocalRandom.current().nextInt(1,6+1) + playerInitiativeRoll;
        }

        System.out.println("You rolled... " + playerInitiativeRoll);
        System.out.println(monster.getClassType() + " rolled... " + monsterInitiativeRoll);

        if (playerInitiativeRoll > monsterInitiativeRoll){
            System.out.println("You go first! ");
            this.currentTurn = 1;
        }
        else {
            System.out.println(monster.getClassType() + " goes first! ");
            this.currentTurn = 0;
        }

        //Combat startas
        while(true){
            if (character.getHp() == 0){
                System.out.println("You died!");
                break;
            }
            if (monster.getHp() == 0){
                System.out.println(monster.getClassType() + " died!");
                break;
            }
            if (this.currentTurn==1){
                System.out.println("What do you want to do? ");
                System.out.println("(A)ttack, (F)lee");
                String playerChoice = scan.nextLine().toUpperCase();

                if(playerChoice.equals("A")){
                    character.attackMonster(monster);
                    this.currentTurn = 0;
                }
                else if(playerChoice.equals("F")) {
                    boolean flee = character.flee();
                    if (flee){
                        System.out.println("You fled! ");
                        break;
                    }
                    else{
                        System.out.println("You've failed your escape. ");
                        this.currentTurn = 0;
                    }

                }
            }
            else if (this.currentTurn == 0){
                character.defendAttack(monster);
                this.currentTurn = 1;
            }
        }

    }

}
