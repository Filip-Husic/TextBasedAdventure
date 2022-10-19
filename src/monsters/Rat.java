package monsters;

@SuppressWarnings("unused")
public class Rat extends Monster {
    public Rat(double diff) {
        this.setHp((int) (15*diff));
        this.setMaxHP((int) (15*diff));
        this.setDmg((int) (4*diff));
        this.setMana(0);
        this.setDefense((int) (2*diff));
    }
}