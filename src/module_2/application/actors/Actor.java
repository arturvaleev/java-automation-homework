package application.actors;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 21.02.2025
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

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
