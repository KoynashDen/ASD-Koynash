package Lab_11;

import java.util.*;

public class Graph {
    int V;
    LinkedList<Edge>[] adjList;
    ArrayList<Edge> edges = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public Graph(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; ++i)
            adjList[i] = new LinkedList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        Edge e = new Edge(src, dest, weight);
        adjList[src].add(e);
        adjList[dest].add(new Edge(dest, src, weight));
        edges.add(e);
    }
}
