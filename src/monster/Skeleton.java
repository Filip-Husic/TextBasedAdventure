package monster;

@SuppressWarnings("unused")
public class Skeleton extends Monster {
    public Skeleton(double diff) {
        this.setHp((int) (30*diff));
        this.setMaxHP((int) (30*diff));
        this.setDmg((int) (8*diff));
        this.setMana(0);
        this.setDefense((int) (2*diff));
    }
}