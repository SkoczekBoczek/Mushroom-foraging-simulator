package mushrooms;

import Game.Player;

public class PoisonousMushroom extends Mushroom {
    public PoisonousMushroom(String name, int points) {
        super(name, -10);
    }

    public void consume(Player player){
        player.score += this.points;
        }

}
