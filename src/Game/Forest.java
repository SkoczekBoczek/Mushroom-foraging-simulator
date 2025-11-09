package Game;

import mushrooms.EdibleMushroom;
import mushrooms.MedicinalMushroom;
import mushrooms.Mushroom;
import mushrooms.PoisonousMushroom;
import java.util.Random;


public class Forest {
    private Mushroom[][] grid;
    private Player player;
    private Random random = new Random();

    public int getHeight(){
        return grid.length;
    }

    public int getWidth(){
        return grid[0].length;
    }

    public Forest(int width, int height, Player player){
        this.grid = new Mushroom[width][height];
        this.player = player;
        placeMushroom();
    }

    public void placeMushroom(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (random.nextInt(10) < 1) {
                    grid[i][j] = generateRandomMushroom();
                }
            }
        }
    }

    public Mushroom generateRandomMushroom(){
        int type = random.nextInt(3);
        switch (type) {
            case 0: return new EdibleMushroom("Borowik", 10);
            case 1: return new PoisonousMushroom("Muchomor", -10);
            case 2: return new MedicinalMushroom("Lakówka", 5);
            default: return null;
        }
    }

    public void displayForest(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(player.positionX == i && player.positionY == j){
                    System.out.print(" P ");
                } else if(grid[i][j] != null){
                    System.out.print(" M ");
                } else {
                    System.out.print(" . ");
                }
            }
            System.out.println();
        }
    }
}