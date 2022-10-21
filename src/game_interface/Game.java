package game_interface;

import battle.Battle;
import game_logic.Logic;
import map.FirstMap;
import map.Map;
import player.*;

import java.util.Scanner;

@SuppressWarnings({"unused"})
public class Game {
    private Player player;
    private final Scanner scanner = new Scanner(System.in);
    private final Menu menu = new Menu();
    private String userInput;
    private boolean isEndGame = false;
    private double diff = 0.0;
    private final Logic logic = new Logic();




    public void intro() throws InterruptedException {
        menu.welcomeText();
        boolean isOn = true;
        int exitCount = 0;

        do {
            if (isEndGame){
                System.out.println("Do you dare try again, perhaps on higher difficulty?");
            }
            menu.mainMenu();
            userInput = scanner.nextLine();
            switch (userInput){
                case "1" -> startGame();
                case "2" -> oneFight();
                case "3" -> survivalMode();
                case "0" -> {
                    if (isEndGame){
                        isOn = false;
                    }else {

                        if (exitCount == 0) {
                            System.out.print("ERROR, you must play the game!");
                        } else if (exitCount == 1) {
                            System.out.println("Play the game!");
                        } else if (exitCount == 2) {
                            System.out.println("I won't quit!");
                        } else if (exitCount == 3) {
                            System.out.print("Okay, quitting game.");
                            Thread.sleep(1000);
                            System.out.print(".");
                            Thread.sleep(1000);
                            System.out.print(".");
                            isOn = false;
                        }
                        exitCount++;
                    }
                }
                default -> System.out.println("Enter a option from 0-3");
            }
        } while (isOn);

    }
    public void startGame() throws InterruptedException {
        Map firstMap = new FirstMap();
        menu.chooseDifficulty();
        String tempDiff;
        do {
            tempDiff = scanner.nextLine();
        } while (!(tempDiff.equals("1") || tempDiff.equals("2") || tempDiff.equals("3") || tempDiff.equals("4")));
        menu.roleChoice();
        playerRoleSet();
        menu.entrance();
        switch (tempDiff){
            case "1" -> diff = 0.5;
            case "2" -> diff = 1;
            case "3" -> diff = 1.5;
            case "4" -> diff = 2;
        }
        logic.playMap(player, diff, firstMap);
        menu.endGame(player);
        isEndGame = true;
    }
    public void oneFight() throws InterruptedException {
        Battle battle = new Battle();
        menu.chooseDifficulty();
        String tempDiff;
        do {
            tempDiff = scanner.nextLine();
        } while (!(tempDiff.equals("1") || tempDiff.equals("2") || tempDiff.equals("3") || tempDiff.equals("4")));
        menu.roleChoice();
        playerRoleSet();
        menu.entrance();
        switch (tempDiff){
            case "1" -> diff = 0.5;
            case "2" -> diff = 1;
            case "3" -> diff = 1.5;
            case "4" -> diff = 2;
        }
        battle.battleStart(player, battle.randMonster(diff));
        menu.endGame(player);
        isEndGame = true;
    }
    @SuppressWarnings("BusyWait")
    public void survivalMode() throws InterruptedException {
        int battlesWon = 0;
        Battle battle = new Battle();
        menu.roleChoice();
        playerRoleSet();
        diff = 1;
        //endless fights until player dies, each turn 50% harder than the one before
        do {
        battle.battleStart(player, battle.randMonster(diff));
        if (player.getHp()>0) {
            diff*=1.5;
            battlesWon++;
            System.out.println("Increasing difficulty by 50%");
            Thread.sleep(1000);
        }
        }while (player.getHp()>0);

        menu.endGame(player);
        if (battlesWon == 0){
            System.out.println("How did you manage to lose on the first battle? GIT GUD!");
        } else if (battlesWon>0 && battlesWon<5) {
            System.out.println("You managed to defeat " + battlesWon + " monsters, you can do better!");
        } else if (battlesWon>5 && battlesWon<10) {
            System.out.println("You managed to defeat " + battlesWon + " monsters, not bad!");
        } else if (battlesWon>10 && battlesWon<15) {
            System.out.println("You managed to defeat " + battlesWon + " monsters, good!");
        } else if (battlesWon>15 && battlesWon<20) {
            System.out.println("You managed to defeat " + battlesWon + " monsters, great!");
        } else if (battlesWon>20 && battlesWon<25) {
            System.out.println("You managed to defeat " + battlesWon + " monsters, excellent!");
        }else {
            System.out.println("You managed to defeat " + battlesWon + " monsters, you are better at the game than the dev!");
        }
        isEndGame = true;
    }

    public void playerRoleSet(){
        do {
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> {
                    player = new Warrior();
                    player.setName(menu.askName("warrior"));
                }
                case "2" -> {
                    player = new Rogue();
                    player.setName(menu.askName("rogue"));
                }
                case "3" -> {
                    player = new Archer();
                    player.setName(menu.askName("archer"));
                }
                case "4" -> {
                    player = new Wizard();
                    player.setName(menu.askName("wizard"));
                }
                default -> System.out.println("Please select a valid role from 1-4");
            }
        } while (player == null);
    }
}



