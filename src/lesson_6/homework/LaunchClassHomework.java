package lesson_6.homework;
import java.util.Random;

public class LaunchClassHomework {

    public static Random random = new Random();

    public static void main(String[] args) {

        int maxRunDistanceCat = 200;
        int maxSwimDistanceCat = 0;
        int maxRunDistanceDog = 500;
        int maxSwimDistanceDog = 10;

        Animal cat1 = new Cat(getCatNames(), maxRunDistanceCat, maxSwimDistanceCat);
        System.out.println(cat1.run(getRandomValue(0,500)));
        System.out.println(cat1.swim(getRandomValue(0,50)));

        Animal dog1 = new Dog(getDogNames(),maxRunDistanceDog, maxSwimDistanceDog);
        System.out.println(dog1.run(getRandomValue(0,1000)));
        System.out.println(dog1.swim(getRandomValue(0,50)));

        System.out.println(Animal.countAnimal);
        System.out.println(Cat.countCat);
        System.out.println(Dog.countDog);

    }

    public static String getDogNames(){
        String[] dogNames = { "Бобик", "Шарик", "Рекс", "Тузик", "Полкан", "Барон", "Лорд", "Граф", "Мухтар", "Дружок", "Чарли", "Ричи", "Джек", "Макс", "Спайк"};
        return dogNames[getRandomValue(0, dogNames.length - 1)];
    }

    public static String getCatNames(){
        String[] catNames = {"Барсик", "Мурзик", "Васька", "Рыжик", "Снежок", "Пушок", "Леопольд", "Гав", "Симба", "Том", "Матроскин", "Феликс", "Соня", "Гарфилд", "Муся"};
        return catNames[getRandomValue(0, catNames.length - 1)];
    }

    public static int getRandomValue(int minBound, int maxBound) {
        return random.nextInt(maxBound - minBound + 1) + minBound;
    }
}
