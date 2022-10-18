package chest;

import map.Map;
import player.Player;

public class Chest {

    private int count = 0;

    public void randomStatUp(Player player) {
        if (count == 0) {
            int random = (int) (Math.random() * (4 - 1) + 1);
            count++;

            switch (random) {
                case 1 -> {
                    player.setHp(player.getHp() + 2);
                    System.out.println("You receive +2 max HP, your max HP is: " + player.getHp());
                }
                case 2 -> {
                    player.setDmg(player.getDmg() + 2);
                    System.out.println("You receive +2 max DMG, your max DMG is: " + player.getDmg());
                }
                case 3 -> {
                    player.setDefense(player.getDefense() + 2);
                    System.out.println("You receive +2 max DEF, your max DEF is: " + player.getDefense());
                }
                case 4 -> {
                    player.setMana(player.getMana() + 2);
                    System.out.println("You receive +2 max Mana, your max Mana is: " + player.getMana());
                }
            }
        } else {
            System.out.println("This chest is empty now!");
        }
    }
}
