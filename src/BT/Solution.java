package BT;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {

    public static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {

        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();

        left(root);
        leaves(root);
        right(root.getRight());
        printRight(list);
    }


    public static void left(BinaryTree root){
        if(root == null){
            return;
        }

        if(root.getLeft() == null && root.getRight() == null){
            return;
        }

        //if(root.getLeft() != null || root.getRight() != null){
            System.out.print(root.getData()+" ");
        //}

        if(root.getLeft() != null){
            left(root.getLeft());
        }

        else if(root.getRight() != null){
            left(root.getRight());
        }
    }

    public static void right(BinaryTree root){
        if(root == null){
            return;
        }

        if(root.getLeft() == null && root.getRight() == null){
            return;
        }

        //if(root.getLeft() != null || root.getRight() != null){
            list.add(root.getData());
            //System.out.print(root.data+" ");
        //}

        if(root.getRight() != null){
            right(root.getRight());
        }

        else if(root.getLeft() != null){
            right(root.getLeft());
        }
    }

    public static void printRight(ArrayList<Integer> list){
        Collections.reverse(list);

        for(Integer element : list){
            System.out.print(element+" ");
        }
    }

    public static void leaves(BinaryTree root){
        if(root == null){
            return;
        }

        if(root.getLeft() == null && root.getRight() == null){
            System.out.print(root.getData()+" ");
        }

        leaves(root.getLeft());
        leaves(root.getRight());
    }
}
