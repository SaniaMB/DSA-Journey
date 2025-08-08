package Trees;
import Trees.BinaryTree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class SumNodesAtK {
    // Sum of the nodes at Kth level
    public static int sumNodesK(Node root, int k) {
        if (root == null) return 0;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        int sum = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                if (level == k) {
                    assert curr != null;
                    sum += curr.data;
                }
                assert curr != null;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }

            if (level == k) break;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree.Node root = BinaryTree.buildTree(nodes);
        System.out.println(sumNodesK(root,2));
    }
}
