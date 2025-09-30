package Graphs;

import java.util.ArrayList;

public class WeightedG {
    public static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph( ArrayList<ArrayList<Edge>> graph , int v){
        // Adja cency List

        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(0, 2, 2));

        graph.get(1).add(new Edge(1, 2, 10));
        graph.get(1).add(new Edge(1, 3, 0));

        graph.get(2).add(new Edge(2, 0, 2));
        graph.get(2).add(new Edge(2, 1, 10));
        graph.get(2).add(new Edge(2, 3, -1));

        graph.get(3).add(new Edge(3, 1, 0));
        graph.get(3).add(new Edge(3, 2, -1));
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        createGraph(graph, v);

        for(Edge e : graph.get(2)){
            System.out.println(e.src + "->" + e.dest + " (" + e.wt + ")");
        }
    }
}
