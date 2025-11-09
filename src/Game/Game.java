package Game;

public class Game {
    public Forest forest;
    public Player player;
    public boolean isRunning = false;

    public void startGame() {
        System.out.println("Player: " + player.name + " stated a game");
        System.out.println("w - move up");
        System.out.println("a - move left");
        System.out.println("s - move down");
        System.out.println("d - move right");
        System.out.println("q - quit");

        playGame();
    }

    public void playGame() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        isRunning = true;

        while(isRunning){
            forest.displayForest();
            System.out.print("Enter command: ");
            String command = scanner.nextLine();

            int height = forest.getHeight();
            int width = forest.getWidth();

            switch(command) {
            case "w":
                player.move(-1, 0, height, width);
                break;
            case "a":
                player.move(0, -1, height, width);
                break;
            case "s":
                player.move(1, 0, height, width);
                break;
            case "d":
                player.move(0, 1, height, width);
                break;
            case "q":
                isRunning = false;
                System.out.println("Quitting game...");
                break;
            default:
                System.out.println("Invalid command.");
                break;
            }
            
        }
        scanner.close();
    }

    public void checkWin() {
        System.out.println("Checking win conditions...");
    }
}
