package mushrooms;

import Game.Player;

public class EdibleMushroom extends Mushroom {
    public EdibleMushroom(String name, int points) {
        super(name, 5);
    }

    public void consume(Player player){
        super.consume(player);
        player.addScore(this.points);
        }

}
