package application.tools;

import java.util.Random;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 21.02.2025
 */

public class Tools {

    public static int ENEMY_MIN_VALUE = 20;
    public static int ENEMY_MAX_VALUE = 50;

    public static Random random = new Random();

    public static int getRandomValue(int minBound, int maxBound) {
        return random.nextInt(maxBound - minBound + 1) + minBound;
    }
}
