package chest;

import player.Player;

public class Chest {

    private int count = 0;

    public void randomStatUp(Player player) throws InterruptedException {
        if (count <= 1) {
            int randomSpec = (int) (Math.random() * (4 - 1) + 1);
            int randomPotion = (int) (Math.random() * (2 - 1) + 1);
            count++;

            switch (randomSpec) {
                case 1 -> {
                    player.setMaxHP(player.getMaxHP() + 20);
                    player.setHp(player.getHp() + 20);
                    System.out.println("\n\tYou receive +20 max HP, your max HP is: " + player.getHp());
                }
                case 2 -> {
                    player.setDmg(player.getDmg() + 5);
                    System.out.println("\n\tYou receive +5 max DMG, your max DMG is: " + player.getDmg());
                }
                case 3 -> {
                    player.setDefense(player.getDefense() + 5);
                    System.out.println("\n\tYou receive +5 max DEF, your max DEF is: " + player.getDefense());
                }
                case 4 -> {
                    player.setMaxMana(player.getMaxMana() + 20);
                    player.setMana(player.getMana() + 20);
                    System.out.println("\n\tYou receive +20 max Mana, your max Mana is: " + player.getMana());
                }
            }

            switch (randomPotion) {
                case 1 -> {
                    player.setHealthPot(player.getHealthPot() + 1);
                    System.out.println("\tYou receive +1 HP potion, your have " + player.getHealthPot() + " HP potions!");
                }
                case 2 -> {
                    player.setManaPot(player.getManaPot() + 1);
                    System.out.println("\tYou receive +1 MP potion, your have " + player.getManaPot() + " MP potions!");
                }
            }

            System.out.println("\tYour Java skillset +33 points!");
            Thread.sleep(2000);
        } else {
            System.out.println("\nThis chest is empty now!");
        }
    }
}
