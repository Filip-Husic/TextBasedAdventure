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
            hasWon = false;
            player.setHp(player.getHp() - monster.attack());//monster attacks first for more difficulty
            if (player.getHp() <= 0) {
                System.out.println("You are defeated, better luck next time!");
                break;
            }
            battleScreen(player, monster);
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> {
                    monster.setHp(monster.getHp() - player.attack());
                    if (monster.getHp() <= 0) {
                        System.out.println("You've defeated the " + monster.getClass().getSimpleName());
                        hasWon = true;
                    } else {
                        System.out.println(monster.getClass().getSimpleName() + " " + monster.getHp() + "HP left");
                    }
                }
                case "2" -> player.defend();
                case "3" -> {
                    //add a special attack
                }
                case "4" -> player.drinkHealthPot();
                case "5" -> player.drinkManaPot();
            }

        } while (!hasWon);
    }



    public void battleScreen(Player player,Monster monster){


        System.out.printf("""
                #-----------------------------#
                \t\t\t\t%s
                \t\t\t\t\u0C06 %s
                
                
                
                
                  %s
                  \u0D9E %s
                #-----------------------------#
                """,monster.getClass().getSimpleName(),monster.getStats(),player.getRole(),player.getStats());
        Menu.fightMenu();

    }

}
