package lesson_6.homework;

public class Cat extends Animal {
    public static int countCat;

    public Cat(String name, int maxRunDistance, int maxSwimDistance) {
        super(name, maxRunDistance, maxSwimDistance);
        countCat++;
    }
}
