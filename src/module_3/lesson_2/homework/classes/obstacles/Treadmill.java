package module_3.lesson_2.homework.classes.obstacles;

import module_3.lesson_2.homework.interfaces.Move;

public class Treadmill extends Obstacle {

    public Treadmill(int distance) {
        super(distance);
    }

    @Override
    public String getName() {
        return "беговая дорожка";
    }

    @Override
    public boolean canOvercame(Move participant) {
        if (participant.canRun(getLength())){
            return true;
        } else {
            return false;
        }
    }
}
