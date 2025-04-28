package Lab_11;

import java.util.*;

public class KruskalAlgorithm {
    public static int comparisons = 0;

    static int find(int[] parent, int i) {
        if (parent[i] != i)
            parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    static void union(int[] parent, int[] rank, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        if (rank[xroot] < rank[yroot])
            parent[xroot] = yroot;
        else if (rank[xroot] > rank[yroot])
            parent[yroot] = xroot;
        else {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }

    public static void kruskalMST(Graph graph) {
        ArrayList<Edge> result = new ArrayList<>();
        Collections.sort(graph.edges);

        int[] parent = new int[graph.V];
        int[] rank = new int[graph.V];
        for (int v = 0; v < graph.V; ++v) {
            parent[v] = v;
            rank[v] = 0;
        }

        for (Edge nextEdge : graph.edges) {
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            comparisons++;
            if (x != y) {
                result.add(nextEdge);
                union(parent, rank, x, y);
            }
        }

        System.out.println("Остовне дерево (Крускала):");
        int totalWeight = 0;
        for (Edge e : result) {
            System.out.println(e.src + " - " + e.dest + " (вага: " + e.weight + ")");
            totalWeight += e.weight;
        }
        System.out.println("Загальна вага: " + totalWeight);
        System.out.println("Кількість порівнянь: " + comparisons);
    }
}
