package player;

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
    public void attack() {

    }

    @Override
    public void defend() {

    }

    @Override
    public void specialMove() {

    }

    @Override
    public void flee() {

    }
}
