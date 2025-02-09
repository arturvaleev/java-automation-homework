package lesson_3.homework;

public class HomeWorkApp_3 {

    public static void main(String[] args) {

        System.out.println("\t===invertArray===");
        int[] arr = {1,1,0,0,1,0,1,1,0,0};
        printOneArray("Before inversion", arr);
        invertArray(arr);
        printOneArray("After inversion", arr);

        System.out.println("\n\t===fillArraySequentially===");
        int[] arr2 = new int[100];
        fillArraySequentially(arr2);
        printOneArray(arr2);

        System.out.println("\n\t===multiplyIfLessThanSix===");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printOneArray("Before executing the multiplyIfLessThanSix method", arr3);
        multiplyIfLessThanSix(arr3);
        printOneArray("After executing the multiplyIfLessThanSix method", arr3);

        System.out.println("\n\t===fillDiagonalsWithOnes===");
        int[][] arr4 = new int[11][11];
        fillDiagonalsWithOnes(arr4);
        printTwoArrayInt(arr4);


        System.out.println("\n\t===createArrayWithInitialValue===");
        printOneArray(createArrayWithInitialValue(3, 3));

        System.out.println("\n\t===findMinMaxInArray===");
        int[] arr5 = {-10, 0, -1, 5, 8, 3};
        printOneArray(arr5);
        System.out.printf("Min = %d | Max = %d", findMinInArray(arr5), findMaxInArray(arr5));

        System.out.println("\n\t===checkBalance===");
        int[] arr6 = {1,1,2,1,3};
        printOneArray(arr6);
        System.out.println(checkBalance(arr6));

    }

    public static void invertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
    }

    public static void fillArraySequentially(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }
    }

    public static void multiplyIfLessThanSix(int[] arr) {
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
    }

    public static void fillDiagonalsWithOnes(int[][] arr) {
        for (int i = 0, j = 0; i < arr.length; i++, j++){
            if (i == j){
                arr[i][j] = 1;
                arr[i][(arr.length-1) - j] = 1;
            }
        }
    }

    public static int[] createArrayWithInitialValue(int len, int initialValue){
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++){
            arr[i] = initialValue;
        }
        return arr;
    }

    public static int findMinInArray(int[] arr){
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++){
            tmp = arr[i] < tmp ? arr[i] : tmp;
        }
        return tmp;
    }

    public static int findMaxInArray(int[] arr){
        int tmp = arr[0];
        for (int i = 1; i < arr.length; i++){
            tmp = arr[i] > tmp ? arr[i] : tmp;
        }
        return tmp;
    }

    public static boolean checkBalance(int[] arr){
        int leftSum = arr[0];
        int rightSum = 0;

        for (int i = 1; i < arr.length; i++){
            for (int j = 0+i; j < arr.length; j++){
                rightSum += arr[j];
            }
            if (leftSum == rightSum){
                return true;
            }
            rightSum = 0;
            leftSum += arr[i];
        }
        return false;
    }

    public static void printOneArray(String text, int[] input) {
        System.out.println(text);

        for (int i = 0; i < input.length; i++) {
            System.out.print("|"+ input[i] + "|");
        }
        System.out.println();
    }

    public static void printOneArray(int[] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print("|"+ input[i] + "|");
        }
        System.out.println();
    }

    public static void printTwoArrayInt(String text, int[][] input) {
        System.out.println(text);

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print("[" + input[i][j] + "]\t" );
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printTwoArrayInt(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print("[" + input[i][j] + "]\t" );
            }
            System.out.println();
        }
        System.out.println();
    }
}
