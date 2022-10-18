package game_interface;

@SuppressWarnings("unused")
public class Menu {


    public static void welcomeText(){
        System.out.println("Hello adventurer, welcome to the game.\nChoose your fate!");
    }

    public void mainMenu(){
        System.out.println("""                
                1. Start a new adventure
                0. Exit game
                """);
    }

    public void chooseDifficulty(){

    }
    public void classChoice(){
        System.out.println("""
                Select a starting class:
                1. Warrior\t 100HP 10dmg 50mana 5defense skill: rage(x2 dmg 2 turns)
                2. Rogue\t 80HP 15dmg 60mana 3defense skill: backstab(x2 dmg attack)
                3. Archer\t 70HP 12dmg 40mana 2defense skill: shoot arrow(1 free attack)
                4. Wizard\t 60HP 8dmg 100mana 1defense skill: fireball(x2 dmg attack + dmg over time 2 turns)
                """);
    }
    public static void fightMenu(){
        System.out.println("""
                Choose your action:
                1. Attack
                2. Defend
                3. Special
                4. Drink health potion +5HP
                5. Flee
                """);
    }

    public static void endGame(){

    }
}
