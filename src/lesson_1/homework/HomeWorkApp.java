package lesson_1.homework;

public class HomeWorkApp {
    public static void main(String[] args) {

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers(30, 30);

    }

    public static void printThreeWords() {

        System.out.println("\t===printThreeWords===");

        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");

    }

    public static void checkSumSign() {

        System.out.println("\n\t===checkSumSign===");

        int a = -11;
        int b = 2;

        if ((a + b) >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }

    }

    public static void printColor() {

        System.out.println("\n\t===printColor===");

        int value = 100;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }

    }

    public static void compareNumbers(int a, int b) {

        System.out.println("\n\t===compareNumbers===");

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }

    }

}