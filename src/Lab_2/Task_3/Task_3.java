package Lab_2.Task_3;

import java.util.Scanner;

import Prints.printMatrix;
import GetValid.GetValidInt;

public class Task_3 {
    public static void task3() {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Введіть кількість рядків та стовпців: ");
        int rowsAndCols = GetValidInt.getValidInt(scanner);


        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        fillMatrixInSnailPattern.fillMatrixInSnailPattern(matrix, rowsAndCols, rowsAndCols);
        printMatrix.printMatrix(matrix);
    }
}
