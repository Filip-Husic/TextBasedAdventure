package game_logic;

import chest.Chest;
import map.FirstMap;
import map.SecondMap;
import monsters.Boss;
import player.Player;

import java.util.Scanner;

public class LogicBoss {

    Scanner scanner = new Scanner(System.in);
    String userInput;
    SecondMap secondMap = new SecondMap();
    Chest chest = new Chest();

    public void playMap(Player player, int diff) {
        Boss boss = new Boss(diff);

        do {
            secondMap.showMap();
            secondMap.move();
            if (secondMap.isNearMonster()) {
                System.out.println("Fight"); //to do
            } else if (secondMap.isNearChest()) {
                chest.randomStatUp(player);
            }
        } while(player.getHp()>0 || boss.getHp() > 0);
    }

}
