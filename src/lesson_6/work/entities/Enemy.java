package lseeon6.work.entities;

import lseeon6.work.entities.Actor;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 14.02.2025
 */

public abstract class Enemy extends Actor {
    private static int minValue = 20;
    private static int maxValue = 50;

    protected int health;
    protected int power;

    public Enemy() {
    }

    public Enemy(int x, int y, int health, int power) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.power = power;
    }

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.health = 0;
        this.power = 0;
    }

    public void move() {
        System.out.println("Enemy move");
    }

    public int getHealth() {
        return health;
    }
}
