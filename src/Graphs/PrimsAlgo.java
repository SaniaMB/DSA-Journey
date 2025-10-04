package Graphs;
import Graphs.DijkstrasAlgo.Pair;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgo {

    public static void createGraph(ArrayList<ArrayList<Pair>> graph, int V){
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Pair(1,10));
        graph.get(0).add(new Pair(2,15));
        graph.get(0).add(new Pair(3,30));

        graph.get(1).add(new Pair(0,10));
        graph.get(1).add(new Pair(3,40));

        graph.get(2).add(new Pair(0,15));
        graph.get(2).add(new Pair(3,50));

        graph.get(3).add(new Pair(1,40));
        graph.get(3).add(new Pair(2,50));

    }

    private static void primsAlgo(ArrayList<ArrayList<Pair>> graph, int V){   // O (E log E)
        PriorityQueue<Pair> pq = new PriorityQueue<>(); // non mst
        boolean[] vis = new boolean[V]; // mst
        pq.add(new Pair(0,0));
        int mstCost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(vis[curr.node]) continue;

            vis[curr.node] = true;
            mstCost += curr.wt;

            for(Pair e : graph.get(curr.node)) {
                if (!vis[e.node]) {
                    pq.add(new Pair(e.node, e.wt));
                }
            }
        }

        System.out.println("Mst Cost: " + mstCost);
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        createGraph(graph, V);
        primsAlgo(graph, V);

    }
}
