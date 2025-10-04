package Graphs;

import java.util.*;

public class KosarajusAlgo{
    // A Strongly Connected Component (SCC) in a directed graph is a maximal group of vertices such that every vertex is reachable from every other vertex in the group.
    // In simple words: inside an SCC, you can travel both ways between any two nodes.
    //  TC of KA -> O( V + E)

    /* Steps in this Algorithm
    1. Get the nodes in a stack (topological order)
    2. Transpose the graph
    3. Do DFS according to stack on the transposed graph
    */

    public static void createGraph(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int v){
        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new CreateGraphs.Edge(0, 2));
        graph.get(0).add(new CreateGraphs.Edge(0, 3));

        graph.get(1).add(new CreateGraphs.Edge(1, 0));

        graph.get(2).add(new CreateGraphs.Edge(2, 1));

        graph.get(3).add(new CreateGraphs.Edge(3, 4));

    }

    public static void topSort(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int curr, boolean[] vis, Deque<Integer> stack){
        vis[curr] = true;

        for(CreateGraphs.Edge e : graph.get(curr)){
            if(!vis[e.dest])
                topSort(graph, e.dest, vis, stack);
        }

        stack.push(curr);
    }

    public static void dfs(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int curr, boolean[] vis){
        vis[curr] = true;
        System.out.print(curr + " ");

        for(CreateGraphs.Edge e : graph.get(curr)){
            if(!vis[e.dest])
                dfs(graph, e.dest, vis);
        }
    }

    private static void kosarajuAlgo(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int v){
        // Step 1 O(V +E)
        Deque<Integer> st = new ArrayDeque<>();
        boolean[] vis = new boolean[v];

        for(int i = 0; i < v; i++){
            if(!vis[i])
                topSort(graph, i, vis, st);
        }

        // Step2 O(V +E)
        ArrayList<ArrayList<CreateGraphs.Edge>> transpose = new ArrayList<>();
        for(int i = 0; i < v; i++){
            vis[i] = false;
            transpose.add(new ArrayList<>());
        }

        for(int i= 0; i < v; i++){
            for(CreateGraphs.Edge e : graph.get(i)){
                transpose.get(e.dest).add(new CreateGraphs.Edge(e.dest, e.src));
            }
        }

       // Step3 O(V +E)
        while(!st.isEmpty()){
            int curr = st.pop();
            if(!vis[curr]){
                dfs(transpose, curr, vis);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<CreateGraphs.Edge>> graph = new ArrayList<>();

        createGraph(graph, v);
        kosarajuAlgo(graph, v);

    }
}
