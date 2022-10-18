package monsters;

import player.Player;

@SuppressWarnings("unused")
public interface Monsters {
    void attack(Player player);
    //monsters currently aren't smart enough to defend :D
    //void defend(Player player);

}
