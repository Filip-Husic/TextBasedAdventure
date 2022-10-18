package game_interface;

import map.FirstMap;
import monsters.*;
import player.*;

import java.util.Scanner;

@SuppressWarnings("unused")
public class Game {
    Bat bat;
    Boss boss;
    Goblin goblin;
    Rat rat;
    Skeleton skeleton;
    Player player;

    FirstMap firstMap = new FirstMap();

    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    String userInput;


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
        userInput = scanner.nextLine();
        switch (userInput) {
            case "1" -> createMonsters(0.5);
            case "2" -> createMonsters(1);
            case "3" -> createMonsters(1.5);
        }
        menu.roleChoice();
        playerRoleSet();
        menu.entrance();
        firstMap.showMap();
        firstMap.move();



    }
    public void createMonsters(double diff){
        bat = new Bat(diff);
        boss = new Boss(diff);
        goblin = new Goblin(diff);
        rat = new Rat(diff);
        skeleton = new Skeleton(diff);
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
        }while (player == null);
    }
}



