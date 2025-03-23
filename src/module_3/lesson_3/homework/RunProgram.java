package module_3.lesson_3.homework;

public class RunProgram {
    public static void main(String[] args) {

        String[][] array = {{"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}};

        try {
            System.out.println("Сумма элементов массива: " + ArraySum.arraySum(array));
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка: " + e.getMessage());;
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}