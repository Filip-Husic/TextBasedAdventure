import battle.Battle;
import game_interface.Game;
import monster.Skeleton;
import player.*;


public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Game game = new Game();
//        game.intro();

        Player player = new Warrior();
        Skeleton skeleton = new Skeleton(2);
        Battle battle = new Battle();
        battle.battleStart(player,skeleton);

    }

}