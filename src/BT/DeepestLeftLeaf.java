package BT;

public class DeepestLeftLeaf {

    private static int maxNode = -1;

    public static void main(String[] args) {

        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        deep(root,null);
        System.out.println("maxNode:"+maxNode);
    }

    private static void deep(BinaryTree root, BinaryTree node){

        if(root == null){
            return;
        }

        if(node!=null && node.getLeft() == root && root.getLeft() == null && root.getRight() == null){
            int nodeData = node.getLeft().getData();
            if(nodeData > maxNode){
                maxNode = nodeData;
            }
        }

        node = root;
        deep(root.getLeft(),node);
        deep(root.getRight(),node);
    }
}
