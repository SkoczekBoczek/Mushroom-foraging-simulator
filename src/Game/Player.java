package Game;

import mushrooms.Mushroom;

import java.util.List;

public class Player {
    public String name;
    public List <Mushroom> collectedMushrooms;
    public int score;
    public int positionX;
    public int positionY;

    public Player() {
        this.name = "Forager";
        this.collectedMushrooms = new java.util.ArrayList<>();
        this.score = 0;
        this.positionX = 0;
        this.positionY = 0;
    }

    public void move(int deltaX, int deltaY, int height, int width){
        int newX = this.positionX + deltaX;
        int newY = this.positionY + deltaY;
        if(newX >= 0 && newX < height && newY >= 0 && newY < width){
            this.positionX = newX;
            this.positionY = newY;
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

    public void getScore() {
        System.out.println(name + "'s current score: " + score);
    }

}
