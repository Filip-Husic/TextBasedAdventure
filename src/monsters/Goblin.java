package monsters;

@SuppressWarnings("unused")
public class Goblin extends Monster {
    public Goblin(double diff) {
        this.setHp(25);
        this.setDmg((int) (6*diff));
        this.setDefense(2);
        this.setMana(0);
    }
}