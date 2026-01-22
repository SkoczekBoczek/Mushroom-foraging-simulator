
import Game.ForestGenerationStrategy;
import Game.StandardForestStrategy;
import Game.HardcoreForestStrategy;
import Game.Player;
import mushrooms.Mushroom;
import mushrooms.PoisonousMushroom;
import java.util.Random;

public class TestRunner {
    public static void main(String[] args) {
        testStandardStrategy();
        testHardcoreStrategy();
        testPlayerLogic();
    }

    private static void testStandardStrategy() {
        System.out.print("Test 1: StandardForestStrategy: ");
        
        ForestGenerationStrategy strategy = new StandardForestStrategy();
        Random random = new Random();
        int iterations = 10000;
        int mushroomCount = 0;

        for (int i = 0; i < iterations; i++) {
            if (strategy.createMushroom(random) != null) {
                mushroomCount++;
            }
        }

        if (mushroomCount > 800 && mushroomCount < 1200) {
            System.out.println("PASSED");
            System.out.println("Częstotliwość grzybów: " + mushroomCount + "/" + iterations );
            System.out.println("");
        } else {
            System.out.println("FAILED");
            System.out.println("Częstotliwość grzybów: " + mushroomCount + ", oczekiwano ok. 1000");
            System.out.println("");
        }
    }

    private static void testHardcoreStrategy() {
        System.out.print("Test 2: HardcoreForestStrategy: ");

        ForestGenerationStrategy strategy = new HardcoreForestStrategy();
        Random random = new Random();
        int iterations = 10000;
        int mushroomCount = 0;
        int poisonousCount = 0;

        for (int i = 0; i < iterations; i++) {
            Mushroom m = strategy.createMushroom(random);
            if (m != null) {
                mushroomCount++;
                if (m instanceof PoisonousMushroom) {
                    poisonousCount++;
                }
            }
        }

        boolean frequencyOk = (mushroomCount > 1800 && mushroomCount < 2200);
        boolean poisonOk = (poisonousCount > (mushroomCount / 2));

        if (frequencyOk && poisonOk) {
            System.out.println("PASSED");
            System.out.println("Częstotliwość grzybów: " + mushroomCount + "/" + iterations);
            System.out.println("Ilość trujących grzybów: " + poisonousCount);
            System.out.println("");
        } else {
            System.out.println("FAILED");
            System.out.println("Częstotliwość grzybów: " + mushroomCount);
            System.out.println("Ilość trujących grzybów: " + poisonousCount + " trujących)");
            System.out.println("");
        }
    }

    private static void testPlayerLogic() {
        System.out.print("Test 3: Player Logic: ");
        Player player = new Player();
        
        if (player.getScore() != 0 || player.getPositionX() != 0 || player.getPositionY() != 0) {
            System.out.println("FAILED: Błąd pozycji początkowej");
            return;
        }

        player.move(1, 1, 10, 10);
        if (player.getPositionX() != 1 || player.getPositionY() != 1) {
            System.out.println("FAILED: Błąd ruchu");
            return;
        }

        player.move(-5, 0, 10, 10); 
        if (player.getPositionX() != 1) {
            System.out.println("FAILED: Błąd granicy mapy");
            return;
        }

        player.addScore(10);
        if (player.getScore() != 10) {
            System.out.println("FAILED: Błąd dodawania punktów");
            return;
        }

        System.out.println("PASSED");
    }
}
