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
    public int attack() {
        System.out.printf("You attack for %d damage!\n", this.getDmg());
        return this.getDmg();
    }

    @Override
    public int defend() {
        System.out.println("You prepare to defend.");
        return (this.defense*2);//add a temp raised def variable to player
    }

    @Override
    public int specialMove() {//add some special moves depending on class
        return 0;
    }

    @Override
    public void flee() {//return to map, regen monsterHP to full, player keeps damage

    }
}
