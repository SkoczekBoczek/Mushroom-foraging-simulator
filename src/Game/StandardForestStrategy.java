package Game;

import mushrooms.*;
import java.util.Random;

public class StandardForestStrategy implements ForestGenerationStrategy {

    @Override
    public Mushroom createMushroom(Random random) {
        if (random.nextInt(10) < 1) {
            int type = random.nextInt(3);
            switch (type) {
                case 0: return new EdibleMushroom("Borowik", 10);
                case 1: return new PoisonousMushroom("Muchomor", -10);
                case 2: return new MedicinalMushroom("Lakówka", 5);
                default: return null;
            }
        }
        return null;
    }
}
