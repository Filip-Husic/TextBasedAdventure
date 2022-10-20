package game_logic;

import battle.Battle;
import chest.Chest;
import map.FirstMap;
import map.Map;
import map.SecondMap;
import monster.Boss;
import monster.Monster;
import player.Player;


@SuppressWarnings("SwitchStatementWithoutDefaultBranch")
public class Logic {

    Map secondMap = new SecondMap();
    Chest chest = new Chest();
    //LogicBoss logicBoss = new LogicBoss();


    public void playMap(Player player, double diff, Map map) throws InterruptedException {
        Monster boss = new Boss(diff);
        map.showMap();

        do {
            map.move();
            if (map.isNearMonster()) { //TODO returning to monster position after defeating it starts a new encounter
                Battle battle = new Battle();
                if (map.getClass().getSimpleName().equals("secondMap")) {
                    battle.battleStart(player,boss);
                } else {
                    battle.battleStart(player, battle.randMonster(diff));
                    map.showMap();
                }
            } else if (map.isNearChest()) {
                chest.randomStatUp(player);
            } else if (map.isNearExit()) {
                playMap(player, diff, secondMap);
            }
        } while (player.getHp() > 0 && boss.getHp() > 0);
    }
}
