package Graphs;

import java.util.ArrayList;

public class TarjansAlgo {

    public static void createGraph(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int v){
        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new CreateGraphs.Edge(0, 1));
        graph.get(0).add(new CreateGraphs.Edge(0, 2));
        graph.get(0).add(new CreateGraphs.Edge(0, 3));

        graph.get(1).add(new CreateGraphs.Edge(1, 0));
        graph.get(1).add(new CreateGraphs.Edge(1, 2));

        graph.get(2).add(new CreateGraphs.Edge(2, 0));
        graph.get(2).add(new CreateGraphs.Edge(2, 1));

        graph.get(3).add(new CreateGraphs.Edge(3, 0));
        graph.get(3).add(new CreateGraphs.Edge(3, 4));
       // graph.get(3).add(new CreateGraphs.Edge(3, 5));

        graph.get(4).add(new CreateGraphs.Edge(4, 3));
//      graph.get(4).add(new CreateGraphs.Edge(4, 5));
//
//      graph.get(5).add(new CreateGraphs.Edge(5, 3));
//      graph.get(5).add(new CreateGraphs.Edge(5, 4));

    }

    private static void dfs(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int curr, boolean[] vis, int[] dt,
                            int[] low,int time, int par){          // O(V + E)

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(CreateGraphs.Edge e : graph.get(curr)){
            if(e.dest == par)
                continue;
            else if (!vis[e.dest]){
                dfs(graph, e.dest, vis, dt, low, time, curr);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if(dt[curr] < low[e.dest])
                    System.out.println("Bridge " + curr + " ----- " + e.dest);
            }else
               low[curr] = Math.min(low[curr], dt[e.dest]);
        }
    }

    public static void getBridge(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int v){
        int[] dt = new int[v];
        int[] low = new int[v];
        boolean[] vis = new boolean[v];
        int time = 0;

        for(int i = 0; i < v; i++){
            if(!vis[i])
              dfs(graph, i, vis, dt, low, time, -1);
        }
    }

    public static void main(String[] args) {
     int v = 6;
     ArrayList<ArrayList<CreateGraphs.Edge>> graph = new ArrayList<>();

     createGraph(graph, v);
     getBridge(graph, v);

    }
}
