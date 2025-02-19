package lseeon_6.homework;

public class Cat extends Animal {

    private final int MAX_RUN_DISTANCE_CAT = 200;
    private final int MAX_SWIM_DISTANCE_CAT = 0;
    public static int countCat;

    public Cat(String name) {
        super(name);
        MAX_RUN_DISTANCE = MAX_RUN_DISTANCE_CAT;
        MAX_SWIM_DISTANCE = MAX_SWIM_DISTANCE_CAT;
        countCat++;
    }
}
