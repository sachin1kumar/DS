package BT;

public class FlatBST {

    //important
    private static BinaryTree dummyNode = new BinaryTree(-1);
    private static BinaryTree prev = dummyNode;

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        printTree(flatBST(root));
    }

    private static BinaryTree flatBST(BinaryTree root) {
        if (root == null) {
            return null;
        }

        flatBST(root.getLeft());
        //important
        prev.setRight(root);
        prev = root;

        flatBST(root.getRight());

        return dummyNode.getRight();
    }

    private static void printTree(BinaryTree root) {
        while (root != null) {
            System.out.print(root.getData()+" ");
            root = root.getRight();
        }
    }

}
