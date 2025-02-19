package lseeon_6.homework;

public class Dog extends Animal {

    private final int MAX_RUN_DISTANCE_DOG = 500;
    private final int MAX_SWIM_DISTANCE_DOG = 10;
    public static int countDog;

    public Dog(String name) {
        super(name);
        MAX_RUN_DISTANCE = MAX_RUN_DISTANCE_DOG;
        MAX_SWIM_DISTANCE = MAX_SWIM_DISTANCE_DOG;
        countDog++;
    }
}
