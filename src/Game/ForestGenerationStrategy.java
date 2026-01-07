package Game;

import mushrooms.Mushroom;
import java.util.Random;

public interface ForestGenerationStrategy {
    Mushroom createMushroom(Random random);
}