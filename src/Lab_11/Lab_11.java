package Lab_11;

import java.util.Scanner;

public class Lab_11 {
    public static void lab_11() {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph(10);

        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 4, 2);
        graph.addEdge(1, 2, 6);
        graph.addEdge(1, 4, 4);
        graph.addEdge(1, 5, 1);
        graph.addEdge(1, 6, 2);
        graph.addEdge(2, 6, 1);
        graph.addEdge(2, 3, 4);
        graph.addEdge(3, 7, 1);
        graph.addEdge(3, 6, 6);
        graph.addEdge(4, 5, 7);
        graph.addEdge(4, 8, 5);
        graph.addEdge(5, 6, 3);
        graph.addEdge(5, 8, 4);
        graph.addEdge(6, 8, 8);
        graph.addEdge(6, 9, 2);
        graph.addEdge(6, 7, 5);
        graph.addEdge(7, 9, 3);
        graph.addEdge(8, 9, 1);

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Алгоритм Прима");
            System.out.println("2. Алгоритм Крускала");
            System.out.println("0. Вийти");
            System.out.print("Ваш вибір: ");
            int choice = scanner.nextInt();

            PrimAlgorithm.comparisons = 0;
            KruskalAlgorithm.comparisons = 0;

            switch (choice) {
                case 1:
                    PrimAlgorithm.primMST(graph);
                    break;
                case 2:
                    KruskalAlgorithm.kruskalMST(graph);
                    break;
                case 0:
                    System.out.println("Програма завершена.");
                    return;
                default:
                    System.out.println("Невірний вибір!");
            }
        }
    }
}
