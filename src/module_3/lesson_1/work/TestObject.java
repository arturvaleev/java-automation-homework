package module3.lesson1;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 11.03.2025
 */

public class TestObject {

    private int value1;
    private Leg leg;

    public TestObject() {
        this.leg = new Leg();
    }

    private class Leg {
        private int innerValue1;
    }
}
