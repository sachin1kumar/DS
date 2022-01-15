package BT;

public class LCABST {

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        System.out.println(getLCA(root, 3, 9).getData());
    }
    //O(h)
    private static BinaryTree getLCA(BinaryTree root, int a, int b) {
        if (root == null) {
            return null;
        }

        if (a <= root.getData() && root.getData() <= b) {
            return root;
        }

        if (a < root.getData() && b < root.getData()) {
            return getLCA(root.getLeft(), a, b);
        } else {
            return getLCA(root.getRight(), a, b);
        }
    }
}
