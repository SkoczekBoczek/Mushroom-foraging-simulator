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
        int choice = 1;
        try {
            choice = scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input, defaulting to Normal.");
            scanner.next();
        }

        ForestGenerationStrategy strategy;

        if (choice == 2) {
            strategy = new HardcoreForestStrategy();
        } else {
            strategy = new StandardForestStrategy();
        }

        Game game = new Game(10, 10, strategy);

        game.startGame();
    }
}
