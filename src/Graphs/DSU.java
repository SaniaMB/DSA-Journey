package Graphs;
import java.util.Arrays;

public class DSU {
    int[] parent;
    int[] rank;

    // Constructor
    DSU(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;   // each node is its own parent
            rank[i] = 1;     // initial rank = 1
        }
    }

    // FIND with path compression
    int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]); // compress path
        }
        return parent[x];
    }

    // UNION by rank
    boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return false; // already in same set

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }

        return true;
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // If union fails → edge forms a cycle → redundant
            if (!dsu.union(u, v)) {
                return edge;
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        DSU dsu = new DSU(7); // let's say we have 7 nodes (1 to 7)

        // Perform unions
        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(4, 5);
        dsu.union(6, 7);
        dsu.union(5, 6);

        // Check connectivity
        System.out.println("Parent of 3: " + dsu.find(3));   // should point to 1
        System.out.println("Parent of 7: " + dsu.find(7));  // should point to 4
        System.out.println();

        System.out.println("Are 1 and 3 connected? " + (dsu.find(1) == dsu.find(3)));
        System.out.println("Are 3 and 5 connected? " + (dsu.find(3) == dsu.find(5)));
        System.out.println();

        // Try to union already connected nodes
        boolean merged = dsu.union(3, 1);
        System.out.println("Trying to union 3 and 1 again: " + merged); // false, cycle
        System.out.println();

        // Example 1
        int[][] edges1 = {
                {1, 2},
                {1, 3},
                {2, 3}
        };

        int[] redundant1 = findRedundantConnection(edges1);
        System.out.println("Redundant edge: " + Arrays.toString(redundant1));
    }
}



