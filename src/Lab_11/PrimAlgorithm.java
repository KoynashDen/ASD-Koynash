package Lab_11;

import java.util.*;

public class PrimAlgorithm {
    public static int comparisons = 0;

    public static void primMST(Graph graph) {
        int V = graph.V;
        boolean[] inMST = new boolean[V];
        int[] key = new int[V];
        int[] parent = new int[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        pq.add(new Edge(-1, 0, 0));

        while (!pq.isEmpty()) {
            Edge u = pq.poll();
            inMST[u.dest] = true;

            for (Edge e : graph.adjList[u.dest]) {
                comparisons++;
                if (!inMST[e.dest] && e.weight < key[e.dest]) {
                    key[e.dest] = e.weight;
                    pq.add(new Edge(u.dest, e.dest, e.weight));
                    parent[e.dest] = u.dest;
                }
            }
        }

        System.out.println("Остовне дерево (Прима):");
        int totalWeight = 0;
        for (int i = 1; i < V; ++i) {
            System.out.println(parent[i] + " - " + i + " (вага: " + key[i] + ")");
            totalWeight += key[i];
        }
        System.out.println("Загальна вага: " + totalWeight);
        System.out.println("Кількість порівнянь: " + comparisons);
    }
}
