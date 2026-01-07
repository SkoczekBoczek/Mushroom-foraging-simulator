import Game.Game;
import Game.Player;
import Game.Forest;
import Game.ForestGenerationStrategy;
import Game.StandardForestStrategy;
import Game.HardcoreForestStrategy;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Mushroom Foraging Simulator!");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Choose a difficult level: ");
        System.out.println("1. Normal");
        System.out.println("2. Hardcore");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        ForestGenerationStrategy strategy;

        if (choice == 2) {
            strategy = new HardcoreForestStrategy();
        } else {
            strategy = new StandardForestStrategy();
        }

        Game game = new Game();
        game.player = new Player();
        game.forest = new Forest(10, 10, game.player, strategy);

        game.startGame();
    }
}
