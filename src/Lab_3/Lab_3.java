package Lab_3;

import java.util.*;
import static GetValid.GetValidInt.getValidInt;
import static GetValid.GetValidDouble.getValidDouble;

public class Lab_3 {

    public static void sortRoutes(List<ITINERARY> routes) {
        int n = routes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (routes.get(j).getDISTANCE() < routes.get(j + 1).getDISTANCE()) {
                    ITINERARY temp = routes.get(j);
                    routes.set(j, routes.get(j + 1));
                    routes.set(j + 1, temp);
                }
            }
        }
    }

    public static void lab_3() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Введіть кількість маршрутів: ");
        int N = scan.nextInt();
        scan.nextLine();

        List<ITINERARY> routes = new ArrayList<>();
        Set<Integer> routeNumbers = new HashSet<>();

        for (int i = 0; i < N; i++) {
            System.out.println("Введіть дані для маршруту #" + (i + 1));

            System.out.print("  Початковий пункт: ");
            String first = scan.nextLine();

            System.out.print("  Кінцевий пункт: ");
            String finalDest = scan.nextLine();

            int num;
            while (true) {
                System.out.print("  Номер маршруту: ");
                num = getValidInt(scan);

                if (routeNumbers.contains(num)) {
                    System.out.println("Маршрут з таким номером вже існує! Введіть інший.");
                } else {
                    routeNumbers.add(num);
                    break;
                }
            }

            System.out.print("  Відстань (км): ");
            double distance = getValidDouble(scan);
            scan.nextLine();

            routes.add(new ITINERARY(first, finalDest, num, distance));
        }

        sortRoutes(routes);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Знайти маршрут");
            System.out.println("2. Вивести відсортований масив");
            System.out.println("3. Вийти");
            System.out.print("Оберіть опцію: ");

            int choice = getValidInt(scan);

            switch (choice) {
                case 1:
                    System.out.print("Введіть номер маршруту для пошуку: ");
                    int searchNum = getValidInt(scan);
                    boolean found = false;

                    for (ITINERARY route : routes) {
                        if (route.getNUM() == searchNum) {
                            System.out.println("\nМаршрут знайдено:");
                            route.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Маршрут з номером " + searchNum + " не знайдено.");
                    }
                    break;

                case 2:
                    System.out.println("\nВідсортований список маршрутів:");
                    for (ITINERARY route : routes) {
                        route.display();
                    }
                    break;

                case 3:
                    System.out.println("Вихід з програми.");
                    scan.close();
                    return;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }
}
