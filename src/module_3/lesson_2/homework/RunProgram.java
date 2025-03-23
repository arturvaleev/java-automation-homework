package module_3.lesson_2.homework;

import module_3.lesson_2.homework.classes.obstacles.Obstacle;
import module_3.lesson_2.homework.classes.obstacles.Treadmill;
import module_3.lesson_2.homework.classes.obstacles.Wall;
import module_3.lesson_2.homework.classes.participants.Cat;
import module_3.lesson_2.homework.classes.participants.Human;
import module_3.lesson_2.homework.classes.participants.Robot;
import module_3.lesson_2.homework.interfaces.Move;

public class RunProgram {
    public static void main(String[] args) {

        Obstacle [] obstacles = new Obstacle[6];

        obstacles [0] = new Wall(1);
        obstacles [1] = new Wall(2);
        obstacles [2] = new Wall(3);

        obstacles [3] = new Treadmill(50);
        obstacles [4] = new Treadmill(150);
        obstacles [5] = new Treadmill(200);

        Move[] participants = new Move[6];

        participants[0] = new Cat(3, 300, "Барсик");
        participants[1] = new Cat(1, 180, "Симба");

        participants[2] = new Robot(0, 50, "Робот-Фёдор");
        participants[3] = new Robot(3, 70, "Просто-робот");

        participants[4] = new Human(1, 80, "Артур");
        participants[5] = new Human(3, 120, "Вика");

        for (int i = 0; i < participants.length; i++) {
            System.out.println("\n--- Участник " + participants[i].getName() + " начал проходить премятствия. ---");
            for (int j = 0; j < obstacles.length; j++) {

                if (obstacles[j].canOvercame(participants[i])){
                    System.out.println(participants[i].getName() + " преодолел препятствие: " + obstacles[j].getName() + " с distance = " + obstacles[j].getLength());
                } else {
                    System.out.println("=== " + participants[i].getName() + " не смог преодолеть препятствие: " + obstacles[j].getName() + " с distance = " + obstacles[j].getLength() + " и поэтому выбывает. ===");
                    break;
                }
            }
        }
    }
}