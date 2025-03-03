package GetValid;

import java.util.Scanner;

public class GetValidDouble {
    public static double getValidDouble(Scanner scan) {
        while (true) {
            try {
                return scan.nextDouble();
            } catch (Exception e) {
                System.out.println("ПОМИЛКА: Введіть число з плаваючою комою!");
                scan.next();
            }
        }
    }
}
