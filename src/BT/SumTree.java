package BT;

import java.util.ArrayList;

public class SumTree {

    public static ArrayList<Integer> list = null;


    public static void main(String[] args) {

        System.out.println(sumTree(BinaryTreeUseKt.takeInputLevelwise()));

    }

    public static ArrayList<Integer> sumTree(BinaryTree root){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, they are passed as function arguments.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        BinaryTree nroot = update(root);
        list = new ArrayList<Integer>();
        return travel(nroot);
    }

    public static ArrayList<Integer> travel(BinaryTree root){
        if(root == null){
            return list;
        }

        if(root != null){
            list.add(root.getData());
            travel(root.getLeft());
            travel(root.getRight());
        }

        return list;
    }


    public static BinaryTree update(BinaryTree root) {

        if(root == null){
            return null;
        }

        if(root.getLeft() == null && root.getRight() != null){
            root.setData(root.getRight().getData());
        }

        if(root.getLeft() == null && root.getLeft() != null){
            root.setData(root.getLeft().getData());
        }

        if(root.getLeft() == null && root.getRight() == null){
            root.setData(0);
        }

        if (root.getLeft() != null && root.getRight()!=null) {
            root.setData(root.getLeft().getData() + root.getRight().getData());
        }

        update(root.getLeft());
        update(root.getRight());

        return root;

    }
}
