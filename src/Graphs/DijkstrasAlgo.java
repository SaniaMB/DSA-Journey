package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasAlgo{
//        Doesn't work for negative weights

    public static void createGraph(ArrayList<ArrayList<WeightedG.Edge>> graph, int v){
        for(int i = 0; i < v; i ++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new WeightedG.Edge(0, 1, 2));
        graph.get(0).add(new WeightedG.Edge(0, 2, 4));

        graph.get(1).add(new WeightedG.Edge(1, 3, 7));
        graph.get(1).add(new WeightedG.Edge(1, 2, 1));

        graph.get(2).add(new WeightedG.Edge(2, 4, 3));

        graph.get(3).add(new WeightedG.Edge(3, 5, 1));

        graph.get(4).add(new WeightedG.Edge(4, 3, 2));
        graph.get(4).add(new WeightedG.Edge(4, 5, 5));

    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int wt;

        public Pair(int node, int wt){
            this.node = node;
            this.wt = wt;
        }

        @Override
        public int compareTo(Pair other){
            return Integer.compare(this.wt, other.wt); // ascending
        //  return Integer.compare(other.dist, this.dist); // descending
        }
    }

    private static void dijkstras(ArrayList<ArrayList<WeightedG.Edge>> graph, int src, int V){  // O( E + E log V)
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        boolean[] vis = new boolean[V];

        pq.add(new Pair(src, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();

            if (vis[curr.node]) continue;
            vis[curr.node] = true;

            for(WeightedG.Edge e : graph.get(curr.node)){
                int u = curr.node;
                int v = e.dest;

                if(dist[u] + e.wt < dist[v]) {   // Relaxation
                    dist[v] = dist[u] + e.wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        for (int i = 0; i < V; i++){
            System.out.println("Distance from " + src + " to " + i + " = " + dist[i]);
        }

    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<WeightedG.Edge>> graph = new ArrayList<>();
        createGraph(graph, V);

        dijkstras(graph, 0, V);
    }
}
