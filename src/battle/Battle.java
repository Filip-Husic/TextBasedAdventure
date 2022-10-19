package battle;

import game_interface.Menu;
import monster.*;
import player.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Battle {
    Player player;
    Monster monster;
    Scanner scanner = new Scanner(System.in);
    String userInput;
    static StringBuilder turnInfo = new StringBuilder();
    static int defTime;

    public static int getDefTime() {
        return defTime;
    }

    public static void appendTurnInfo(String string) {
        Battle.turnInfo.append(string);
    }

    public static void setDefTime(int defTime) {
        Battle.defTime = defTime;
    }

    public Monster randMonster(double diff){
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(new Bat(diff));
        monsters.add(new Rat(diff));
        monsters.add(new Goblin(diff));
        monsters.add(new Skeleton(diff));
        int random = new Random().nextInt(monsters.size());
        return monsters.get(random);
    }

    public void battleStart(Player player,Monster monster) throws InterruptedException {

        boolean hasWon;
        setDefTime(0);

        int startDef = player.getDefense();
        int startDmg = player.getDmg();

        turnInfo.append("\t\t\t  !!BATTLE START!!");

        do {
            battleScreen(player, monster);
            turnInfo.delete(0, turnInfo.length());

            boolean isValidChoice = false;

            if (player.getHp() <= 0) {
                break;
            }

            do {
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> {
                    isValidChoice = true;
                    int playerAttack = player.attack();//player attack
                    if (monster.getDefense() >= playerAttack) {
                        turnInfo.append("You do no damage to the monster!\n");
                    } else {
                        monster.setHp(monster.getHp() - (playerAttack - monster.getDefense()));
                        turnInfo.append("You attack for ").append(playerAttack).append(" damage! ").append(monster.getDefense()).append(" blocked!\n");
                    }
                }
                case "2" -> {
                    isValidChoice = true;
                    player.defend();
                    turnInfo.append("You prepare to defend.\n");
                    battleScreen(player, monster);
                    //noinspection BusyWait
                    Thread.sleep(2000);
                    turnInfo.delete(0, turnInfo.length());
                    defTime = 3;
                }
                case "3" -> {
                    if (player.getMana() >= 10) {
                        isValidChoice = true;
                        Menu.specialMove(player);
                        userInput = scanner.nextLine();
                        if (userInput.equals("1")) {//TODO
                            if (player.toString().equals("Archer") || player.toString().equals("Wizard")) {
                                monster.setHp(monster.getHp() - player.skill1());
                            } else {
                                player.skill1();
                            }
                        } else if (userInput.equals("2")) {
                            int skill2 = player.skill2();
                            monster.setHp(monster.getHp() - skill2);
                        }
                    } else {
                        turnInfo.append("You have insufficient mana!");
                        battleScreen(player, monster);
                        turnInfo.delete(0, turnInfo.length());
                    }
                }
                case "4" -> {
                    if (player.getHealthPot() > 0) {
                        player.drinkHealthPot();
                        turnInfo.append("You drink a health potion and feel much better!\n");
                    } else {
                        turnInfo.append("You're out of health potions!\n");
                    }
                    battleScreen(player, monster);
                    turnInfo.delete(0, turnInfo.length());
                }
                case "5" -> {
                    if (player.getManaPot() > 0) {
                        player.drinkManaPot();
                        turnInfo.append("You drink a mana potion and feel more focused!\n");
                    } else {
                        turnInfo.append("You're out of mana potions!\n");
                    }
                    battleScreen(player, monster);
                    turnInfo.delete(0, turnInfo.length());
                }
            }

            }while (!isValidChoice);
            if (monster.getHp() <= 0) {
                //noinspection UnnecessaryToStringCall
                System.out.printf("You've defeated the %s",monster.toString());
                //noinspection BusyWait
                Thread.sleep(1000);
                break;
            } else {
                //noinspection UnnecessaryToStringCall
                turnInfo.append(monster.toString()).append(" ").append(monster.getHp()).append("HP left\n");
            }

            int monsterAttack = monster.attack();
            if (player.getDefense()>=monsterAttack){
                turnInfo.append("Your take no damage!\n");
            } else {
            player.setHp(player.getHp() - (monsterAttack - player.getDefense()));//monster attacks last to make it a bit easier
            turnInfo.append("Monster attacks for ").append((monsterAttack - player.getDefense())).append(" damage! ").append(player.getDefense()).append(" blocked!\n");
            }
            if (player.getDefense()>startDef){

            if (defTime>0){
            defTime--;
            }else if (defTime == 0) {
                player.setDefense(startDef);
                turnInfo.append("Defense reset to ").append(startDef).append("\n");
            }
            }
        } while (true);
        turnInfo.delete(0, turnInfo.length());
        player.setDefense(startDef);
        player.setDmg(startDmg);
    }



    public void battleScreen(Player player,Monster monster){
        System.out.println();
        System.out.printf("""
                #----#----#----#----#----#----#----#----#----#
                \t\t\t\t\t\t%s
                \t\t\t\t\t\t\u0C06 %s
                
                
                %s
                
                
                  %s
                  \u0D9E %s
                #----#----#----#----#----#----#----#----#----#
                """,
                //monster info
                monster.getClass().getSimpleName(),
                monster.getStats(),

                //battle-messages
                turnInfo,

                //player info
                (player.getRole() + " " + player.getName()),
                player.getStats());
        Menu.fightMenu(player);

    }


}
