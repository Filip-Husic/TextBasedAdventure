package map;

import java.util.Arrays;
import java.util.Scanner;

public class FirstFloor implements Map{

    private char[][] map = new char[21][26];
    private char floor = ' ';
    char player = '\u0D9E';
    int[] playerPosition = new int[2];

    public FirstFloor() {
        for (var e : map) {
            for (var z : e) {
                z = '\u0D04';
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
    public void move() {
        Scanner sc = new Scanner(System.in);
        String input = "A";

        do {
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
        } while (!input.equals("f"));
    }

    public boolean checkWall(int[] position) {
        if (map[position[0]][position[1]] == floor) {
            return false;
        }
        return true;
    }
}
