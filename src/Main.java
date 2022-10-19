import battle.Battle;
import game_interface.Game;
import monster.Monster;
import monster.Skeleton;
import player.Player;
import player.Warrior;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Game game = new Game();
//        game.intro();
        Player player = new Warrior();
        player.setName("Merlin");
        Monster monster = new Skeleton(2);
        Battle battle = new Battle();
        battle.battleStart(player, monster);

    }

}