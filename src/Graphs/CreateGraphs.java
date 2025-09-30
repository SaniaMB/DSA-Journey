package Graphs;

import java.util.ArrayList;

public class CreateGraphs {

   public static class Edge{
        int src;
        int dest;

        public Edge(int src, int dest){
            this.src = src;
            this.dest = dest;
        }
    }

   public static void createGraph(ArrayList<ArrayList<Edge>> graph, int v){
        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }

//       graph.get(0).add(new Edge(0, 2));
//
//       graph.get(1).add(new Edge(1, 2));
//       graph.get(1).add(new Edge(1, 3));
//
//       graph.get(2).add(new Edge(2, 0));
//       graph.get(2).add(new Edge(2, 1));
//       graph.get(2).add(new Edge(2, 3));
//
//       graph.get(3).add(new Edge(3, 1));
//       graph.get(3).add(new Edge(3, 2));

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

    public static void main(String[] args) {
        int v = 7;

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        createGraph(graph, v);

        for (int i = 0; i < v; i++) {
            for (Edge e : graph.get(i)) {
                System.out.println( i + "->" + e.dest + " ");
            }
        }


    }
}
