package lseeon_6.homework;

public class Dog extends Animal {

    private final int MAX_RUN_DISTANCE = 500;
    private final int MAX_SWIM_DISTANCE = 10;
    public static int countDog;

    public Dog(String name) {
        super(name);
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
}
