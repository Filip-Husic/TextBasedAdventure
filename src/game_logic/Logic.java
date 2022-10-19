package game_logic;

import battle.Battle;
import chest.Chest;
import map.FirstMap;
import monsters.*;
import player.Player;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("SwitchStatementWithoutDefaultBranch")
public class Logic {
    Scanner scanner = new Scanner(System.in);
    String userInput;
    FirstMap firstMap = new FirstMap();
    Chest chest = new Chest();

    public void playMap(Player player, int diff) {
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(new Bat(diff));
        monsters.add(new Rat(diff));
        monsters.add(new Goblin(diff));
        Battle battle = new Battle();


        do {
            firstMap.showMap();
            firstMap.move();
            if (firstMap.isNearMonster()) {
                System.out.println("Fight"); //to do
                do {
                    player.setHp(player.getHp()-monsters.get(0).attack());//monster attacks first for more difficulty
                    battle.battleScreen(player,monsters.get(0));
                    userInput = scanner.nextLine();
                    switch (userInput){
                        case "1" -> {
                            monsters.get(0).setHp(monsters.get(0).getHp()-player.attack());
                            System.out.println(monsters.get(0).getHp() +"HP left");
                        }
                        case "2" -> player.defend();
                        case "3" ->{
                            //add a special attack
                        }
                        case "4" -> player.drinkHealthPot();
                        case "5" -> player.drinkManaPot();
                        case "6" ->{
                            //add flee mechanic
                        }
                    }
                    if (monsters.get(0).getHp() <= 0){
                        System.out.println("You've defeated the: " + monsters.get(0).getClass().getSimpleName());
                    } else if (player.getHp() <= 0) {
                        System.out.println("You are defeated, better luck next time!");
                    }

                }while (monsters.get(0).getHp() > 0 && player.getHp() > 0);
                monsters.remove(0);
            } else if (firstMap.isNearChest()) {
                chest.randomStatUp(player);
            } else if (firstMap.isNearExit()) {
                System.out.println("Exit"); //to do
            }
        } while (player.getHp() > 0 || firstMap.isNearExit());
    }
}
