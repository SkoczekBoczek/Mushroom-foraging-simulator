package Game;

import mushrooms.*;
import java.util.Random;

public class HardcoreForestStrategy implements ForestGenerationStrategy {

    @Override
    public Mushroom createMushroom(Random random) {
        if (random.nextInt(10) < 2) {
            int type = random.nextInt(10);            
            if (type <= 1) {
                return new EdibleMushroom("Borowik", 5);
            } else if (type <= 7) {
                return new PoisonousMushroom("Muchomor", -20);
            } else {
                return new MedicinalMushroom("Lakówka", 3);
            }
        }
        return null;
    }
}
