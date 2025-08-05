package Trees;
import Trees.BinaryTree.Node;

public class CountNodesBT {
   public static int countNodes(Node root){
       if(root == null) return 0;

       int leftNodes =  countNodes(root.left);
       int rightNodes = countNodes(root.right);

       return leftNodes + rightNodes + 1;
   }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree.Node root = BinaryTree.buildTree(nodes);
        System.out.println(countNodes(root));
    }
}
