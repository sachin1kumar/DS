package BT;

import java.util.LinkedList;
import java.util.Queue;

public class LeftView {

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        printLeftView(root);
    }

    private static void printLeftView(BinaryTree root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                BinaryTree node = queue.poll();
                if (index == 0) {
                    System.out.print(node.getData()+" ");
                }
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
        }
    }
}
