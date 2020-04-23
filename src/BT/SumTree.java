package BT;

import java.util.ArrayList;

public class SumTree {

    public static ArrayList<Integer> list = null;


    public static void main(String[] args) {

        System.out.println(sumTree(BinaryTreeUseKt.takeInputLevelwise()));

    }

    public static ArrayList<Integer> sumTree(BinaryTreeJava root){
        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, they are passed as function arguments.
         * Return output and don't print it.
         * Taking input and printing output is handled automatically.
         */

        BinaryTreeJava nroot = update(root);
        list = new ArrayList<Integer>();
        return travel(nroot);
    }

    public static ArrayList<Integer> travel(BinaryTreeJava root){
        if(root == null){
            return list;
        }

        if(root != null){
            list.add(root.data);
            travel(root.left);
            travel(root.right);
        }

        return list;
    }


    public static BinaryTreeJava update(BinaryTreeJava root) {

        if(root == null){
            return null;
        }

        if(root.left == null && root.right != null){
            root.data = root.right.data;
        }

        if(root.right == null && root.left != null){
            root.data = root.left.data;
        }

        if(root.left == null && root.right == null){
            root.data = 0;
        }

        if (root.left != null && root.right!=null) {
            root.data = root.left.data + root.right.data;
        }

        update(root.left);
        update(root.right);

        return root;

    }
}
