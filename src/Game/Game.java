package Game;

public class Game {
    public Forest forest;
    public Player player;

    public void startGame() {
        System.out.println("Player: " + player.name + " stated a game");
        forest.displayForest();
    }

    public void checkWin() {
        System.out.println("Checking win conditions...");
    }

    
}
