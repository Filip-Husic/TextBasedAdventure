package monsters;

@SuppressWarnings("unused")
public class Boss extends Monster {
    public Boss(double diff) {
        this.setHp(100);
        this.setDmg((int) (10*diff));
        this.setMana(50);
        this.setDefense(5);
    }
}
