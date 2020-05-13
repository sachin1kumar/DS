package BT;

public class MinDepth {

    private static int depth = 0;
    private static int minDepth = Integer.MAX_VALUE;

    public static void main(String[] args) {

        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        System.out.println(getDepth(root,depth));
    }

    private static int getDepth(BinaryTree root, int depth){
        if(root == null){
            return minDepth;
        }

        if(root.getLeft() == null && root.getRight() == null){
            if(depth+1<minDepth){
                minDepth = depth+1;
            }
            System.out.println(minDepth);
            System.out.println("--");
        }

        getDepth(root.getLeft(),depth+1);
        getDepth(root.getRight(),depth+1);

        return minDepth;

    }
}
