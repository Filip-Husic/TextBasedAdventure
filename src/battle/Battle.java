package battle;

import game_interface.Menu;
import monsters.*;
import player.*;

@SuppressWarnings("unused")
public class Battle {

    public void battleScreen(Player player,Monster monster){


        System.out.printf("""
                #-----------------------------#
                \t\t\t\t%s
                \t\t\t\t\u0C06 %s
                
                  %s
                  \u0D9E %s
                #-----------------------------#
                """,monster.getClass().getSimpleName(),monster.getStats(),player.getRole(),player.getStats());
        Menu.fightMenu();
    }

}
