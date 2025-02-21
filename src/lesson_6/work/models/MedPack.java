package lseeon6.work.models;

import lseeon6.work.entities.Actor;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 14.02.2025
 */

public class MedPack extends Actor {
    private int medValue;

    public MedPack(int medValue, int x, int y) {
        this.medValue = medValue;
        this.x = x;
        this.y = y;
    }

    @Override
    public void printInConsole() {
        System.out.println("MedPack print");
    }

    public void doSomething() {
        System.out.println("MedPack doSomething");
    }
}
