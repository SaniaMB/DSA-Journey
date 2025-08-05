package Trees;
import Trees.BinaryTree.Node;

public class SumNodesBT{
    public static int sumNodes(Node root){
        if(root == null) return 0;

        int leftSum = sumNodes(root.left);
        int rightSum = sumNodes(root.right);

        return leftSum + rightSum + root.data ;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree.Node root = BinaryTree.buildTree(nodes);
        System.out.println(sumNodes(root));
    }
}