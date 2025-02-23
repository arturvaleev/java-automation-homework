package lseeon6.work.entities;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 14.02.2025
 */

public abstract class Actor {
    protected int x;
    protected int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void printInConsole();
}
