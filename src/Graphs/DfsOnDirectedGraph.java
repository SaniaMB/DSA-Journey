package Graphs;

import java.util.ArrayList;

public class DfsOnDirectedGraph {

    public static void createGraph(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int v) {
        for (int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        /* Directed Graph */
        graph.get(0).add(new CreateGraphs.Edge(0, 2));

        graph.get(1).add(new CreateGraphs.Edge(1, 0));

        graph.get(2).add(new CreateGraphs.Edge(2, 3));

        graph.get(3).add(new CreateGraphs.Edge(3, 0));

    }

    public static boolean isCycle(ArrayList<ArrayList<CreateGraphs.Edge>> graph, boolean[] vis, boolean[] rec, int curr){
        vis[curr] = true;
        rec[curr] = true;

        for(CreateGraphs.Edge e : graph.get(curr)){
            int nbr = e.dest;
            if(rec[nbr]){
                return true;
            }else if(!vis[nbr]){
               if(isCycle(graph,vis,rec,nbr)) return true;
            }
        }

        rec[curr] = false;
        return false;
    }

        public static void main(String[] args) {
        int v = 4;

        ArrayList<ArrayList<CreateGraphs.Edge>> graph = new ArrayList<>();
        createGraph(graph, v);

            System.out.println(isCycle(graph, new boolean[v], new boolean[v], 0));
    }
}
