import Game.Game;
import Game.Player;
import Game.Forest;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Mushroom Foraging Simulator!");

        Game game = new Game();
        game.player = new Player();
        game.forest = new Forest(10, 10, game.player);

        game.startGame();
    }
}
