package monster;

public class ArrayLengthOutOfBounds extends Monster{
    public ArrayLengthOutOfBounds(double diff) {
        this.setHp((int) (30*diff));
        this.setMaxHP((int) (30*diff));
        this.setDmg((int) (10*diff));
        this.setMana(0);
        this.setDefense((int) (5*diff));
    }
}
