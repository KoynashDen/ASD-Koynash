package Lab_2.Task_4;
import java.util.Scanner;

import static Prints.printMatrix.printMatrix;
import static GetValid.GetValidInt.getValidInt;

public class Task_4 {
    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть розмір квадратної матриці N:");
        int n = getValidInt(scanner);
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == n - 1 - i) {
                    matrix[i][j] = 8;
                } else if (j > n - i - 1) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println("Матриця:");
        printMatrix(matrix);
    }
}
