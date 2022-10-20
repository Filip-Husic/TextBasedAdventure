import battle.Battle;
import game_interface.Game;
import monster.Boss;
import monster.Monster;
import monster.Skeleton;
import player.Player;
import player.Rogue;
import player.Warrior;
import player.Wizard;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Game game = new Game();
//        game.intro();
        Player player = new Rogue();
        player.setName("Merlin");
        Monster monster = new Boss(1);
        Battle battle = new Battle();
        battle.battleStart(player, monster);

    }

}