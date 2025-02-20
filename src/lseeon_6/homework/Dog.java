package lseeon_6.homework;

public class Dog extends Animal {
    public static int countDog;

    public Dog(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxSwimDistance);
        countDog++;
    }
}
