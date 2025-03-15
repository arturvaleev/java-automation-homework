package module3.lesson1.enums;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 11.03.2025
 */

public enum DayType {
    MONDAY(1),
    SATURDAY(6),
    WEDNESDAY(3);

    public int value;

    DayType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
