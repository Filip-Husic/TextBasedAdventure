package battle;

import game_interface.Menu;
import monster.*;
import player.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Battle {
    Player player;
    Monster monster;
    Scanner scanner = new Scanner(System.in);
    String userInput;
    StringBuilder turnInfo = new StringBuilder();


    public Monster randMonster(double diff){
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(new Bat(diff));
        monsters.add(new Rat(diff));
        monsters.add(new Goblin(diff));
        monsters.add(new Skeleton(diff));
        int random = new Random().nextInt(monsters.size());
        return monsters.get(random);
    }

    public void battleStart(Player player,Monster monster) {

        boolean hasWon;
        int defTime = 0;

        int startDef = player.getDefense();
        do {
            battleScreen(player, monster);
            turnInfo.delete(0, turnInfo.length());
            hasWon = false;

            if (player.getHp() <= 0) {
                turnInfo.append("You are defeated, better luck next time!\n");
                break;
            }
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> {
                    int playerAttack = player.attack();//player attack
                    if (monster.getDefense()>=playerAttack){
                        turnInfo.append("You do no damage to the monster, it's defense is too strong!");
                    } else {
                        monster.setHp(monster.getHp() - (playerAttack - monster.getDefense()));
                        turnInfo.append("You attack for ").append(playerAttack).append(" damage! ").append(monster.getDefense()).append(" blocked!\n");
                    }
                    if (monster.getHp() <= 0) {
                        turnInfo.append("You've defeated the ").append(monster.getClass().getSimpleName());
                        hasWon = true;
                    } else {
                        turnInfo.append(monster.getClass().getSimpleName()).append(" ").append(monster.getHp()).append("HP left\n");
                    }
                }
                case "2" -> {
                    player.setDefense(player.defend());
                    turnInfo.append("You prepare to defend.\n");
                    defTime = 3;
                }
                case "3" -> {
                    //add a special attack
                }
                case "4" -> {
                    if (player.getHealthPot() > 0) {
                        player.drinkHealthPot();
                        turnInfo.append("You drink a health potion and feel much better!");
                    } else {
                        turnInfo.append("You're out of health potions!");
                    }
                }
                case "5" -> {
                    if (player.getManaPot() > 0) {
                        player.drinkManaPot();
                        turnInfo.append("You drink a mana potion and feel more focused!");
                    } else {
                        turnInfo.append("You're out of mana potions!");
                    }
                }

            }
            int monsterAttack = monster.attack();
            if (player.getDefense()>=monsterAttack){
                turnInfo.append("Your mighty defence negates all damage!");
            } else {
            player.setHp(player.getHp() - (monsterAttack - player.getDefense()));//monster attacks last to make it a bit easier
            turnInfo.append("Monster attacks for ").append((monsterAttack - player.getDefense())).append(" damage! ").append(player.getDefense()).append(" blocked!");
            }
            defTime--;
            if (defTime == 0) {
                player.setDefense(startDef);
                turnInfo.append("Defense reset to ").append(startDef);
            }
        } while (!hasWon);
        player.setDefense(startDef);
    }



    public void battleScreen(Player player,Monster monster){


        System.out.printf("""
                #-----------------------------#
                \t\t\t\t%s
                \t\t\t\t\u0C06 %s
                
                
                %s
                
                  %s
                  \u0D9E %s
                #-----------------------------#
                """,
                //monster info
                monster.getClass().getSimpleName(),
                monster.getStats(),

                //battle-messages
                turnInfo,



                //player info
                player.getRole(),
                player.getStats());
        Menu.fightMenu();

    }


}
