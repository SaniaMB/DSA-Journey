package Trees;
import Trees.BinaryTree.Node;
import static Trees.HeightBt.height;

public class TreeDiameter {
    // O(N^2)
    public static int diameter(Node root) {
        if(root == null) return 0;

        int leftD = diameter(root.left);
        int rightD = diameter(root.right);
        int dia3 = height(root.left) + height(root.right) + 1;

        return Math.max(dia3,Math.max(leftD,rightD));
    }

    // O(N)
    static class TreeInfo{
        int ht;
        int dia;

        TreeInfo(int ht,int dia){
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static TreeInfo diameter2(Node root){
        if(root == null) return new TreeInfo(0,0);

        TreeInfo leftH = diameter2(root.left);
        TreeInfo rightH = diameter2(root.right);

        int myH = Math.max(leftH.ht,rightH.ht) + 1;

        int dia1 = leftH.dia;
        int dia2 = rightH.dia;
        int dia3 = leftH.ht + rightH.ht + 1;

        int myDia = Math.max(dia3,Math.max(dia1,dia2));

        return new TreeInfo(myH,myDia);
    }

    public static void main(String[] args) {
        int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree.Node root = BinaryTree.buildTree(nodes);
        System.out.println(diameter2(root).dia);
    }
}
