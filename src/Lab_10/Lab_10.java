package Lab_10;

import java.util.*;

public class Lab_10 {
    static final int INF = 1000000;
    static int[][] graph;
    static int V;

    public static void lab_10() {
        Scanner scanner = new Scanner(System.in);
        initializeGraph();

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Пошук найкоротшого шляху (алгоритм Дейкстри)");
            System.out.println("2. Пошук найкоротшого шляху (алгоритм Флойда-Уоршелла)");
            System.out.println("3. Вийти");
            System.out.print("Виберіть опцію: ");
            int choice = scanner.nextInt();

            if (choice == 3) break;

            System.out.print("Введіть початкову вершину (0-" + (V-1) + "): ");
            int start = scanner.nextInt();
            System.out.print("Введіть кінцеву вершину (0-" + (V-1) + "): ");
            int end = scanner.nextInt();

            switch (choice) {
                case 1:
                    dijkstra(start, end);
                    break;
                case 2:
                    floydWarshall(start, end);
                    break;
                default:
                    System.out.println("Невірна опція. Спробуйте ще раз.");
            }
        }
        scanner.close();
    }

    static void initializeGraph() {
        V = 13; // 13 вершин (0-12)
        graph = new int[V][V];

        for (int i = 0; i < V; i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }


        graph[0][7] = 6;

        graph[1][0] = 4;
        graph[1][7] = 9;
        graph[1][9] = 1;
        graph[1][2] = 12;

        graph[2][9] = 8;
        graph[2][5] = 9;

        graph[3][2] = 16;
        graph[3][5] = 12;
        graph[3][4] = 4;

        graph[4][5] = 1;

        graph[5][12] = 9;

        graph[9][6] = 15;

        graph[6][5] = 2;
        graph[6][12] = 15;
        graph[6][10] = 16;

        graph[7][6] = 3;
        graph[7][8] = 2;
        graph[7][10] = 7;

        graph[8][0] = 3;

        graph[10][12] = 8;
        graph[10][11] = 9;

        graph[11][12] = 10;
    }

    static void dijkstra(int start, int end) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        int[] prev = new int[V];

        Arrays.fill(dist, INF);
        Arrays.fill(prev, -1);
        dist[start] = 0;

        for (int i = 0; i < V; i++) {
            int u = minDistance(dist, visited);
            if (u == -1) break;
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    prev[v] = u;
                }
            }
        }

        if (dist[end] == INF) {
            System.out.println("Шляху немає.");
        } else {
            System.out.println("Найкоротша відстань: " + dist[end]);
            System.out.print("Шлях: ");
            printPath(prev, end);
            System.out.println();
        }
    }

    static int minDistance(int[] dist, boolean[] visited) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    static void printPath(int[] prev, int i) {
        if (i == -1) return;
        printPath(prev, prev[i]);
        System.out.print(i + " ");
    }

    static void floydWarshall(int start, int end) {
        int[][] dist = new int[V][V];
        int[][] next = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        if (dist[start][end] == INF) {
            System.out.println("Шляху немає.");
        } else {
            System.out.println("Найкоротша відстань: " + dist[start][end]);
            System.out.print("Шлях: ");
            printFloydPath(next, start, end);
            System.out.println();
        }
    }

    static void printFloydPath(int[][] next, int u, int v) {
        if (next[u][v] == -1) {
            System.out.print("Немає шляху");
            return;
        }
        System.out.print(u);
        while (u != v) {
            u = next[u][v];
            System.out.print(" -> " + u);
        }
    }
}
