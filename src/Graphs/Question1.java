package Graphs;

import java.util.ArrayList;

public class Question1 {
    /* All paths from source to target */

    public static ArrayList<ArrayList<Integer>> path = new ArrayList<>();

    public static void createGraph(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int v) {
        for (int i = 0; i < v; i++) {
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

    }

    public static void solveDfs( ArrayList<ArrayList<CreateGraphs.Edge>> graph, boolean[] vis, int curr, int target, ArrayList<Integer> crr){
        vis[curr] = true;       // mark current node visited
        crr.add(curr);          // add current node to path          O(V⋅2^V)

        if(curr == target) {
            path.add(new ArrayList<>(crr));
        }

        for(CreateGraphs.Edge e : graph.get(curr)) {
            int nbr = e.dest;
            if (!vis[nbr]) {
                solveDfs(graph, vis, nbr, target, crr);
            }
        }

        crr.removeLast();
        vis[curr] = false;
    }

    public static void main(String[] args) {
        int v = 7;
        int target = 5;
        ArrayList<ArrayList<CreateGraphs.Edge>> graph = new ArrayList<>();
        boolean[] vis = new boolean[v];

        createGraph(graph, v);

        ArrayList<Integer> currentPath = new ArrayList<>();
        solveDfs(graph, vis, 0, target, currentPath);

        // print all paths
        System.out.println("All paths from 0 to " + target + ":");
        for (ArrayList<Integer> p : path) {
            System.out.println(p);
        }

    }
}
