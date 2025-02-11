package lesson5.work;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 11.02.2025
 */

public class Button {

    public static int testStatic = 10;

    public static void setTest(int a) {
        testStatic = a;
    }

    public static void doSomething() {
        System.out.println("Hello");
    }

    private int width; //Поле класса (объекта)
    private int height;
    private String color;
    private String text;
    private int borderRadius;

    public Button() {

    }


    public Button(int width, int height, String color, String text, int borderRadius) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.text = text;
        this.borderRadius = borderRadius;
    }


    public Button(int width, int height) {
        this.width = width;
        this.height = height;
        System.out.println("This is constructor > w = " + width);
        System.out.println("This is constructor > h = " + height);
    }

    public void click() {
        System.out.println("Hello i'm button " + this.width);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getColor() {
        return color;
    }

    public String getText() {
        return text;
    }

    public int getBorderRadius() {
        return borderRadius;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setBorderRadius(int borderRadius) {
        this.borderRadius = borderRadius;
    }
}
