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
    private int maxHealth;
    private int maxMana;

    public Player() {
        int maxHP = hp;
    }

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

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
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

    public void drinkHealthPot(){
        if (this.getHp() < (this.maxHealth * 0.5)){
            this.setHp(this.getHp()+this.maxHealth /2);
        }else this.setHp(this.maxHealth);
        System.out.println("You drink a health potion and feel much better!");
    }
    public void drinkManaPot(){
        if (this.getMana() < (this.getMaxMana()*0.6)){
            this.setMana((int) (this.getMana()+this.maxMana*0.6));
        }else this.setMana(this.maxMana);
        System.out.println("You drink a mana potion and feel more focused!");
    }

    @Override
    public void flee() {//return to map, regen monsterHP to full, player keeps damage

    }

    public String getStats(){
        return (getHp()+"HP/"+getMana()+"MP/"+getDefense()+"D");
    }
}
