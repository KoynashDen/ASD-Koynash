package Lab_4;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Lab_4 {
    private static List<Player> mainTeam = new LinkedList<>();
    private static List<Player> reserveTeam = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);


    private static void addPlayer(List<Player> team, String teamName) {
        System.out.print("Введіть прізвище гравця: ");
        String lastName = scanner.nextLine();
        team.add(new Player(lastName));
        System.out.println("Гравця додано до " + teamName + ".");
    }

    private static void removePlayer() {
        System.out.print("Введіть прізвище гравця для видалення: ");
        String lastName = scanner.nextLine();
        if (mainTeam.removeIf(player -> player.lastName.equals(lastName)) ||
                reserveTeam.removeIf(player -> player.lastName.equals(lastName))) {
            System.out.println("Гравця видалено.");
        } else {
            System.out.println("Гравця не знайдено.");
        }
    }

    private static void substitutePlayer() {
        System.out.print("Введіть прізвище гравця, якого замінюємо (основний склад): ");
        String outPlayer = scanner.nextLine();
        System.out.print("Введіть прізвище гравця, який виходить на поле (запасний склад): ");
        String inPlayer = scanner.nextLine();

        int outIndex = -1;
        int inIndex = -1;

        for (int i = 0; i < mainTeam.size(); i++) {
            if (mainTeam.get(i).lastName.equals(outPlayer)) {
                outIndex = i;
                break;
            }
        }

        for (int i = 0; i < reserveTeam.size(); i++) {
            if (reserveTeam.get(i).lastName.equals(inPlayer)) {
                inIndex = i;
                break;
            }
        }

        if (outIndex != -1 && inIndex != -1) {
            Player temp = mainTeam.get(outIndex);
            mainTeam.set(outIndex, reserveTeam.get(inIndex));
            reserveTeam.set(inIndex, temp);
            System.out.println("Заміна проведена.");
        } else {
            System.out.println("Гравця не знайдено в основному або запасному складі.");
        }
    }

    private static void searchPlayer() {
        System.out.print("Введіть прізвище гравця для пошуку: ");
        String lastName = scanner.nextLine();

        for (Player player : mainTeam) {
            if (player.lastName.equals(lastName)) {
                System.out.println("Гравець є у складі: основний склад.");
                return;
            }
        }

        for (Player player : reserveTeam) {
            if (player.lastName.equals(lastName)) {
                System.out.println("Гравець є у складі: запасний склад.");
                return;
            }
        }

        System.out.println("Гравця не знайдено.");
    }

    private static void printTeams() {
        System.out.println("Основний склад: " + mainTeam);
        System.out.println("Запасний склад: " + reserveTeam);
    }


    public static void lab_4() {
        boolean running = true;
        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Додати гравця до основного складу");
            System.out.println("2. Додати гравця до запасного складу");
            System.out.println("3. Видалити гравця");
            System.out.println("4. Провести заміну");
            System.out.println("5. Пошук гравця");
            System.out.println("6. Вивести списки гравців");
            System.out.println("0. Вийти");
            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addPlayer(mainTeam, "основний склад");
                case 2 -> addPlayer(reserveTeam, "запасний склад");
                case 3 -> removePlayer();
                case 4 -> substitutePlayer();
                case 5 -> searchPlayer();
                case 6 -> printTeams();
                case 0 -> running = false;
                default -> System.out.println("Невірний вибір!");
            }
        }
    }
}
