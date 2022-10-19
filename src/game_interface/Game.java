package game_interface;

import game_logic.Logic;
import player.*;

import java.util.Scanner;

@SuppressWarnings({"unused"})
public class Game {
    Player player;
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    String userInput;
    String tempDiff;

    Logic logic = new Logic();


    public void intro() throws InterruptedException {
        menu.welcomeText();
        do {
            menu.mainMenu();
            userInput = scanner.nextLine();
            switch (userInput){
                case "1" -> startGame();
                case "0" -> System.out.print("");
                default -> System.out.println("Enter a option from 0-1");
            }


        }while (!userInput.equals("0"));

    }
    public void startGame() throws InterruptedException {
        menu.chooseDifficulty();
        do {
            tempDiff = scanner.nextLine();
        } while (!(tempDiff.equals("1") || tempDiff.equals("2") || tempDiff.equals("3") || tempDiff.equals("4")));
        menu.roleChoice();
        playerRoleSet();
        menu.entrance();
        double diff = 0.0;
        switch (tempDiff){
            case "1" -> diff = 0.5;
            case "2" -> diff = 1;
            case "3" -> diff = 1.5;
            case "4" -> diff = 2;
        }
        logic.playMap(player, diff);
        menu.endGame(player);
    }

    public void playerRoleSet(){
        userInput = scanner.nextLine();
        do {
            switch (userInput) {
                case "1" -> {
                    player = new Warrior();

                    System.out.println("An excellent choice, what is your name mighty warrior?");
                    userInput = scanner.nextLine();
                    System.out.println("Splendid!" + " Enter the dungeon " + userInput + " and prove your worth!");
                }
                case "2" -> {
                    player = new Rogue();

                    System.out.println("An excellent choice, what is your name sneaky rogue?");
                    userInput = scanner.nextLine();
                    System.out.println("Splendid!" + " Enter the dungeon " + userInput + " and prove your worth!");
                }

                case "3" -> {
                    player = new Archer();

                    System.out.println("An excellent choice, what is your name agile archer?");
                    userInput = scanner.nextLine();
                    System.out.println("Splendid!" + " Enter the dungeon " + userInput + " and prove your worth!");
                }

                case "4" -> {
                    player = new Wizard();

                    System.out.println("An excellent choice, what is your name wise wizard?");
                    userInput = scanner.nextLine();
                    System.out.println("Splendid!" + " Enter the dungeon " + userInput + " and prove your worth!");
                }
                default -> System.out.println("Please select a valid role from 1-4");
            }
        } while (player == null);
    }
}



