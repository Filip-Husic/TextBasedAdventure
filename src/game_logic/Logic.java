package game_logic;

import battle.Battle;
import chest.Chest;
import map.FirstMap;
import player.Player;


@SuppressWarnings("SwitchStatementWithoutDefaultBranch")
public class Logic {
    FirstMap firstMap = new FirstMap();
    Chest chest = new Chest();

    public void playMap(Player player, int diff) {

        do {
            firstMap.showMap();
            firstMap.move();
            if (firstMap.isNearMonster()) {// TODO returning to monster position after defeating it starts a new encounter
                System.out.println("Fight");
                Battle battle = new Battle();//TODO put battle stats inside battle-screen
                battle.battleStart(player,diff);


            } else if (firstMap.isNearChest()) {
                chest.randomStatUp(player);
            } else if (firstMap.isNearExit()) {
                System.out.println("Exit"); //to do
            }
        } while (player.getHp() > 0 || firstMap.isNearExit());
    }
}
