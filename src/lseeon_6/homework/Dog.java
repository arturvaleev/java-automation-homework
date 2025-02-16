package lseeon_6.homework;

public class Dog extends Animal {

    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    private static int countDog;

    public Dog(String name) {
        super(name, MAX_RUN_DISTANCE, MAX_SWIM_DISTANCE);
        countDog++;
    }

    @Override
    protected int getMaxRunDistance() {
        return MAX_RUN_DISTANCE;
    }

    @Override
    protected int getMaxSwimDistance() {
        return MAX_SWIM_DISTANCE;
    }

    public static int getCountDog() {
        return countDog;
    }
}
