package monsters;

import player.Player;

@SuppressWarnings("unused")
public class Monster implements Monsters{

    private int hp;
    private int dmg;
    private int mana;
    private int defense;


    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void attack(Player player) {
        System.out.printf("Monster attacks for %d damage!\n", this.getDmg());
        if (player.getDefense() < this.getDmg()){
            player.setHp(player.getHp() - (this.getDmg() - player.getDefense()));
            System.out.printf("You take %d damage! (%d blocked)\n", (this.getDmg() - player.getDefense()), player.getDefense());
        }else {
            System.out.println("Your mighty defence negates all damage!");
        }
    }

}
