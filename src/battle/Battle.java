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

        do {
            battleScreen(player, monster);
            turnInfo.delete(0, turnInfo.length());

            if (player.getHp() <= 0) {
                System.out.println("You are defeated, better luck next time!");
                //noinspection BusyWait
                Thread.sleep(1000);
                break;
            }
            userInput = scanner.nextLine();
            switch (userInput) {
                case "1" -> {
                    int playerAttack = player.attack();//player attack
                    if (monster.getDefense()>=playerAttack){
                        turnInfo.append("You do no damage to the monster!\n");
                    } else {
                        monster.setHp(monster.getHp() - (playerAttack - monster.getDefense()));
                        turnInfo.append("You attack for ").append(playerAttack).append(" damage! ").append(monster.getDefense()).append(" blocked!\n");
                    }
                }
                case "2" -> {
                    player.defend();
                    turnInfo.append("You prepare to defend.\n");
                    defTime = 3;
                }
                case "3" -> {
                    Menu.specialMove(player);
                    userInput = scanner.nextLine();
                    if (userInput.equals("1")){//TODO
                        if (player.getClass().getSimpleName().equals("Archer")){
                            monster.setHp(monster.getHp() - player.skill1());
                        }else player.skill1();

                    } else if (userInput.equals("2")) {
                        int skill2 = player.skill2();
                        monster.setHp(monster.getHp() - skill2);
                        turnInfo.append("Your skill does ").append(skill2).append(" damage!\n");
                    }

                }
                case "4" -> {
                    if (player.getHealthPot() > 0) {
                        player.drinkHealthPot();
                        turnInfo.append("You drink a health potion and feel much better!\n");
                    } else {
                        turnInfo.append("You're out of health potions!\n");
                    }
                }
                case "5" -> {
                    if (player.getManaPot() > 0) {
                        player.drinkManaPot();
                        turnInfo.append("You drink a mana potion and feel more focused!\n");
                    } else {
                        turnInfo.append("You're out of mana potions!\n");
                    }
                }

            }
            if (monster.getHp() <= 0) {
                System.out.printf("You've defeated the %s",monster.getClass().getSimpleName());
                //noinspection BusyWait
                Thread.sleep(1000);
                break;
            } else {
                turnInfo.append(monster.getClass().getSimpleName()).append(" ").append(monster.getHp()).append("HP left\n");
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
        player.setDefense(startDef);
        player.setDmg(startDmg);
    }



    public void battleScreen(Player player,Monster monster){


        System.out.printf("""
                #-----------------------------#
                \t\t\t\t%s
                \t\t\t\t\u0C06 %s
                
                
                %s
                
                  %s
                  \u0D9E %s
                #-----------------------------#
                """,
                //monster info
                monster.getClass().getSimpleName(),
                monster.getStats(),

                //battle-messages
                turnInfo,



                //player info
                player.getRole(),
                player.getStats());
        Menu.fightMenu();

    }


}
