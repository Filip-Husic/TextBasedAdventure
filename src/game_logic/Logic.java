package game_logic;

import chest.Chest;
import map.FirstMap;
import monsters.Bat;
import monsters.Goblin;
import monsters.Monster;
import monsters.Rat;
import player.Player;

public class Logic {

    FirstMap firstMap = new FirstMap();
    Chest chest = new Chest();

    public void playMap(Player player, int diff) {
        Bat bat = new Bat(diff);
        Goblin goblin = new Goblin(diff);
        Rat rat = new Rat(diff);

        do {
            firstMap.showMap();
            firstMap.move();
            if (firstMap.isNearMonster()) {
                System.out.println("Fight"); //to do
            } else if (firstMap.isNearChest()) {
                chest.randomStatUp(player);
            } else if (firstMap.isNearExit()) {
                System.out.println("Exit"); //to do
            }
        } while (player.getHp() > 0 || firstMap.isNearExit());
    }
}
