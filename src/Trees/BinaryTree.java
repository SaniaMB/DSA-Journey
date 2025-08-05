package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
   public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

        static int idx = -1;

        public static Node buildTree(int[] nodes){
            idx++;

            if(nodes[idx] == -1){
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

    // DFS
    public static void preOrder(Node root){
        if(root == null) return;

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // BFS
    public static void levelOrder(Node root){

        if(root == null){
            return;
        }

        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);

        while(!que.isEmpty()){
            Node currNode = que.remove();
            if(currNode == null){
                System.out.println();
                if(que.isEmpty()) break;
                else que.add(null);
            }else {
                System.out.print(currNode.data + " ");
                if(currNode.left != null) que.add(currNode.left);
                if(currNode.right != null) que.add(currNode.right);

            }
        }

    }
    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = buildTree(nodes);
        assert root != null;
        System.out.println("Root -> "+root.data);
        System.out.println("Preorder");
        preOrder(root);
        System.out.println();
        System.out.println("Inorder");
        inOrder(root);
        System.out.println();
        System.out.println("Postorder");
        postOrder(root);
        System.out.println();
        System.out.println("LevelOrder");
        levelOrder(root);
    }
}
