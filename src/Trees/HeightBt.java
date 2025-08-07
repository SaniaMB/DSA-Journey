package Trees;
import Trees.BinaryTree.Node;

public class HeightBt {
    public static int height(Node root) {
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight,rightHeight) + 1;
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree.Node root = BinaryTree.buildTree(nodes);
        System.out.println(height(root));
    }
}
