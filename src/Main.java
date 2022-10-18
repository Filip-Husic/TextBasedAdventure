import java.util.Scanner;

@SuppressWarnings({"BusyWait", "unused"})
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String strUserInput;
        String playerClass = "";

        Menu.welcomeText();
        do {
        Menu.mainMenu();
        strUserInput = scanner.nextLine();
        int playerHealth = 0;
        int playerDmg = 0;
        int playerArmor = 0;
        int healthPotion = 2;

        if (strUserInput.equals("2")){
            do {

                Menu.classChoice();
                strUserInput = scanner.nextLine();
                switch (strUserInput) {
                    case "1" -> {
                        playerClass = "warrior";
                        playerHealth = 10;
                        playerDmg = 2;
                        playerArmor = 2;
                        System.out.println("An excellent choice, what is your name mighty warrior?");
                        strUserInput = scanner.nextLine();
                        System.out.println("Splendid!" + " Enter the dungeon " + strUserInput + " and prove your worth!");
                    }
                    case "2" -> {
                        playerClass = "rogue";
                        playerHealth = 8;
                        playerDmg = 3;
                        playerArmor = 1;

                        System.out.println("An excellent choice, what is your name sneaky rogue?");
                        strUserInput = scanner.nextLine();
                        System.out.println("Splendid!" + " Enter the dungeon " + strUserInput + " and prove your worth!");
                    }

                    case "3" -> {
                        playerClass = "archer";
                        playerHealth = 6;
                        playerDmg = 4;
                        playerArmor = 1;

                        System.out.println("An excellent choice, what is your name agile archer?");
                        strUserInput = scanner.nextLine();
                        System.out.println("Splendid!" + " Enter the dungeon " + strUserInput + " and prove your worth!");
                    }

                    case "4" -> {
                        playerClass = "wizard";
                        playerHealth = 5;
                        playerDmg = 6;

                        System.out.println("An excellent choice, what is your name wise wizard?");
                        strUserInput = scanner.nextLine();
                        System.out.println("Splendid!" + " Enter the dungeon " + strUserInput + " and prove your worth!");
                    }
                    default -> System.out.println("Please select a valid class from 1-4");
                /*
                1. Warrior
                2. Rogue
                3. Archer
                4. Wizard
                 */

                }
            }while (playerClass.equals(""));
            System.out.print("You are entering the dungeon.");
            Thread.sleep(1000);
            System.out.print(".");
            Thread.sleep(1000);
            System.out.println(".");
            Thread.sleep(1000);
            System.out.println("In front of you there are 2 paths, will you take the left or the right path?");
            strUserInput = scanner.nextLine();
            if (strUserInput.equalsIgnoreCase("left")){
                System.out.println("You take the left path...");
                Thread.sleep(2000);
                System.out.println("Your way is blocked by a goblin! What do you do? (fight/flee)");
                Thread.sleep(1000);
                strUserInput = scanner.nextLine();
                if (strUserInput.equalsIgnoreCase("fight")){
                    System.out.println("You begin the fight!");
                    Thread.sleep(1000);
                    int goblinHealth = 3;
                    int goblinDmg = 2;
                    do {
                        Menu.fightMenu();
                        strUserInput = scanner.nextLine();
                        boolean isChoiceValid = false;

                        //noinspection ConstantConditions
                        do {

                        switch (strUserInput) {
                            case "1" -> {
                                System.out.printf("You attack the goblin for %d damage.\n",playerDmg);
                                goblinHealth -= playerDmg;
                                if (goblinHealth <= 0){
                                    System.out.println("The goblin dies from your mighty blow, you WIN!");
                                }else {
                                    System.out.printf("The goblin takes %d damage, but is still standing and getting ready to strike!\n", playerDmg);
                                    Thread.sleep(1000);
                                    System.out.printf("The goblin strikes you for %d damage!\nYou have %d armor.",goblinDmg, playerArmor);
                                    if (goblinDmg > playerArmor){
                                        playerHealth -= (goblinDmg - playerArmor);
                                        System.out.printf("You have %d health remaining.", playerHealth);
                                    }else {
                                        System.out.println("You take no damage!");
                                    }
                                }

                                isChoiceValid = true;
                            }
                            case "2" -> {
                                System.out.println("You prepare to defend yourself, armor x2");
                                Thread.sleep(1000);
                                System.out.printf("The goblin strikes you for %d damage!\nYou have %d armor.",goblinDmg, playerArmor*2);
                                isChoiceValid = true;
                            }
                            case "3" -> {
                                if (healthPotion > 0) {
                                    playerHealth += 5;
                                    healthPotion--;
                                    isChoiceValid = true;
                                } else {
                                    System.out.println("You're out of health potions!");
                                }

                            }
                        }

                        }while (!isChoiceValid && goblinHealth > 0);


                    }while (goblinHealth>0);

                }else if (strUserInput.equalsIgnoreCase("flee")){
                    System.out.println("You retreat back to the dungeon entrance.");
                }

            } else if (strUserInput.equalsIgnoreCase("right")) {
                System.out.println("TREASURE! You find a treasure chest. Do you open it? (y/n)");
                Thread.sleep(1000);
                strUserInput = scanner.nextLine();
                if (strUserInput.equalsIgnoreCase("y")){
                    System.out.println("It's a MIMIC! It bites your head off and you die, better luck next time.");
                }else if (strUserInput.equalsIgnoreCase("n")){
                    System.out.println("Smart choice, it's a mimic! What do you do? (Move on/Fight it)");
                }



            }


        }else if (strUserInput.equals("0")){
            System.out.println("Thanks for playing :)");
            break;
        }

        }while (true);

    }
}