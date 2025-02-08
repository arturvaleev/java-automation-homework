package lesson_3.homework;

public class HomeWorkApp_3 {

    public static void main(String[] args) {

        System.out.println("\t===invertArray===");
        int[] Arr = {1,1,0,0,1,0,1,1,0,0};
        printOneArray("Before inversion", Arr);
        invertArray(Arr);
        printOneArray("After inversion", Arr);

        System.out.println("\n\t===fillArraySequentially===");
        int[] Arr2 = new int[100];
        fillArraySequentially(Arr2);
        printOneArray(Arr2);

        System.out.println("\n\t===multiplyIfLessThanSix===");
        int[] Arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printOneArray("Before executing the multiplyIfLessThanSix method", Arr3);
        multiplyIfLessThanSix(Arr3);
        printOneArray("After executing the multiplyIfLessThanSix method", Arr3);

        System.out.println("\n\t===fillDiagonalsWithOnes===");
        int[][] Arr4 = new int[5][5];
        fillDiagonalsWithOnes(Arr4);
        printTwoArrayInt(Arr4);


        System.out.println("\n\t===createArrayWithInitialValue===");
        printOneArray(createArrayWithInitialValue(3, 3));

        System.out.println("\n\t===findMinMaxInArray===");
        int[] Arr5 = {-10, 0, -1, 5, 8, 3};
        printOneArray(Arr5);
        System.out.printf("Min = %d | Max = %d", findMinInArray(Arr5), findMaxInArray(Arr5));

        System.out.println("\n\t===checkBalance===");
        int[] Arr6 = {1,1,2,1,3};
        printOneArray(Arr6);
        System.out.println(checkBalance(Arr6));

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
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++){
                if (i == j){
                    arr[i][j] = 1;
                    arr[i][(arr.length-1) - j] = 1;
                }
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
        int tmp = arr[0];
        int tmp2 = 0;

        for (int i = 1; i < arr.length; i++){
            for (int j = 0+i; j < arr.length; j++){
                tmp2 += arr[j];
            }
            if (tmp == tmp2){
                return true;
            }
            tmp2 = 0;
            tmp += arr[i];
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
