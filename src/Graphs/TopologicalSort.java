package Graphs;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

//    Topological Sorting of a directed graph is an ordering of its vertices such that for every directed edge
//    𝑢→𝑣, vertex u comes before 𝑣 in the ordering.
//    ✅ Only applies to Directed Acyclic Graphs (DAGs) — if the graph has a cycle, topological sorting is impossible.
//    Common uses: task scheduling, course prerequisites, build systems, dependency resolution.

    public static void createGraph(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int v){
        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(2).add(new CreateGraphs.Edge(2, 3));

        graph.get(3).add(new CreateGraphs.Edge(3, 1));

        graph.get(4).add(new CreateGraphs.Edge(4, 0));
        graph.get(4).add(new CreateGraphs.Edge(4, 1));

        graph.get(5).add(new CreateGraphs.Edge(5, 0));
        graph.get(5).add(new CreateGraphs.Edge(5, 2));
    }

    private static void topSort(ArrayList<ArrayList<CreateGraphs.Edge>> graph, boolean[] vis, int curr, Stack<Integer> st){   // O(V+E)
        vis[curr] = true;

        for (CreateGraphs.Edge e : graph.get(curr)){
            int nbr = e.dest;
            if(!vis[nbr]){
                topSort(graph, vis, nbr, st);
            }
        }

        st.push(curr);
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<CreateGraphs.Edge>> graph = new ArrayList<>();
        boolean[] vis = new boolean[v];
        Stack<Integer> st = new Stack<>();

        createGraph(graph, v);

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topSort(graph, vis, i, st);
            }
        }

        while(!st.isEmpty()){
            int n = st.pop();
            System.out.print(n + " ");
        }
    }
}
