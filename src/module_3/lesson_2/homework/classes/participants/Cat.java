package module_3.lesson_2.homework.classes.participants;

import module_3.lesson_2.homework.interfaces.Move;

public class Cat implements Move {

    private String name;
    private int maxJumpHeight;
    private int maxRunDistance;

    public Cat(int maxJumpHeight, int maxRunDistance, String name) {
        this.name = name;
        this.maxJumpHeight = maxJumpHeight;
        this.maxRunDistance = maxRunDistance;
    }

    @Override
    public String jump(int height) {
        return name + " перепрыгнул " + height + " метров.";
    }

    @Override
    public String run(int distance) {
        return name + " пробежал "  + distance + " метров.";
    }

    @Override
    public Boolean canRun(int distance) {
        return distance <= maxRunDistance;
    }

    @Override
    public Boolean canJump(int height) {
        return height <= maxJumpHeight;
    }
}
