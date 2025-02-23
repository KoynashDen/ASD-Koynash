package Lab_2.Task_3;

public class fillMatrixInSnailPattern {
    public static void fillMatrixInSnailPattern(int[][] matrix, int rows, int cols) {
        int value = 1;
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                matrix[top][i] = value++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = value++;
            }
            right--;

            if (top <= bottom) {

                for (int i = right; i >= left; i--) {
                    matrix[bottom][i] = value++;
                }
                bottom--;
            }

            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = value++;
                }
                left++;
            }
        }
    }
}
