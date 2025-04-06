package Lab_7;

import java.util.*;

class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

public class Lab_7 {
    static Scanner scanner = new Scanner(System.in);
    Node root;

    Node insert(Node node, int key) {
        if (node == null) return new Node(key);
        if (key < node.key) node.left = insert(node.left, key);
        else if (key > node.key) node.right = insert(node.right, key);
        return node;
    }

    boolean search(Node node, int key) {
        if (node == null) return false;
        if (node.key == key) return true;
        return key < node.key ? search(node.left, key) : search(node.right, key);
    }

    int minValue(Node node) {
        int minv = node.key;
        while (node.left != null) {
            minv = node.left.key;
            node = node.left;
        }
        return minv;
    }

    Node delete(Node root, int key) {
        if (root == null) return root;
        if (key < root.key) root.left = delete(root.left, key);
        else if (key > root.key) root.right = delete(root.right, key);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.key = minValue(root.right);
            root.right = delete(root.right, root.key);
        }
        return root;
    }

    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.key + " ");
            inorder(node.right);
        }
    }


    void printAttributes(Node node, Node parent) {
        if (node != null) {
            String type = "";
            if (parent == null) type = "К";
            else if (node.left == null && node.right == null) type = "А";
            else type = "П";

            System.out.println("Вершина: " + node.key + " | Тип: " + type);

            printAttributes(node.left, node);
            printAttributes(node.right, node);
        }
    }


    void winningTickets() {
        Node ticketTree = null;

        for (int i = 1000; i <= 9999; i++) {
            int sum = Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();
            if (sum % 4 == 0) {
                ticketTree = insert(ticketTree, i);
            }
        }

        System.out.println("Виграшні квитки (за спаданням):");
        printDescending(ticketTree);
    }


    void printDescending(Node node) {
        if (node != null) {
            printDescending(node.right);
            System.out.print(node.key + " ");
            printDescending(node.left);
        }
    }


    void menu() {
        int choice;
        do {
            System.out.println("\n=== Меню ===");
            System.out.println("1. Додати елемент");
            System.out.println("2. Видалити елемент");
            System.out.println("3. Пошук елемента");
            System.out.println("4. Обхід дерева (in-order)");
            System.out.println("5. Атрибути вершин");
            System.out.println("6. Завдання 2: Виграшні квитки");
            System.out.println("0. Вихід");
            System.out.print("Виберіть опцію: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введіть значення для додавання: ");
                    int addKey = scanner.nextInt();
                    root = insert(root, addKey);
                    break;
                case 2:
                    System.out.print("Введіть значення для видалення: ");
                    int delKey = scanner.nextInt();
                    root = delete(root, delKey);
                    break;
                case 3:
                    System.out.print("Введіть значення для пошуку: ");
                    int searchKey = scanner.nextInt();
                    boolean found = search(root, searchKey);
                    System.out.println(found ? "Елемент знайдено" : "Елемент не знайдено");
                    break;
                case 4:
                    System.out.println("Обхід дерева:");
                    inorder(root);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Атрибути вершин:");
                    printAttributes(root, null);
                    break;
                case 6:
                    winningTickets();
                    break;
                case 0:
                    System.out.println("Вихід.");
                    break;
                default:
                    System.out.println("Невірний вибір!");
            }
        } while (choice != 0);
    }

    public static void lab_7() {
        Lab_7 tree = new Lab_7();
        tree.menu();
    }
}
