package lesson2.work;

import java.sql.SQLOutput;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 31.01.2025
 */

public class TwoClassWork {

    public static String abc = "abc";

    public static void main(String[] args) {
        pifagorTable(10, 10);
        System.out.println("Finish program");
    }

    public static void pifagorTable(int width, int height) {
        for (int y = 1; y <= height; y++) {
            for (int x = 1; x <= width; x++) {
                System.out.print(y * x + "\t");
            }
            System.out.println();
        }
    }

    public static int myMathMethod(int base, int signature) {
        if (signature < 0) {
            signature = - signature;
        }

        if (signature == 0) {
            return 1;
        }

        int result = base;

        for (int i = 1; i < signature; i++) {
            result = result * base;
        }
        return result;
    }

    public static void studyFor() {
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("Hello > " + i);

            if (i == 6) {
                break;
            }
        }
        System.out.println("Finish FOR");
    }

    public static void studyWhile() {
        int a = 0;

        while (a < 10) {
            a++;

            if (a == 2) {
                continue;
            }

            if (a == 8) {
                break;
            }
            System.out.println("Hello > " + a);
        }
    }

    public static void studyDoWhile() {
        int a = 0;

        do {
            a++;
            System.out.println("Hello > " + a);
        } while (a < 10);
    }

    public static void studySwitch() {
        System.out.println(abc);
        int code = 900;

        if (code == 100) {
            int dfg = 50;
            System.out.println("100");
            System.out.println(dfg);
        } else if (code == 200) {
            System.out.println(abc);
            System.out.println("200");
        } else if (code == 300) {
            System.out.println("300");
        } else if (code == 400) {
            System.out.println("400");
        } else if (code == 500) {
            System.out.println("500");
        } else if (code == 600) {
            System.out.println("600");
        } else {
            System.out.println("MISS");
        }

        System.out.println("-------------");

        switch (code) {
            case 100:
                System.out.println("100");
                System.out.println(abc);
                break;
            case 200:
                System.out.println("200");
                break;
            case 300:
                System.out.println("300");
                break;
            case 400:
                System.out.println("400");
                break;
            case 500:
                System.out.println("500");
                break;
            case 600:
                System.out.println("600");
                break;
            default:
                System.out.println("MISS");
                break;
        }

        System.out.println("Finish");
    }
}
