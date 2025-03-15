package lseeon6.work;

import lseeon6.work.entities.Actor;
import lseeon6.work.models.MedPack;
import lseeon6.work.models.Player;
import lseeon6.work.models.Warrior;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 14.02.2025
 */

public class LaunchClassWork6 {

    public static void main(String[] args) {

        Player player = new Player(5, 10, 5, 4);
        System.out.println(player.getX());

        Warrior warrior = new Warrior(40, 50);
        System.out.println("warrior.getHealth() > " + warrior.getHealth());
        System.out.println("warrior.getX() > " + warrior.getX());
        warrior.move();

        System.out.println(player.getX());
        System.out.println(warrior.getX());

        MedPack medPack = new MedPack(50, 4, 0);

        Actor[] actors = {player, warrior, medPack};

        for (int i = 0; i < actors.length; i++) {
            actors[i].printInConsole();

            if (actors[i] instanceof MedPack) {
                MedPack medpack = (MedPack) actors[i];
                medpack.doSomething();
            }

            if (actors[i] instanceof Warrior) {
                Warrior warrior1 = (Warrior) actors[i];
                warrior1.damage();
            }

        }
    }
}
