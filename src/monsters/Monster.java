package monsters;

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
    public int attack() {
        System.out.printf("Monster attacks for %d damage!\n", this.getDmg());
        return this.getDmg();
    }

}
