package Lab_2.Task_1;

import GetValid.GetValidInt;

import java.util.Scanner;

public class getValidIndex {
    public static int getValidIndex(Scanner scan, int size) {
        while (true) {
            int index = GetValidInt.getValidInt(scan);
            if (index >= 0 && index < size) {
                return index;
            } else {
                System.out.println("ПОМИЛКА: Індекс повинен бути в межах [0, " + (size - 1) + "]. Спробуйте ще раз:");
            }
        }
    }
}
