package player;

@SuppressWarnings("unused")
public class Rogue {
    String role = "Rogue";
    int hp = 80;
    int dmg = 15;
    int mana = 60;
    int defense = 3;

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
