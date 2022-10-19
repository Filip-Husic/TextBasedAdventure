package game_logic;

import battle.Battle;
import chest.Chest;
import map.FirstMap;
import player.Player;


@SuppressWarnings("SwitchStatementWithoutDefaultBranch")
public class Logic {
    FirstMap firstMap = new FirstMap();
    Chest chest = new Chest();
    LogicBoss logicBoss = new LogicBoss();

    public void playMap(Player player, int diff) {

        do {
            firstMap.showMap();
            firstMap.move();
            if (firstMap.isNearMonster()) {// TODO returning to monster position after defeating it starts a new encounter
                System.out.println("Fight");
                Battle battle = new Battle();
                battle.battleStart(player,battle.randMonster(diff));
            } else if (firstMap.isNearChest()) {
                chest.randomStatUp(player);
            } else if (firstMap.isNearExit()) {
                logicBoss.playMap(player, diff);
            }
        } while (player.getHp() > 0 || firstMap.isNearExit());
    }
}
