package monsters;

@SuppressWarnings("unused")
public class Bat extends Monster{
    public Bat(double diff) {
        this.setHp(20);
        this.setDmg((int) (5*diff));
        this.setMana(0);
        this.setDefense(1);
    }
}
