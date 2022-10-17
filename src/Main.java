import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intUserInput;

        Menu.welcomeText();
        do {
        Menu.mainMenu();
        intUserInput = scanner.nextInt();

        if (intUserInput == 0){
            System.out.println("Thanks for playing :)");
            break;
        }

        }while (true);

    }
}