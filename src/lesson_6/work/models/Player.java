package lseeon6.work.models;

import lseeon6.work.entities.Actor;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 14.02.2025
 */

public class Player extends Actor {

    private int power;
    private int health;

    public Player(int power, int health, int x, int y) {
        this.power = power;
        this.health = health;
        this.x = x;
        this.y = y;
    }

    public void move() {
        System.out.println("Player move");
    }

    @Override
    public void printInConsole() {
        System.out.println("Player print");
    }
}
