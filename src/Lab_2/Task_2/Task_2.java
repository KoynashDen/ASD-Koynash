package Lab_2.Task_2;

import java.util.Random;
import java.util.Scanner;

import GetValid.GetValidInt;
import Prints.printMatrix;

public class Task_2 {
    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Введіть розміри матриці (m x n):");
        int m = GetValidInt.getValidInt(scanner);
        int n = GetValidInt.getValidInt(scanner);
        int[][] matrix = new int[m][n];


        System.out.println("Початкова матриця:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(9)+1;
            }
        }


        printMatrix.printMatrix(matrix);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        System.out.println("Кінцева матриця:");
        printMatrix.printMatrix(matrix);
    }

}
