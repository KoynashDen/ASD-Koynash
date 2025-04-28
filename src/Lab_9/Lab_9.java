package Lab_9;
import java.util.*;
    
public class Lab_9 {
    static final int INF = 999999;
    static final int V = 7;

    static int[][] graph = {
            //a b  c  d  e  f  g
            {0, 1, 1, 0, 0, 0, 0},  // a
            {1, 0, 0, 1, 0, 0, 0},  // b
            {1, 0, 0, 0, 0, 1, 1},  // c
            {0, 1, 0, 0, 0, 1, 1},  // d
            {0, 0, 0, 0, 0, 1, 0},  // e
            {0, 0, 1, 1, 1, 0, 1},  // f
            {0, 0, 1, 1, 0, 1, 0}   // g
    };

    static int dijkstra(int start, int end) {
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 0; i < V; i++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        return dist[end];
    }

    static int minDistance(int[] dist, boolean[] visited) {
        int min = INF, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] <= min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    static int[][] floyd() {
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j)
                    dist[i][j] = 0;
                else if (graph[i][j] != 0)
                    dist[i][j] = graph[i][j];
                else
                    dist[i][j] = INF;
            }
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        return dist;
    }

    public static void lab_9() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть початкову вершину (a-g): ");
        char startChar = scanner.next().toLowerCase().charAt(0);

        System.out.print("Введіть кінцеву вершину (a-g): ");
        char endChar = scanner.next().toLowerCase().charAt(0);

        int start = startChar - 'a';
        int end = endChar - 'a';

        if (start < 0 || start >= V || end < 0 || end >= V) {
            System.out.println("Некоректне введення вершин!");
            return;
        }

        int dijkstraDist = dijkstra(start, end);
        System.out.println("Найкоротший шлях (Дейкстра) з " + startChar + " до " + endChar + ": " + dijkstraDist);

        int[][] fw = floyd();
        System.out.println("Найкоротший шлях (Флойд) з " + startChar + " до " + endChar + ": " + fw[start][end]);
    }
}
