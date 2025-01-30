package lesson1.work;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        byte myByte = 10; //-128..+127 -> 1byte
        short myShort = 300; //-32768..+32767 -> 2byte
        int myInteger = 50000; //-2.1mlrd..+2.1mlrd -> 4byte
        long myLong = 30000000000L; //-2^63..+2^63 -> 8byte

        float myFloat = 345.67f; // <>.0000000 -> 4byte
        double myDouble = 345.67891; //<>.00000000000000 -> 8byte

        char myChar = 'D'; // 2byte
        String myString = "Word";
        String concatString = "Word " + 123;

        boolean myBooleanTrue = true; //1 byte
        boolean myBooleanFalse = false; //1 byte

        String value1 = myMethodName1();
        System.out.println("value 1 = " + value1);
        System.out.println("value from method = " + myMethodName1());
        myMethodVoid();
        myMethodWithArgs1(120);
        int myCurrentCash = myMethodWithArgs2(120);
        System.out.println("Result = " + myCurrentCash);
        myMethodWithArgs3(300, "Word", 'w');

        int a = 20;

        if (a == 80) {
            System.out.println("A = 20");
        } else {
            System.out.println("A != 20");
        }

        int b = 350;

        if (b > 200) {
            System.out.println("b > 200");
        } else if (b > 340) {
            System.out.println("b > 340");
        } else {
            System.out.println("b < 200");
        }

        int c = 30;
        if (c < 10) {
            System.out.println("c < 10");
        }

        System.out.println("End Program");
    }

    public static String myMethodName1() {
        System.out.println("Hello");
        return "QWERTY";
    }

    public static void myMethodVoid() {
        System.out.println("This is my Void method");
    }

    public static void myMethodWithArgs1(int cash) {
        System.out.println("My cash is " + cash);
    }

    public static int myMethodWithArgs2(int cash) {
        int tmp = cash - 100;
        System.out.println("My tmp is " + tmp);
        return tmp;
    }

    public static void myMethodWithArgs3(int cash, String value, char myChar) {
        System.out.println(value + myChar + " = " + cash);
    }
}