package module3.lesson1.enums;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 11.03.2025
 */

public enum FirstEnum {
    RED_1(134, 244, 555, "1"),
    RED_2(134, 244, 666, "2"),
    ORANGE(134, 244, 555, "3"),
    WHITE(345, 244, 555, "4"),
    BLACK(134, 244, 555, "5"),
    GREEN(134, 244, 555, "6");

    private int r;
    private int g;
    private int b;
    private String tmp;

    FirstEnum(int r, int g, int b, String tmp) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.tmp = tmp;
    }

    public int getR() {
        return r;
    }

    public int getG() {
        return g;
    }

    public int getB() {
        return b;
    }

    public String getTmp() {
        return tmp;
    }
}
