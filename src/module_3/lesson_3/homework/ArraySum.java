package module_3.lesson_3.homework;

public class ArraySum {

    public static int arraySum (String[][] inputArray ) throws MyArraySizeException, MyArrayDataException {

        int sum = 0;

        validateArraySize(inputArray);
        int[][] intArray = convertArrayToInt(inputArray);

        for (int i = 0; i < inputArray .length; i++) {
            for (int j = 0; j < inputArray [i].length; j++) {
                    sum += intArray[i][j];
            }
        }

        return sum;
    }

    private static void validateArraySize(String[][] inputArray) throws MyArraySizeException {
        if (inputArray .length != 4) {
            throw new MyArraySizeException();
        }

        for (int i = 0; i < inputArray .length; i++) {
            if (inputArray [i].length != 4) {
                throw new MyArraySizeException();
            }
        }
    }

    private static int[][] convertArrayToInt(String[][] inputArray) throws MyArrayDataException {

        int[][] intArray = new int[4][4];

        for (int i = 0; i < inputArray.length; i++) {
            for (int j = 0; j < inputArray[i].length; j++) {
                try {
                    intArray[i][j] = Integer.parseInt(inputArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return intArray;
    }
}
