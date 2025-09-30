package Graphs;

import java.util.ArrayList;

public class DfsInGraph {

    public static void createGraph(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int v){
        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }

               /* Connected Graph */
        graph.get(0).add(new CreateGraphs.Edge(0, 1));
        graph.get(0).add(new CreateGraphs.Edge(0, 2));

        graph.get(1).add(new CreateGraphs.Edge(1, 0));
        graph.get(1).add(new CreateGraphs.Edge(1, 3));

        graph.get(2).add(new CreateGraphs.Edge(2, 0));
        graph.get(2).add(new CreateGraphs.Edge(2, 4));

        graph.get(3).add(new CreateGraphs.Edge(3, 1));
        graph.get(3).add(new CreateGraphs.Edge(3, 4));
        graph.get(3).add(new CreateGraphs.Edge(3, 5));

        graph.get(4).add(new CreateGraphs.Edge(4, 2));
        graph.get(4).add(new CreateGraphs.Edge(4, 3));
        graph.get(4).add(new CreateGraphs.Edge(4, 5));

        graph.get(5).add(new CreateGraphs.Edge(5, 3));
        graph.get(5).add(new CreateGraphs.Edge(5, 4));
        graph.get(5).add(new CreateGraphs.Edge(5, 6));

        graph.get(6).add(new CreateGraphs.Edge(6,5 ));

                /*  Disconnected Graph  */
//        graph.get(0).add(new CreateGraphs.Edge(0, 1));
//        graph.get(1).add(new CreateGraphs.Edge(1, 2));
//        graph.get(3).add(new CreateGraphs.Edge(3, 4));
//        graph.get(4).add(new CreateGraphs.Edge(4, 5));


    }

    public static void dfs(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int curr, boolean[] vis){
        System.out.print(curr + " ");
        vis[curr] = true;

        for(CreateGraphs.Edge e : graph.get(curr)){
            int nbr = e.dest;
            if(!vis[e.dest])
              dfs(graph, nbr, vis);
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<CreateGraphs.Edge>> graph = new ArrayList<>();
        boolean[] vis = new boolean[v];

        createGraph(graph, v);

        /*
         * Performs DFS on a connected graph.
         */
        for(int i = 0; i < v; i++) {
            if(!vis[i])
              dfs(graph, i, vis);
        }
    }
}
