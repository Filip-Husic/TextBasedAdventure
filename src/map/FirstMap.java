package map;

import java.util.Arrays;
import java.util.Scanner;

public class FirstMap implements Map{

    private char[][] map = new char[21][26];
    private char floor = ' ';
    char player = '\u0D9E'; //ඞ
    char monster1 = '\u0C06'; //ఆ
    char monster2 = '\u0C24'; //త
    char monster3 = '\u0C21'; //డ
    int[] playerPosition = new int[2];
    int[] monsterPosition1 = new int[2];
    int[] monsterPosition2 = new int[2];
    int[] monsterPosition3 = new int[2];
    int[] chestPosition1 = new int[2];
    int[] chestPosition2 = new int[2];
    int[] exitPosition1 = new int[2];
    int[] exitPosition2 = new int[2];
    char chest = '\u00A9'; //©
    char exitChar = '\u019C'; //Ɯ
    char wall = '\u0D04';


    public FirstMap() {
        for (var e : map) {
            for (var z : e) {
                z = wall;
            }
        }
        for (int i = 1; i <= 19; i++) {
            map[i][2] = floor;
            map[i][3] = floor;
            map[i][6] = floor;
            map[i][7] = floor;
        }
        for (int i = 8; i <= 24; i++) {
            map[18][i] = floor;
            map[19][i] = floor;
        }

        for (int i = 3; i <= 4; i++){
            map[i][4] = floor;
            map[i][5] = floor;
        }

        for (int i = 13; i <= 14; i++){
            map[i][4] = floor;
            map[i][5] = floor;
        }

        for (int i = 4; i <= 17; i++) {
            map[i][23] = floor;
            map[i][24] = floor;
        }

        for (int i = 10; i <= 22; i++) {
            map[13][i] = floor;
            map[14][i] = floor;
        }
        for (int i = 4; i <= 5; i++){
            map[i][21] = floor;
            map[i][22] = floor;
        }
        for (int i = 3; i <= 12; i++){
            map[i][10] = floor;
            map[i][11] = floor;
        }
        for (int i = 3; i <= 4; i++){
            map[i][12] = floor;
            map[i][13] = floor;
        }
        for (int i = 3; i <= 9; i++){
            map[i][14] = floor;
            map[i][15] = floor;
        }
        for (int i = 16; i <= 18; i++){
            map[8][i] = floor;
            map[9][i] = floor;
        }
        for (int i = 1; i <= 7; i++){
            map[i][17] = floor;
            map[i][18] = floor;
        }
        for (int i = 19; i <= 24; i++){
            map[1][i] = floor;
            map[2][i] = floor;
        }

        setPlayerOnMap();
        setMonsterOnMap();
        setChestOnMap();
        setExitPoint();
    }

    public void showMap() {
        for (var e : map) {
            System.out.println();
            for (var z : e) {
                System.out.print(z + "  ");
            }
        }
        System.out.println();
    }

    @Override
    public void setPlayerOnMap() {
        map[19][2] = player;
        playerPosition[0] = 19;
        playerPosition[1] = 2;
    }

    @Override
    public void setMonsterOnMap() {
        map[3][5] = monster1;
        monsterPosition1[0] = 3;
        monsterPosition1[1] = 5;
        map[16][23] = monster2;
        monsterPosition2[0] = 16;
        monsterPosition2[1] = 23;
        map[7][17] = monster3;
        monsterPosition3[0] = 7;
        monsterPosition3[1] = 17;
    }

    @Override
    public void setChestOnMap() {
        map[1][6] = chest;
        chestPosition1[0] = 1;
        chestPosition1[1] = 6;
        map[4][21] = chest;
        chestPosition2[0] = 4;
        chestPosition2[1] = 21;
    }

    public void setExitPoint() {
        map[1][24] = exitChar;
        exitPosition1[0] = 1;
        exitPosition1[1] = 24;
        map[2][24] = exitChar;
        exitPosition2[0] = 2;
        exitPosition2[1] = 24;
    }
    @Override
    public void move() {
        Scanner sc = new Scanner(System.in);
        String input = "A";

            input = sc.nextLine();

            switch (input) {
                case "w" :
                    if (!checkWall(new int[]{playerPosition[0] - 1, playerPosition[1]})) {
                        map[playerPosition[0]][playerPosition[1]] = floor;
                        playerPosition[0] -= 1;
                        map[playerPosition[0]][playerPosition[1]] = player;
                    }
                    break;
                case "s" :
                    if (!checkWall(new int[]{playerPosition[0] + 1, playerPosition[1]})) {
                        map[playerPosition[0]][playerPosition[1]] = floor;
                        playerPosition[0] += 1;
                        map[playerPosition[0]][playerPosition[1]] = player;
                    }
                    break;
                case "d" :
                    if (!checkWall(new int[]{playerPosition[0], playerPosition[1] + 1})) {
                        map[playerPosition[0]][playerPosition[1]] = floor;
                        playerPosition[1] += 1;
                        map[playerPosition[0]][playerPosition[1]] = player;
                    }
                    break;
                case "a" :
                    if (!checkWall(new int[]{playerPosition[0], playerPosition[1] - 1})) {
                        map[playerPosition[0]][playerPosition[1]] = floor;
                        playerPosition[1] -= 1;
                        map[playerPosition[0]][playerPosition[1]] = player;
                }
                    break;
                default :
                    break;
            }
            showMap();
    }

    public boolean checkWall(int[] position) {
        return map[position[0]][position[1]] != floor &&
                map[position[0]][position[1]] != monster1 &&
                map[position[0]][position[1]] != monster2 &&
                map[position[0]][position[1]] != monster3 &&
                map[position[0]][position[1]] != chest;
    }

    public void setMapCordToFloor(int a, int b) {
        map[a][b] = floor;
    }

    public boolean isNearMonster() {
        return Arrays.equals(playerPosition, monsterPosition1) ||
                Arrays.equals(playerPosition, monsterPosition2) ||
                Arrays.equals(playerPosition, monsterPosition3);
    }

    public boolean isNearChest() {
         return Arrays.equals(playerPosition, chestPosition1) ||
                 Arrays.equals(playerPosition, chestPosition2);
    }

    public boolean isNearExit() {
        return Arrays.equals(playerPosition, exitPosition1) ||
                Arrays.equals(playerPosition, exitPosition2);
    }
}
