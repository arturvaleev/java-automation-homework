package lesson3;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 04.02.2025
 */

public class ArrayClass {

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        String strongPass = getRandomPassword(16);
        System.out.println("strongPass > " + strongPass);
    }

    public static String getRandomPassword(int length) {
        String tmp = "";

        for (int i = 0; i < length; i++) {
            int charIndex = myRandomInteger(48, 122);
            char currentChar = (char) charIndex; //type casting
            tmp += currentChar;
        }
        return tmp;
    }

    public static String getRandomPassword2(int length) {
        String tmp = "";
        for (int i = 0; i < length; i++) {
            tmp += (char) myRandomInteger(48, 122);
        }
        return tmp;
    }


    public static int myRandomInteger(int minBound, int maxBound) {
        return random.nextInt(maxBound - minBound + 1) + minBound;
    }

    public static void studyRandom() {
        for (int i = 0; i < 5; i++) {
            System.out.println("random.nextInt() > " + random.nextInt());//[-int;+int]
            System.out.println("random.nextInt(10) > " + random.nextInt(10));//[0;maxBound)
            System.out.println("random.nextFloat() > " + random.nextFloat());//[0;1)
            System.out.println("random.nextDouble() > " + random.nextDouble());//[0;1)
            System.out.println("random.nextBoolean() > " + random.nextBoolean());
            System.out.println("-----------------");
        }
    }

    public static int inputIntegerFromScanner() {
        System.out.print("Please, enter your number > ");
        return scanner.nextInt();
    }

    public static String inputStringFromScanner() {
        System.out.print("Please, enter your string > ");
        return scanner.next();
    }

    public static void studyManyArrays() {
        String[][][][][] array5 = new String[5][3][2][5][3];

        for (int i = 0; i < array5.length; i++) {
            for (int j = 0; j < array5[i].length; j++) {
                for (int k = 0; k < array5[i][j].length; k++) {
                    for (int l = 0; l < array5[i][j][k].length; l++) {
                        for (int m = 0; m < array5[i][j][k][l].length; m++) {

                        }
                    }
                }
            }
        }
    }

    public static void studyTwoArrays() {
        int[][] array3 = new int[5][3];

        int value = 1;

        for (int i = 0; i < array3.length; i++) {
            for (int j = 0; j < array3[i].length; j++) {
                array3[i][j] = value;
                value++;
            }
        }

        printTwoArrayInt(array3);

    }

    public static void studyOneArrays() {
        int[] array1 = new int[4]; //[0,0,0,0]; [0.0]; [null]; [false]
        array1[0] = 5;
        array1[1] = 10;
        array1[2] = 15;
        array1[3] = 20;
        printOneArray(array1);
        array1[0] = 30;
        printOneArray(array1);

        int[] array2 = {5, 10, 23, 48};
        printOneArray(array2);

    }

    public static void printOneArray(String temp, int[] input) {
        System.out.println("----Print Array Int----");
        for (int i = 0; i < input.length; i++) {
            System.out.println("Value #" + i + " = " + input[i]);
        }
    }

    public static void printOneArray(int[] input) {
        System.out.println("----Print Array Int----");
        for (int i = 0; i < input.length; i++) {
            System.out.println("Value #" + i + " = " + input[i]);
        }
    }

    public static void printOneArray(double[] input) {
        System.out.println("----Print Array Int----");
        for (int i = 0; i < input.length; i++) {
            System.out.println("Value #" + i + " = " + input[i]);
        }
    }

    public static void printOneArray(String[] input) {
        System.out.println("----Print Array Int----");
        for (int i = 0; i < input.length; i++) {
            System.out.println("Value #" + i + " = " + input[i]);
        }
    }

    public static void printTwoArrayIntWithIndex(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print("[" + i + ";" + j + "] = " + input[i][j]);
            }
            System.out.println();
        }
    }

    public static void printTwoArrayInt(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print("[" + input[i][j] + "]\t" );
            }
            System.out.println();
        }
    }
}


