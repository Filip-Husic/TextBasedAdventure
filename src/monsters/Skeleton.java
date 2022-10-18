package monsters;

@SuppressWarnings("unused")
public class Skeleton extends Monster {
    public Skeleton(double diff) {
        this.setHp(30);
        this.setDmg((int) (8*diff));
        this.setMana(0);
        this.setDefense(2);
    }
}