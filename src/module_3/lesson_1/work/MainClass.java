package module3.lesson1;

import module3.lesson1.enums.DayType;
import module3.lesson1.enums.FirstEnum;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 11.03.2025
 */

public class MainClass{
    public static void main(String[] args) {

//        TestObject testObject = new TestObject();
//        System.out.println(testObject.getClass());
//        System.out.println(testObject.toString());
//        System.out.println(testObject.hashCode());
//
//        FirstEnum color = FirstEnum.RED_2;
//        System.out.println(color);
//        System.out.println(color.getTmp());
//        System.out.println(FirstEnum.GREEN);
//
//        System.out.println(color.equals(FirstEnum.RED_1));
//
//        FirstEnum[] all = FirstEnum.values();
//        for (int i = 0; i < all.length; i++) {
//            System.out.println(all[i] + " > " +all[i].getB());
//        }
//
//        System.out.println("=================");
//        FirstEnum color2 = FirstEnum.BLACK;
//        System.out.println(color2);

        DayType day1 = DayType.MONDAY;
        System.out.println(day1);

        Day[] days = new Day[3];
        days[0] = new Day(1, "MONDAY");
        days[1] = new Day(6, "SATURDAY");
        days[2] = new Day(3, "WEDNESDAY");

        DayType[] dayEnum = DayType.values();

        days[0].getValue();
        DayType.MONDAY.getValue();


    }
}
