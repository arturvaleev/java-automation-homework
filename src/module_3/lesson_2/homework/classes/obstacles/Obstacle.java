package module_3.lesson_2.homework.classes.obstacles;

import module_3.lesson_2.homework.interfaces.Move;

public abstract class Obstacle {

    private int length;

    public Obstacle(int length) {
        this.length = length;
    }

    public abstract boolean canOvercame(Move participant);

    public int getLength() {
        return length;
    }

    public abstract String getName();
}
