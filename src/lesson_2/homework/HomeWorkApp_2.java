package lesson_2.homework;

public class HomeWorkApp_2 {

    public static void main(String[] args) {

        System.out.println("\t===isSumInRange===");
        System.out.println(isSumInRange(5, 5));

        System.out.println("\n\t===printNumberSign===");
        printNumberSign(0);

        System.out.println("\n\t===isNegativeNumber===");
        System.out.println(isNegativeNumber(-1));

        System.out.println("\n\t===printStringMultipleTimes===");
        printStringMultipleTimes("404 - Sleep not found", 3);

        System.out.println("\n\t===isLeapYear===");
        System.out.println(isLeapYear(404));

    }

    public static boolean isSumInRange(int a, int b) {

        return (a + b) >= 10 && (a + b) <= 20;

    }

    public static void printNumberSign(int a) {

        if (a >= 0) {
            System.out.println("Положительное");
        } else {
            System.out.println("Отрицательное");
        }

    }

    public static boolean isNegativeNumber(int a) {

        return a < 0;

    }

    public static void printStringMultipleTimes(String str, int count) {

        for (int i = 0; i < count; i++){
            System.out.println(str);
        }

    }

    public static boolean isLeapYear(int year) {

        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);

    }

}