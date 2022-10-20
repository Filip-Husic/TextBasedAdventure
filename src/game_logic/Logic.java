package game_logic;

import battle.Battle;
import chest.Chest;
import map.Map;
import map.SecondMap;
import monster.*;
import player.Player;


@SuppressWarnings("SwitchStatementWithoutDefaultBranch")
public class Logic {

    //LogicBoss logicBoss = new LogicBoss();

    public void playMap(Player player, double diff, Map map) throws InterruptedException {
        Monster boss = new Boss(diff);
        Chest chest = new Chest();
        Map secondMap = new SecondMap();

        map.showMap();

        do {
            map.move();
            if (map.isNearMonster()) { //TODO returning to monster position after defeating it starts a new encounter
                Battle battle = new Battle();
                if (map.getClass().getSimpleName().equalsIgnoreCase("secondmap")) {
                    battle.battleStart(player,boss);
                } else {
                    battle.battleStart(player, battle.randMonster(diff));
                }
                map.setMapCordToFloor();
            } else if (map.isNearChest()) {
                chest.randomStatUp(player);
                map.setMapCordToFloor();
            } else if (map.isNearExit()) {
                playMap(player, diff, secondMap);
                boss.setHp(0);
            }
        } while (player.getHp() > 0 && boss.getHp() > 0);
    }
}
