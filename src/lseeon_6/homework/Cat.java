package lseeon_6.homework;

public class Cat extends Animal {

    private static final int MAX_RUN_DISTANCE = 200;
    private static final int MAX_SWIM_DISTANCE = 0;
    private static int countCat;

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

    public static int getCountCat() {
        return countCat;
    }
}
