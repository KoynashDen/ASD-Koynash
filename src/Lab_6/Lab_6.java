package Lab_6;
import java.util.Scanner;

public class Lab_6 {
    public static void lab_6() {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();

        while (true) {
            System.out.println("Оберіть дію: \n1 - додати в чергу \n2 - видалити з черги \n3 - вивести чергу \n4 - довжина рядків \n5 - вихід");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введіть текст для додавання: ");
                    String text = scanner.nextLine();
                    queue.enqueue(text);
                    break;
                case 2:
                    String removed = queue.dequeue();
                    if (removed != null) {
                        System.out.println("Видалено: " + removed);
                    } else {
                        System.out.println("Черга порожня!");
                    }
                    break;
                case 3:
                    System.out.println("Вміст черги:");
                    queue.printQueue();
                    break;
                case 4:
                    System.out.println("Загальна довжина рядків у черзі: " + queue.getTotalLength());
                    break;
                case 5:
                    System.out.println("Завершення програми.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Невірний вибір, спробуйте ще раз.");
            }
        }
    }
}
