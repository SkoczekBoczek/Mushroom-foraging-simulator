package Game;

public class Game {
    private Forest forest;
    private Player player;
    private boolean isRunning = false;

    public Game(int width, int height, ForestGenerationStrategy strategy) {
        this.player = new Player();
        this.forest = new Forest(width, height, this.player, strategy);
    }

    public void startGame() {
        System.out.println("Player: " + player.getName() + " started a game");
        System.out.println("w - move up");
        System.out.println("a - move left");
        System.out.println("s - move down");
        System.out.println("d - move right");
        System.out.println("f - finish mushroom collection");
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
                handleMove(-1, 0, height, width, scanner);
                break;
                case "a":
                handleMove(0, -1, height, width, scanner);
                break;
                case "s":
                handleMove(1, 0, height, width, scanner);
                break;
                case "d":
                handleMove(0, 1, height, width, scanner);
                break;
            case "q":
                isRunning = false;
                System.out.println("Your score: " + player.getScore());
                System.out.println("Quitting game...");
                break;
            case "f":
                finishGame();
                break;
            default:
                System.out.println("Invalid command.");
                break;
}   
        }
        scanner.close();
    }

    public void handleMove(int deltaX, int deltaY, int height, int width, java.util.Scanner scanner){
        int targetX = player.getPositionX() + deltaX;
        int targetY = player.getPositionY() + deltaY;

        if(targetX < 0 || targetX >= height || targetY < 0 || targetY >= width){
            System.out.println("Move out of bounds!");
            return;
        }

        mushrooms.Mushroom target = forest.getMushroom(targetX, targetY);
        if(target != null){
            System.out.println("There is a mushroom: " + target.getName());
            System.out.print("Pick it up? (y/n): ");
            String ans = scanner.nextLine().trim().toLowerCase();
            if(ans.equals("yes") || ans.equals("y")){
                player.move(deltaX, deltaY, height, width);
                player.pickMushroom(target);
                forest.removeMushroom(targetX, targetY);
                player.displayScore();
                    checkWin();
            }else{
                System.out.println("You decided not to pick it up. Staying at (" + player.getPositionX() + "," + player.getPositionY() + ").");
                return;
            }
        }else{
            player.move(deltaX, deltaY, height, width);
        }
    }

    public boolean checkWin() {
        if(!forest.hasAnyMushrooms()){
            System.out.println("");
            System.out.println("You collected all mushrooms. Game over!");
            System.out.println("Final score: " + player.getScore());
            isRunning = false;
            return true;    
        }
        return false;
    }

    public void finishGame() {
        isRunning = false;
        System.out.println("");
        System.out.println("Game finished by player. Final score: " + player.getScore());
    }
}
