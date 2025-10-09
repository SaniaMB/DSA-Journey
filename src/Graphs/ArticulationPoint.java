package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

import Graphs.CreateGraphs.Edge;

public class ArticulationPoint {    // Using Tarjans Algo

    public static void createGraph(ArrayList<ArrayList<Edge>> graph, int v){
        for(int i = 0; i < v ; i ++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new Edge(0, 1));
        graph.get(0).add(new Edge(0, 2));
        graph.get(0).add(new Edge(0, 3));

        graph.get(1).add(new Edge(1, 0));
        graph.get(1).add(new Edge(1, 2));

        graph.get(2).add(new Edge(2, 0));
        graph.get(2).add(new Edge(2, 1));

        graph.get(3).add(new Edge(3, 0));
        graph.get(3).add(new Edge(3, 4));

        graph.get(4).add(new Edge(4, 3));

    }

    private static void dfs(ArrayList<ArrayList<Edge>> graph, int curr, int[] dt, int[] low,
                            boolean[] vis, int time, int par, boolean[] isAp){           // O(V + E)

        vis[curr] = true;
        dt[curr] = low[curr] = ++time;
        int children = 0;

        for(Edge e : graph.get(curr)){
            if(e.dest == par)
                continue;
            else if(vis[e.dest])
                low[curr] = Math.min(low[curr], dt[e.dest]);
            else{
                dfs(graph, e.dest, dt, low, vis, time, curr, isAp);
                low[curr] = Math.min(low[curr], low[e.dest]);
                if(par != -1 && dt[curr] <= low[e.dest])
                    isAp[curr] = true;
                children++;
            }
        }

        if(par == -1 && children > 1){
            isAp[curr] = true;
        }
    }

    private static void getAp( ArrayList<ArrayList<Edge>> graph, int v){
        int[] dt = new int[v];
        int[] low = new int[v];
        boolean[] vis = new boolean[v];
        int time = 0;
        boolean[] isAp = new boolean[v];

        for (int i = 0; i < v; i++){
            if(!vis[i])
                dfs(graph, i, dt, low, vis, time, -1, isAp);
        }

        for (int i = 0; i < v; i++) {
            if(isAp[i])
               System.out.println("Ap: " + i);
        }

    }

    public static void main(String[] args){
        int v = 5;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

        createGraph(graph, v);
        getAp(graph, v);
    }
}
