import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab_1 {
    public static void lab_1() {
        Scanner scanner = new Scanner(System.in);

        try {
            int choice = getIntInput(scanner, "Вибери завдання (1-3): ");

            switch (choice) {
                case 1:
                    double x1 = getDoubleInput(scanner, "Введіть x1: ");
                    double y1 = getDoubleInput(scanner, "Введіть y1: ");
                    double x2 = getDoubleInput(scanner, "Введіть x2: ");
                    double y2 = getDoubleInput(scanner, "Введіть y2: ");
                    double x3 = getDoubleInput(scanner, "Введіть x3: ");
                    double y3 = getDoubleInput(scanner, "Введіть y3: ");
                    double x4 = getDoubleInput(scanner, "Введіть x4: ");
                    double y4 = getDoubleInput(scanner, "Введіть y4: ");

                    double perimeter = calculatePerimeter(x1, y1, x2, y2, x3, y3, x4, y4);
                    double area = calculateArea(x1, y1, x2, y2, x3, y3, x4, y4);

                    System.out.println("Периметр: " + perimeter);
                    System.out.println("Площа: " + area);
                    break;

                case 2:
                    double x = getDoubleInput(scanner, "Введіть x: ");
                    double y = (5 * x) / (x * x + 1);
                    System.out.println("y = " + y);
                    break;

                case 3:
                    int num = getIntInput(scanner, "Введіть тризначне число: ");

                    if (num < 100 || num > 999) {
                        System.out.println("Помилка: введіть тільки тризначне число!");
                    } else {
                        boolean isArithmetic = checkArithmeticProgression(num);
                        System.out.println("Утворює арифметичну прогресію?: " + isArithmetic);
                    }
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } catch (Exception e) {
            System.out.println("Помилка: введіть тільки числа!");
        } finally {
            scanner.close();
        }
    }

    private static int getIntInput(Scanner scanner, String prompt) {
        int num;
        while (true) {
            try {
                System.out.print(prompt);
                num = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Помилка! Введіть лише ціле число.");
                scanner.next();
            }
        }
        return num;
    }

    private static double getDoubleInput(Scanner scanner, String prompt) {
        double num;
        while (true) {
            try {
                System.out.print(prompt);
                num = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Помилка! Введіть лише число.");
                scanner.next();
            }
        }
        return num;
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double calculatePerimeter(double x1, double y1, double x2, double y2,
                                            double x3, double y3, double x4, double y4) {
        return distance(x1, y1, x2, y2) +
                distance(x2, y2, x3, y3) +
                distance(x3, y3, x4, y4) +
                distance(x4, y4, x1, y1);
    }

    public static double calculateArea(double x1, double y1, double x2, double y2,
                                       double x3, double y3, double x4, double y4) {
        return Math.abs((x1 * y2 + x2 * y3 + x3 * y4 + x4 * y1) -
                (y1 * x2 + y2 * x3 + y3 * x4 + y4 * x1)) / 2.0;
    }

    public static boolean checkArithmeticProgression(int num) {
        int d1 = num / 100;
        int d2 = (num / 10) % 10;
        int d3 = num % 10;
        return (d2 - d1) == (d3 - d2);
    }
}