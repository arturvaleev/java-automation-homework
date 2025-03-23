package module_3.lesson_3.homework;

public class ArraySum {

    public static int arraySum (String[][] inputArray ) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        if (inputArray .length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < inputArray .length; i++) {
            if (inputArray [i].length != 4) {
                throw new MyArraySizeException();
            }
        }

        for (int i = 0; i < inputArray .length; i++) {
            for (int j = 0; j < inputArray [i].length; j++) {
                try {
                    sum += Integer.parseInt(inputArray [i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }
}
