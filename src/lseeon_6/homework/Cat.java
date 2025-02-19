package lseeon_6.homework;

public class Cat extends Animal {

    private final int MAX_RUN_DISTANCE = 200;
    private final int MAX_SWIM_DISTANCE = 0;
    public static int countCat;

    public Cat(String name) {
        super(name);
        countCat++;
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
