package mushrooms;

import Game.Player;

public class MedicinalMushroom extends Mushroom {
    public MedicinalMushroom(String name, int points) {
        super(name, 10);
    }

    public void consume(Player player){
        super.consume(player);
        player.addScore(this.points);
        }

}
