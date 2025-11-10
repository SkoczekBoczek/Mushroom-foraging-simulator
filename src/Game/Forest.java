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
                if(player.positionX == i && player.positionY == j){
                    continue;
                }
                if (random.nextInt(10) < 1) {
                    if(!hasAdjacentMushroom(i, j)){
                        grid[i][j] = generateRandomMushroom();
                    }
                }
            }
        }
    }

    public boolean hasAdjacentMushroom(int x, int y){
        for(int dx=-1; dx <= 1; dx++){
            for(int dy=-1; dy <= 1; dy++){
                if(dx == 0 && dy == 0) continue;
                int nx = x-dx;
                int ny = y-dy;
                if(nx > 0 && nx < grid.length && ny > 0 && ny < grid[0].length){
                    if( grid[nx][ny] != null){
                        return true;
                    }
                }
            }
        }
        return false;
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

    public Mushroom getMushroom(int x, int y){
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            return grid[x][y];
        }
        return null;
    }
    
    public void removeMushroom(int x, int y){
        if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
            grid[x][y] = null;
        }

    }

}