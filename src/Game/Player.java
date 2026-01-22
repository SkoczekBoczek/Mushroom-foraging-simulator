package Game;

import mushrooms.Mushroom;

import java.util.List;
import java.util.ArrayList;

public class Player {
    private String name;
    private List <Mushroom> collectedMushrooms;
    private int score;
    private int positionX;
    private int positionY;

    public Player() {
        this.name = "Forager";
        this.collectedMushrooms = new ArrayList<>();
        this.score = 0;
        this.positionX = 0;
        this.positionY = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void move(int deltaX, int deltaY, int height, int width){
        int newX = this.positionX + deltaX;
        int newY = this.positionY + deltaY;
        if(newX >= 0 && newX < height && newY >= 0 && newY < width){
            this.positionX = newX;
            this.positionY = newY;
            System.out.println("");
            System.out.println(name + " moved to (" + positionX + ", " + positionY + ")");
        } else {
            System.out.println("Move out of bounds! Current position: (" + positionX + ", " + positionY + ")");
        }
    }
    
    public void pickMushroom(Mushroom mushroom){
        collectedMushrooms.add(mushroom);
        mushroom.consume(this);
        System.out.println(name + " picked a " + mushroom);

    }

    public void displayScore() {
        System.out.println(name + "'s current score: " + score);
    }

}
