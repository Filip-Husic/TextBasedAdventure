package player;

@SuppressWarnings("unused")
public class Wizard {
    String role = "Wizard";
    int hp = 60;
    int dmg = 8;
    int mana = 100;
    int defense = 1;

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
