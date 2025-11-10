package mushrooms;

import Game.Player;

public class Mushroom {
    protected String name;
    protected int points;

    public Mushroom(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName(){
        return name;
    }

    public int getPoints(){
        return points;
    }

    public void consume(Player player){
        System.out.println("You consumed the " + name + " mushroom and gained " + points + " points.");
    }

    @Override
    public String toString() {
        return name;
    }
}
