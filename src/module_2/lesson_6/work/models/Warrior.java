package lseeon6.work.models;

import lseeon6.work.entities.Enemy;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 14.02.2025
 */

public class Warrior extends Enemy {

    private String name;
    private int x;
    private int y;

    public Warrior(int x, int y) {
        super(x, y);
        this.x = x;
    }

    public Warrior(int x, int y, String name, char char1) {
        super();
        this.name = name;
    }

    public Warrior(int x, int y, String name) {
        this.name = name;
    }

    @Override
    public int getX() {
        System.out.println("Get X Warrior");
        return x;
    }

    @Override
    public void printInConsole() {
        System.out.println("Warrior print");
    }

    @Override
    public void move() {
        super.move();
        System.out.println("Warrior move");
    }

    public void damage() {
        System.out.println("damage");
    }


}
