package Lab_5;
import java.util.Scanner;
import static GetValid.GetValidInt.getValidInt;

public class Lab_5 {
    public static void lab_5() {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();

        System.out.println("Введіть кількість елементів у списку:");
        int n = getValidInt(scanner);

        System.out.println("Введіть елементи списку:");
        for (int i = 0; i < n; i++) {
            int value = getValidInt(scanner);
            dll.append(value);
        }

        System.out.println("Введіть значення PX:");
        int pxValue = getValidInt(scanner);

        System.out.println("Введіть значення PY:");
        int pyValue = getValidInt(scanner);

        Node px = dll.findNode(pxValue);
        Node py = dll.findNode(pyValue);

        Node[] result = dll.moveBetween(px, py);

        System.out.print("Оригінальний список після змін: ");
        dll.printList(result[0]);

        System.out.print("Новий список: ");
        if (result[1] != null) {
            dll.printList(result[1]);
        } else {
            System.out.println("nil");
        }

        scanner.close();
    }
}
