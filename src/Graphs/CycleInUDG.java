package Graphs;

import java.util.ArrayList;

public class CycleInUDG {
    // Cycle detection in an undirected graph

    public static void createGraph(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int v){
        for(int i = 0; i < v; i++ ){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new CreateGraphs.Edge(0, 1));
        graph.get(0).add(new CreateGraphs.Edge(0, 4));

        graph.get(1).add(new CreateGraphs.Edge(1, 0));
        graph.get(1).add(new CreateGraphs.Edge(1, 2));
        // graph.get(1).add(new CreateGraphs.Edge(1, 4));

        graph.get(2).add(new CreateGraphs.Edge(2, 1));
        graph.get(2).add(new CreateGraphs.Edge(2, 3));

        graph.get(3).add(new CreateGraphs.Edge(3, 2));

        graph.get(4).add(new CreateGraphs.Edge(4, 0));
       // graph.get(4).add(new CreateGraphs.Edge(4, 1));
        graph.get(4).add(new CreateGraphs.Edge(4, 5));

        graph.get(5).add(new CreateGraphs.Edge(5, 4));
    }

    private static boolean dfs( ArrayList<ArrayList<CreateGraphs.Edge>> graph, boolean[] vis, int curr, int par){
        vis[curr] = true;

        for(CreateGraphs.Edge e : graph.get(curr)){
            int nbr = e.dest;

            if (vis[nbr] && (par != e.dest)) {   // back edge found
                return true;
            }
            if(!vis[nbr]){
                if(dfs(graph, vis, nbr, curr)) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<CreateGraphs.Edge>> graph = new ArrayList<>();
        boolean[] vis = new boolean[v];

        createGraph(graph, v);

        for(int i = 0; i < v; i++){
            if (!vis[i]) {
              boolean isCycle = dfs(graph, vis, i, -1);
              System.out.println(isCycle);
            }
        }
    }
}

