package lesson5.work;

import lesson2.work.TwoClassWork;
import lesson5.work.Button;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 11.02.2025
 */

public class RunProgram {

    public static void main(String[] args) {
//        Button button1 = new Button(35, 9);
//
//        System.out.println("button1.width > " + button1.getWidth());
//        System.out.println("button1.height > " + button1.getHeight());
//        button1.click();
//
//        button1.setWidth(25);
//        button1.setBorderRadius(2);
//        System.out.println("button1.width > " + button1.getWidth());
//        System.out.println("button1.borderRadius > " + button1.getBorderRadius());
//
//        Button button2 = new Button();
//
//        System.out.println("button2.width > " + button2.getWidth());
//        System.out.println("button2.borderRadius > " + button2.getBorderRadius());
//        button2.click();

        Button button3 = new Button(34, 56);
        button3.click();

        Button.doSomething();

        Button.setTest(3);
        Button.testStatic = 3;
    }
}

// * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
//         * 2. Конструктор класса должен заполнять эти поля при создании объекта.
//         * 3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
//         * 4. Создать массив из 5 сотрудников.
//         * Пример:
//         * Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
//         * persArray[0] = new Person("Ivanov Ivan", "Engineer", "mailbox@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
//         * 5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
