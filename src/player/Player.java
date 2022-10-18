package player;

import monsters.Monster;

@SuppressWarnings("unused")
public class Player implements PlayerInterface{
    private String role;
    private int hp;
    private int dmg;
    private int mana;
    private int defense;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }
    @Override
    public void attack(Monster monster) {
        System.out.printf("You attack for %d damage!", this.getDmg());
        monster.setHp(monster.getHp() - (this.getDmg() - monster.getDefense()));
        System.out.printf("Monster took %d damage!", (this.getDmg() - monster.getDefense()));
    }

    @Override
    public void defend(Monster monster) {
        System.out.printf("Monster attacks for %d damage!", monster.getDmg());
        if (this.getDefense() < monster.getDmg()){
            this.setHp(this.getHp() - (monster.getDmg() - this.getDefense()));
            System.out.printf("You take %d damage! (%d blocked)", (monster.getDmg() - this.getDefense()), this.getDefense());
        }else {
            System.out.println("Your mighty defence negates all damage!");
        }


    }

    @Override
    public void specialMove(Monster monster) {

    }

    @Override
    public void flee() {

    }
}
