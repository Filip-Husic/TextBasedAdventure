package chest;

import player.Player;

public class Chest {

    private int count = 0;

    public void randomStatUp(Player player) {
        if (count <= 1) {
            int randomSpec = (int) (Math.random() * (4 - 1) + 1);
            int randomPotion = (int) (Math.random() * (2 - 1) + 1);
            count++;

            switch (randomSpec) {
                case 1 -> {
                    player.setMaxHP(player.getMaxHP() + 10);
                    System.out.println("\nYou receive +10 max HP, your max HP is: " + player.getHp());
                }
                case 2 -> {
                    player.setDmg(player.getDmg() + 2);
                    System.out.println("\nYou receive +2 max DMG, your max DMG is: " + player.getDmg());
                }
                case 3 -> {
                    player.setDefense(player.getDefense() + 2);
                    System.out.println("\nYou receive +2 max DEF, your max DEF is: " + player.getDefense());
                }
                case 4 -> {
                    player.setMaxMana(player.getMaxMana() + 10);
                    System.out.println("\nYou receive +10 max Mana, your max Mana is: " + player.getMana());
                }
            }

            switch (randomPotion) {
                case 1 -> {
                    player.setHealthPot(player.getHealthPot() + 1);
                    System.out.println("You receive +1 HP potion, your have " + player.getHealthPot() + " HP potions!");
                }
                case 2 -> {
                    player.setManaPot(player.getManaPot() + 1);
                    System.out.println("You receive +1 MP potion, your have " + player.getManaPot() + " MP potions!");
                }
            }
        } else {
            System.out.println("\nThis chest is empty now!");
        }
    }
}
