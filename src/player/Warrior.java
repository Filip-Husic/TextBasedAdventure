package player;

@SuppressWarnings("unused")
public class Warrior {
    String role = "Warrior";
    int hp = 100;
    int dmg = 10;
    int mana = 50;
    int defense = 5;

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


