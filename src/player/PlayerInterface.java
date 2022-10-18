package player;

import monsters.Monster;

@SuppressWarnings("unused")
public interface PlayerInterface {


    void attack(Monster monster);
    void defend(Monster monster);
    void specialMove(Monster monster);
    void flee();


}
