package BT;

public class InOrderPreSuc {

    private static int pre = -1;
    private static int suc = -1;

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        findPreSuc(root, 7);
        System.out.println(pre+":"+suc);
    }

    private static void findPreSuc(BinaryTree root, int target) {
        if (root == null) {
            return;
        }
        //root data is equal to target.
        if (root.getData() == target) {
            if (root.getLeft() != null) {
                findPre(root.getLeft());
            }
            if (root.getRight() != null) {
                findSuc(root.getRight());
            }
        }

        if (target < root.getData()) {
            suc = root.getData();
            findPreSuc(root.getLeft(), target);
        }
        if (target > root.getData()) {
            pre = root.getData();
            findPreSuc(root.getRight(), target);
        }
    }

    private static void findPre(BinaryTree left) {
        pre = left.getData();
        BinaryTree temp = left;
        while (temp != null) {
            pre = temp.getData();
            temp = temp.getRight();
        }
    }

    private static void findSuc(BinaryTree right) {
        suc = right.getData();
        BinaryTree temp = right;
        while (temp != null) {
            suc = temp.getData();
            temp = temp.getLeft();
        }
    }
}
