package codingminutes.binarytree;

import BT.BinaryTreeUseKt;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBuild {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, -1, 6, -1, -1, 7, -1, -1, -1, -1, -1};
        BT.BinaryTree root = getLevelOrderTree(input);
        BinaryTreeUseKt.levelWisePrint(root);
        System.out.println("----------");
        printAtLevelK(root, 2);
    }

    private static BT.BinaryTree getLevelOrderTree(int[] input) {
        int length = input.length;
        Queue<BT.BinaryTree> queue = new LinkedList<>();

        if (length < 1) {
            return null;
        }

        BT.BinaryTree root = new BT.BinaryTree(input[0]);
        queue.add(root);
        int index = 1;

        while (index < length && !queue.isEmpty()) {
            BT.BinaryTree node = queue.poll();

            if (input[index] != -1) {
                BT.BinaryTree left_ = new BT.BinaryTree(input[index]);
                node.setLeft(left_);
                queue.add(left_);
            }
            index++;

            if (input[index] != -1) {
                BT.BinaryTree right_ = new BT.BinaryTree(input[index]);
                node.setRight(right_);
                queue.add(right_);
            }
            index++;
        }
        return root;
    }

    private static void printAtLevelK(BT.BinaryTree root, int k) {
        if (root == null) {
            return;
        }
        if (k == 0) {
            System.out.println(root.getData());
        }
        printAtLevelK(root.getLeft(), k -1);
        printAtLevelK(root.getRight(), k -1);
    }
}
