package Graphs;
import Graphs.DijkstrasAlgo.Pair;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFord {
    // Doesn't work for negative weight cycles
    // In fact we can never calculate the shortest distance in a graph which has a negative weight cycle

    public static void createGraph(ArrayList<ArrayList<Pair>> graph, int V){
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair(1,2));
        graph.get(0).add(new Pair(2,4));

        graph.get(1).add(new Pair(2,-4));

        graph.get(2).add(new Pair(3,2));

        graph.get(3).add(new Pair(4,4));

        graph.get(4).add(new Pair(1,-1));
    //  graph.get(4).add(new Pair(1,-10));  /* To check negative wt cycle */

    }

    private static void bellmanFord(ArrayList<ArrayList<Pair>> graph, int src, int V){  // O(V * E)
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i = 0; i < V-1; i++){
            for (int u = 0; u < V; u++) {            // loop over all vertices
                for (Pair e : graph.get(u)) {         // relax all outgoing edges
                    int v = e.node;
                    int wt = e.wt;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                        dist[v] = dist[u] + wt;
                    }
                }
            }
        }

        /* Checking if the graph has a negative weight cycle by running the loop one more time to see if it updates,
         if it does, then it has a cycle, if it doesn't it means there are no cycles */

        for (int u = 0; u < V; u++) {            // loop over all vertices
            for (Pair e : graph.get(u)) {         // relax all outgoing edges
                int v = e.node;
                int wt = e.wt;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    // dist[v] = dist[u] + wt;
                    System.out.println("Negative wt Cycle!");
                }
            }
        }

        for (int i = 0; i < V; i++){
            System.out.print(dist[i] + " ");
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        createGraph(graph, V);
        bellmanFord(graph, 0, V);
    }
}
