package lseeon_6.homework;
import java.util.Random;

public class LaunchClassHomework {

    public static Random random = new Random();

    public static void main(String[] args) {

        Animal cat1 = new Cat(getCatNames());
        cat1.run(getRandomValue(0,500));
        cat1.swim(getRandomValue(0,50));

        Animal dog1 = new Dog(getDogNames());
        dog1.run(getRandomValue(0,1000));
        dog1.swim(getRandomValue(0,50));

        System.out.println(Animal.getCountAnimal());
        System.out.println(Cat.getCountCat());
        System.out.println(Dog.getCountDog());

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
