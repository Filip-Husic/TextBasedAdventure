public class Menu {


    public static void welcomeText(){
        System.out.println("Hello adventurer, welcome to the game.\nChoose your fate!");
    }

    public static void mainMenu(){
        System.out.println("""
                
                1. Start a new adventure
                0. Exit game
                """);
    }
    public static void classChoice(){
        System.out.println("""
                Select a starting class:
                1. Warrior\t 10HP 2dmg 2armor
                2. Rogue\t 8HP 3dmg 1armor
                3. Archer\t 6HP 4dmg 1armor
                4. Wizard\t 5HP 6dmg 0armor
                """);
    }
    public static void fightMenu(){
        System.out.println("""
                Choose your action:
                1. Attack
                2. Defend
                3. Drink health potion +5HP
                """);
    }
}
