package GetValid;

import java.util.Scanner;

public class getValidInt {
    public static int getValidInt(Scanner scan) {
        while (true) {
            try {
                return scan.nextInt();
            } catch (Exception e) {
                System.out.println("ПОМИЛКА: Введіть ціле число!");
                scan.next();
            }
        }
    }
}
