package monster;

@SuppressWarnings("unused")
public class Monster implements Monsters{

    private int hp;
    private int dmg;
    private int mana;
    private int defense;
    private int maxHP;
    private int maxMana;

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
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

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    @Override
    public int attack() {
        return this.getDmg();
    }
    public String getStats(){
        return (getMaxHP()+"/"+getHp()+"HP "+getMaxMana()+"/"+getMana()+"MP "+getDefense()+"D");
    }

}
