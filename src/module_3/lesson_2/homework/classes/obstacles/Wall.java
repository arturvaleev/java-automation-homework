package module_3.lesson_2.homework.classes.obstacles;

import module_3.lesson_2.homework.interfaces.Move;

public class Wall extends Obstacle {

    public Wall(int height) {
        super(height);
    }

    @Override
    public String getName() {
        return "стена";
    }

    @Override
    public boolean canOvercame(Move participant) {
        if (participant.canJump(getLength())){
            return true;
        } else {
            return false;
        }
    }
}
