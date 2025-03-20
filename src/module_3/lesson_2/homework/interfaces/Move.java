package module_3.lesson_2.homework.interfaces;

public interface Move {

    String jump(int height);
    String run(int distance);

    Boolean canJump(int height);
    Boolean canRun(int distance);
}
