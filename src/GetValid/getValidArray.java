package GetValid;

import java.util.Scanner;

public class getValidArray {
    public static int[] getValidArray(Scanner scan, int size) {
        int[] array = new int[size];

        while (true) {
            System.out.println("Введіть " + size + " чисел через пробіл:");

            String input = scan.nextLine();
            String[] parts = input.trim().split("\\s+");


            boolean hasLetters = false;
            for (String part : parts) {
                if (part.matches(".*[a-zA-Zа-яА-Я].*")) {
                    hasLetters = true;
                    break;
                }
            }

            if (hasLetters) {
                System.out.println("ПОМИЛКА: Введено не число. Введіть тільки числа.");
                continue;
            }


            if (parts.length != size) {
                System.out.println("ПОМИЛКА: Невірна кількість елементів. Введіть " + size + " чисел.");
                continue;
            }


            for (int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(parts[i]);
            }

            return array;
        }
    }
}
