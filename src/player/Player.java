package player;

import battle.Battle;

@SuppressWarnings("unused")
public class Player implements PlayerInterface {
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
    public void defend() {
        setDefense (getDefense() * 2);
    }

    public void drinkHealthPot() {
        if (this.getHp() < (this.getMaxHP() * 0.5)) {
            this.setHp((int) (this.getHp() + (this.getMaxHP() * 0.5)));
        } else this.setHp(this.getMaxHP());
        setHealthPot(getHealthPot() - 1);
    }

    public void drinkManaPot() {
        if (this.getMana() < (this.getMaxMana() * 0.6)) {
            this.setMana((int) (this.getMana() + (this.getMaxMana() * 0.4)));
        } else this.setMana(this.getMaxMana());
        setManaPot(getManaPot() - 1);
    }

    public String getStats() {
        return (getMaxHP() + "/" + getHp() + "HP " + getMaxMana() + "/" + getMana() + "MP " + getDefense() + "D");
    }

    @SuppressWarnings("ConstantConditions")
    public int multiCheck() {
        int tempRandom = (int) (Math.random() * 100);
        if (tempRandom <= 10) {
            return 2;
        } else if (tempRandom > 10 && tempRandom <= 35) {
            return 0;
        }
        return 1;
    }

    public int skill1() {//TODO
        switch (getClass().getSimpleName()) {
            case "Warrior" -> {
                rage();
            }
            case "Rogue" -> {
                shadowWalk();
            }
            case "Archer" -> {
                int totalAttack = rainOfArrows();
                Battle.appendTurnInfo("You send a volley of arrows for " + totalAttack + "dmg!");
                return totalAttack;
            }
            case "Wizard" -> {
                return 0;
            }
        }
        return 0;
    }

    public int skill2() {
        switch (getClass().getSimpleName()) {
            case "Warrior" -> {
                Battle.appendTurnInfo("Rage overwhelms you! " + getDmg() + " atk for rest of combat\n");
                return strongAttack();
            }
            case "Rogue" -> {
                Battle.appendTurnInfo("You hide in the shadow! Dodge 100% 3 turns\n");
                return backStab();
            }
            case "Archer" -> {
                return arrowToTheKnee();
            }
            case "Wizard" -> {
                return fireball();
            }
        }
        return 0;
    }

    public int strongAttack() {
        int tempRandom = (int) (Math.random() * 100);
        if (tempRandom <= 50) {
            return 0;
        }
        return getDmg() * 3;
    }

    public int backStab() {
        return getDmg() * 2;
    }

    public int arrowToTheKnee() {
        return getDmg() * 3;
    }

    public int fireball() {
        return getDmg() * 2;
    }
    public void rage() {
        setDmg(getDmg()*2);
//        return "Rage overwhelms you! " + getDmg() + " atk for rest of combat\n";
    }

    public String shadowWalk() {
        setDefense(999);
        Battle.setDefTime(3);
        return "You hide in the shadow! Dodge 100% 3 turns\n";
    }

    public int rainOfArrows() {
        int totalAttack = 0;
        for (int i = 0; i < 10; i++) {
            int tempRandom = (int) (Math.random() * 100);
            if (tempRandom >= 50) {
                totalAttack += attack();
            }
        }
        return totalAttack;
    }

    public String petrify() {

        return "";
    }
}
