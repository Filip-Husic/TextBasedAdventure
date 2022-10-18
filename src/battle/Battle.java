package battle;

import game_interface.Menu;
import monsters.*;
import player.*;

@SuppressWarnings("unused")
public class Battle {
    //private char[][] screen = new char[20][26];

    public void battleScreen(Player player,Monster monster){

        //[16:14] Matija Cvetan
        //dodaj 100HP/50M/5D

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
