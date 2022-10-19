package game_interface;


import player.Player;

@SuppressWarnings("unused")
public class Menu {
    final String ANSI_RESET = "\u001B[0m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";

    public void welcomeText() {
        System.out.println(ANSI_GREEN +"                                                                                                                                                                                   ..                   \n" +
                "                                                                                                                                                                                   .. .                 \n" +
                "                                                                                                                                                                                   ..  ..               \n" +
                "                                                                                                                                                                                   ..  ..               \n" +
                "                                                                                                                                                                                   ..   ..              \n" +
                "                                                                                                                                                                                  ..   ..               \n" +
                "                                                                                                                                                                                 ..    ..               \n" +
                "                                                                                                                                                                                ..    .                 \n" +
                "                                                                                                                                                                              ... ...                   \n" +
                "                         .........                                                            ........         ..............            ....                                .....                      \n" +
                "                       ..............        .               .    .'              ..        ............     ................          .........        ..              .                               \n" +
                "                       ..            ..      .              ..    ....            ..     ..                  ..                     ..          ..      ....            .                               \n" +
                "                       ..              ..    .              ..    ..  .           ..    .                    ..                    ..             ..    ..  .           .                               \n" +
                "                       ..              ..    .              ..    ..   ..         ..   ..                    ..                   ..              ..    ..   ..         .                               \n" +
                "                       ..              ..    .              ..    ..     .        ..   ..                    ..                   ..              ..    ..     .        .                               \n" +
                "                       ..              ..    .              ..    ..      ..      ..   ..                    .'.......            ..              ..    ..      ..      .                               \n" +
                "                       ..              ..    .              ..    ..        .     ..   ..          ......    ..                   ..              ..    ..        .     .                               \n" +
                "                       ..              ..    .              ..    ..         ..   ..   ..               ..   ..                   ..              ..    ..         ..   .                               \n" +
                "                       ..             ..     .              ..    ..           .  ..    ..              ..   ..                     .            ..     ..           . ..                               \n" +
                "                       ..           ..       ..             ..    ..            ..'.      ..            .    ..                       .        ..       ..            ...                               \n" +
                "                        ............           .............      .              ..         ...........      .................          .......         .              ..                               \n" +
                "                                                                                                                                                                                                        \n" +
                "                                                                                                                                                                                                        \n" +
                "                                                                                                                                                                                                        \n" +
                "                                                                                                                                                                                                        \n" +
                "                                                                                                                                                                                                        \n" +
                "                                                                                                                                                                                                        \n" +
                "                                                                                                                                                                                                        \n" +
                "                                                                                                                                                                                                        \n" +
                "                                                                                                                                                                                                        \n" +
                "                                                                                                                                                                                                        \n" +
                "                                                                                                                                                                                                        \n" +
                "                                                                                                                                                                                                        \n" +
                "                                                                                                                                                                                                        \n" +
                "                                                                      ..'.       .''          '.           ..        .'.                                                                                \n" +
                "                                                             ........'c,',.....';:dd;.......'o0d. .........:l. .......;;..........                                                                      \n" +
                "                                                             ..    ,c::;co,    ,xOkolo,    'kNXKd;.     .,o0Kd;.    .,'':o:..   ..                                                                      \n" +
                "                                                              ...  .'...''.     ','....    .';,,,.       .,,,,'.     ....'..   ...                                                                      \n" +
                "                                                                ..                                                            ..                                                                        \n" +
                "                                                                ..                                                            .                                                                         \n" +
                "                                                                ..                                                           ..                                                                         \n" +
                "                                                                ..                            ..                              .                                                                         \n" +
                "                                                                ..                           ....                             .                                                                         \n" +
                "                                                                ..                         ..    ..                           .                                                                         \n" +
                "                                                                ..                        .        ..                         .                                                                         \n" +
                "                                                                ..                 .    ..           ..                       .                                                                         \n" +
                "                                                                ..                ',  ..               .  .,.                 .                                                                         \n" +
                "                                                                ..                ':..                  ..,;.                 .                                                                         \n" +
                "                                                                ..                .,.      ..'''..        ',                  .                                                                         \n" +
                "                                                                ..                ..     .............     .                  .                                                                         \n" +
                "                                                                ..                ..   .,.         ..''    .                  .                                                                         \n" +
                "                                                                ..                ..   ,'            .;.   .                  .                                                                         \n" +
                "                                                                ..                ..  .;.   .,,,''....;'   .                  .                                                                         \n" +
                "                                                                ..                ..   ',    ......'',;.   .                  .                                                                         \n" +
                "                                                                ..                ..    .'.  .     ..'.    .                  .                                                                         \n" +
                "                                                                ..                ..     ..'''..''...      .                  .                                                                         \n" +
                "                                                                ..                ..        ......         .                  .                                                                         \n" +
                "                                                                ..                ..  .,''''''''''''''''.  .                  .                                                                         \n" +
                "                                                                ..                ..  .,,,,,,,,,,,,,,,,,.  .                 ..                                                                         \n" +
                "         .           ..        ...'.        .'.          .,.    ..  .'           ';;. .,,,,,,,,,,,,,,,,,.            .,.     ..    .           .            .''.       .,'                              \n" +
                "  .....':c,.........,;;,.......;:;;;,......;ooc',;.......';:;'......,:,.........,,;;'',,,,,::;,,,;;,,,,'..     .......;;...........,'. ........,,. ........,c,',.....,;cxo;.......      .......         \n" +
                "      .cc,;:o:    .:l:::c,.   .:c::lo:.    :ddxolc.    ;l:;cc;.    ',.,::;.    ,c..,:c.    'c:;;;;.     ...   ..    .,'':c:'.   .,ll:,,'.    ,cl:,,,.    ,l::;lo.    ;kOxlol'    ..    ..    ..         \n" +
                "       .....'.     .......     ...''..     ...'...     .......      ......      ......      ......       ......      .......     .......     .......     .....'.     ..'....      ......      ...       \n" +
                "                                                                                                                                                                                                       " + ANSI_RESET);
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
                1. Warrior\t 100HP 10dmg 50mana 5defense skill: rage (10 mana x2 dmg 3 turns)
                2. Rogue\t 80HP 15dmg 60mana 3defense skill: backstab(10 mana x2 dmg attack)
                3. Archer\t 70HP 12dmg 40mana 2defense skill: incapacitate(10 mana stun 2 turns)
                4. Wizard\t 60HP 8dmg 100mana 1defense skill: fireball(10 mana x2 dmg attack, 2 turns x1 damage on start of turn)
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
            System.out.println("You lose, better luck next time!");
            System.out.println(ANSI_RED +"                              /`._      ,\n" +
                    "                             /     \\   / \\\n" +
                    "                             ) ,-==-> /\\/ \\\n" +
                    "                              )__\\\\/ // \\  |\n" +
                    "                             /  /' \\//   | |\n" +
                    "                            /  (  /|/    | /\n" +
                    "                           /     //|    /,'\n" +
                    "                          // /  (( )    '\n" +
                    "                         //     // \\    |\n" +
                    "                        //     (#) |\n" +
                    "                       /        )\\/ \\   '       ____\n" +
                    "                      /        /#/   )         /,.__\\__,,--=_,\n" +
                    "                     /         \\#\\  /)      __/ + \\____,--==<\n" +
                    "                     //gnv_____/#/_/'      (\\_\\__+/_,   ---<^\n" +
                    "                                                    '==--=='" + ANSI_RESET);
        }else {
            System.out.println(ANSI_YELLOW + "                                                                     \n" +
                    "            88                                                       \n" +
                    "            \"\"              ,d                                       \n" +
                    "                            88                                       \n" +
                    "8b       d8 88  ,adPPYba, MM88MMM ,adPPYba,  8b,dPPYba, 8b       d8  \n" +
                    "`8b     d8' 88 a8\"     \"\"   88   a8\"     \"8a 88P'   \"Y8 `8b     d8'  \n" +
                    " `8b   d8'  88 8b           88   8b       d8 88          `8b   d8'   \n" +
                    "  `8b,d8'   88 \"8a,   ,aa   88,  \"8a,   ,a8\" 88           `8b,d8'    \n" +
                    "    \"8\"     88  `\"Ybbd8\"'   \"Y888 `\"YbbdP\"'  88             Y88'     \n" +
                    "                                                            d8'      \n" +
                    "                                                           d8'       " + ANSI_RESET);
        }
    }
}
