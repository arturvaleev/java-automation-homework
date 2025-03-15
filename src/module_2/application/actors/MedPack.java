package application.actors;

import application.tools.Tools;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 21.02.2025
 */

public class MedPack extends Actor{

    private int value;
    public static int COUNT = 0;

    public MedPack() {
        this.value = Tools.getRandomValue(10, 50);
    }

    public int getValue() {
        return value;
    }

    public int getCount() {
        return COUNT;
    }
}
