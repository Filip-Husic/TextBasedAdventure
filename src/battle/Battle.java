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



    public ArrayList<Monster> genMonsters(int diff){
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(new Bat(diff));
        monsters.add(new Rat(diff));
        monsters.add(new Goblin(diff));
        monsters.add(new Skeleton(diff));

        return monsters;
    }

    public Monster randMonster(ArrayList<Monster>monsters){
        int random = new Random().nextInt(monsters.size());
        return monsters.get(random);
    }

    public void battleStart(Player player, int diff) {

        Monster monster = randMonster(genMonsters(diff));

        boolean hasWon;

        do {
            battleScreen(player, monster);
            turnInfo.delete(0,turnInfo.length());
            hasWon = false;
            if (player.getHp() <= 0) {
                turnInfo.append("You are defeated, better luck next time!\n");
                break;
            }
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> {
                    monster.setHp(monster.getHp() - player.attack());//player attack
                    turnInfo.append("You attack for ").append(player.getDmg()).append(" damage!\n");
                    if (monster.getHp() <= 0) {
                        turnInfo.append("You've defeated the ").append(monster.getClass().getSimpleName());
                        hasWon = true;
                    } else {
                        turnInfo.append(monster.getClass().getSimpleName()).append(" ").append(monster.getHp()).append("HP left\n");
                    }
                }
                case "2" -> {
                    player.defend();
                    turnInfo.append("You prepare to defend.\n");

                }
                case "3" -> {
                    //add a special attack
                }
                case "4" -> player.drinkHealthPot();
                case "5" -> player.drinkManaPot();
            }
            player.setHp(player.getHp() - monster.attack());//monster attacks last to make it a bit easier
            turnInfo.append("Monster attacks for ").append(monster.getDmg()).append(" damage!\n");
        } while (!hasWon);
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
