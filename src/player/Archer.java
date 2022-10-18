package player;

@SuppressWarnings("unused")
public class Archer {
    String role = "Archer";
    int hp = 70;
    int dmg = 12;
    int mana = 40;
    int defense = 2;

    public String getRole() {
        return role;
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
}
