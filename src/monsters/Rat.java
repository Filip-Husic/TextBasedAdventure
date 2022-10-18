package monsters;

@SuppressWarnings("unused")
public class Rat extends Monster {
    public Rat(double diff) {
        this.setHp(15);
        this.setDmg((int) (4*diff));
        this.setMana(0);
        this.setDefense(1);
    }
}