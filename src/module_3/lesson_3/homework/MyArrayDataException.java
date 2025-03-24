package module_3.lesson_3.homework;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col) {
        super("Элемент массива [" + row + "][" + col + "] не получилось преобразовать в число.");
    }
}
