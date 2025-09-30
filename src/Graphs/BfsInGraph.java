package Graphs;
import Graphs.CreateGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsInGraph {

    public static void createGraph(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int v){
        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }

        graph.get(0).add(new CreateGraphs.Edge(0, 1));
      //  graph.get(0).add(new CreateGraphs.Edge(0, 2));

        //graph.get(1).add(new CreateGraphs.Edge(1, 0));
       // graph.get(1).add(new CreateGraphs.Edge(1, 3));
        graph.get(1).add(new CreateGraphs.Edge(1, 2));

//        graph.get(2).add(new CreateGraphs.Edge(2, 0));
//        graph.get(2).add(new CreateGraphs.Edge(2, 4));

      //  graph.get(3).add(new CreateGraphs.Edge(3, 1));
        graph.get(3).add(new CreateGraphs.Edge(3,4 ));
       // graph.get(3).add(new CreateGraphs.Edge(3, 5));

//        graph.get(4).add(new CreateGraphs.Edge(4,2 ));
//        graph.get(4).add(new CreateGraphs.Edge(4, 3));
        graph.get(4).add(new CreateGraphs.Edge(4, 5));

//        graph.get(5).add(new CreateGraphs.Edge(5, 3));
//        graph.get(5).add(new CreateGraphs.Edge(5, 4));
//        graph.get(5).add(new CreateGraphs.Edge(5,6 ));
//
//        graph.get(6).add(new CreateGraphs.Edge(6,5 ));

    }

    // BFS starting from a given vertex
    public static void bfsFromVertex(ArrayList<ArrayList<CreateGraphs.Edge>> graph, boolean[] vis, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);  // For disconnected Components

        while(!q.isEmpty()){
            int curr = q.poll();
            if(!vis[curr]){
                System.out.print(curr + " ");
                vis[curr] = true;

                for (CreateGraphs.Edge e : graph.get(curr)) {
                    int nbr = e.dest;
                    if (!vis[nbr]) {
                        q.add(nbr);
                    }
                }
            }
        }
    }

    // BFS for all components
    public static void bfs(ArrayList<ArrayList<CreateGraphs.Edge>> graph, int v){          // O(V + E)
        boolean[] vis = new boolean[v];

        for(int i = 0; i < v; i++){
            if(!vis[i]){
                System.out.print("Component starting at " + i + ": ");
                bfsFromVertex(graph, vis, i);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<CreateGraphs.Edge>> graph = new ArrayList<>();

        createGraph(graph, v);
        bfs(graph, v);

    }
}
