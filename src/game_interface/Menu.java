package game_interface;


import player.Player;

@SuppressWarnings("unused")
public class Menu {


    public void welcomeText() {
        System.out.println("Hello adventurer, welcome to the game.\nChoose your fate!");
    }

    public void mainMenu() {
        System.out.println("""                
                1. Start a new adventure
                0. Exit game
                """);
    }

    public void chooseDifficulty() {
        System.out.println("""
                Choose the difficulty for the game:
                1. Easy - monsters stats 50% lower
                2. Medium - monsters stats normal
                3. Hard - monsters stats 50% higher
                4. Insane - monsters stats 100% higher
                """);

    }

    public void roleChoice() {
        System.out.println("""
                Select a starting role:
                1. Warrior\t 100HP 10dmg 50mana 5defense skill: rage(x2 dmg 2 turns)
                2. Rogue\t 80HP 15dmg 60mana 3defense skill: backstab(x2 dmg attack)
                3. Archer\t 70HP 12dmg 40mana 2defense skill: shoot arrows(x2 attack)
                4. Wizard\t 60HP 8dmg 100mana 1defense skill: fireball(x2 dmg attack)
                """);

    }

        public void entrance () throws InterruptedException {
            System.out.print("You are entering the dungeon.");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            Thread.sleep(1000);
        }
        public static void fightMenu () {
            System.out.println("""
                    Choose your action:
                    1. Attack
                    2. Defend
                    3. Special
                    4. Drink health potion +50% maxHP
                    5. Drink mana potion +40% max mana
                    
                    """);
        }

        public void endGame (Player player) {
            if (player.getHp() <= 0) {
                System.out.println("You lose, better luck next time!");//if lost
            }//else if(boss.defeated){
            //System.out.println("Congratulation, you've won the game!");//if won
            //}
             }
    }
