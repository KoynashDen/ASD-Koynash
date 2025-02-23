package Prints;

public class printMatrix {
    public static void printMatrix(int[][] matrix) {
        int maxValue = matrix.length * matrix[0].length;
        int width = String.valueOf(maxValue).length();

        System.out.println("Заповнена матриця:");
        for (int[] row : matrix) {
            for (int num : row) {

                System.out.printf("%" + width + "d ", num);
            }
            System.out.println();
        }
    }
}
