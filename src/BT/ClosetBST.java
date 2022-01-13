package BT;

public class ClosetBST {

    private static int diff = Integer.MAX_VALUE;
    private static int result = -1;

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        System.out.println(getCloset(root, 16));
    }

    private static int getCloset(BinaryTree root, int target) {
        if (root == null) {
            return result;
        }

        int curr_diff = Math.abs(target - root.getData());

        if (curr_diff == 0) {
            return root.getData();
        }

        if (curr_diff < diff) {
            diff = curr_diff;
            result = root.getData();
        }

        if (target < root.getData()) {
            getCloset(root.getLeft(), target);
        } else {
            getCloset(root.getRight(), target);
        }
        return result;
    }

}
