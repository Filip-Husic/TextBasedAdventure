package player;

@SuppressWarnings("unused")
public class Player implements PlayerInterface{
    private String name;
    private String role;
    private int hp;
    private int dmg;
    private int mana;
    private int defense;
    private int healthPot = 2;
    private int manaPot = 2;
    private int maxHP;
    private int maxMana;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHealthPot() {
        return healthPot;
    }

    public void setHealthPot(int healthPot) {
        this.healthPot = healthPot;
    }

    public int getManaPot() {
        return manaPot;
    }

    public void setManaPot(int manaPot) {
        this.manaPot = manaPot;
    }

    @Override
    public int attack() {
        return this.getDmg() * multiCheck();
    }

    @Override
    public int defend() {
        return (this.defense*2);//add a temp raised def variable to player
    }

    @Override
    public int specialMove() {//add some special moves depending on class
        return 0;
    }

    public void drinkHealthPot(){
        if (this.getHp() < (this.maxHP * 0.5)){
            this.setHp(this.getHp()+this.maxHP /2);
        }else this.setHp(this.maxHP);
        System.out.println("You drink a health potion and feel much better!");
    }
    public void drinkManaPot(){
        if (this.getMana() < (this.getMaxMana()*0.6)){
            this.setMana((int) (this.getMana()+this.maxMana*0.6));
        }else this.setMana(this.maxMana);
        System.out.println("You drink a mana potion and feel more focused!");
    }

    public String getStats(){
        return (getMaxHP()+"/"+getHp()+"HP "+getMaxMana()+"/"+getMana()+"MP "+getDefense()+"D");
    }

    public int multiCheck() {
        int tempRandom = (int)(Math.random() * 100);
        if (tempRandom <= 10) {
            return 2;
        } else if (tempRandom > 10 && tempRandom <= 35) {
            return 0;
        }
        return 1;
    }
}
