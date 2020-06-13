package BT;

import java.util.ArrayList;

public class LargestNumBT {

    private static ArrayList<Integer> list = new ArrayList<>();
    private static int max = -1;
    private static BinaryTree temp = null;

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        int count = getCount(root);

        for (int i = 0; i < count; i++){
            traverseTree(root);
            list.add(max);
            if (temp != null) {
                temp.setData(-1);
                max = -1;
                temp = null;
            }
        }

        for (int i = 0; i < count; i++){
            traverseMultiTree(root);
            list.add(max);
            if (temp != null) {
                temp.setData(-1);
                max = -1;
                temp = null;
            }
        }

        //print with checking it should not be -1...
        System.out.println(list.toString());
    }

    private static void traverseTree(BinaryTree root) {
        if(root == null){
            return;
        }

        if(root.getData()> max && isSingleDigit(root.getData())){
            max = root.getData();
            temp = root;
        }
        traverseTree(root.getLeft());
        traverseTree(root.getRight());
    }

    private static void traverseMultiTree(BinaryTree root) {
        if(root == null){
            return;
        }

        System.out.println("root:"+root.getData());

        if(root.getData() > max){
            max = root.getData();
            temp = root;
        }
        traverseMultiTree(root.getLeft());
        traverseMultiTree(root.getRight());
    }


    private static boolean isSingleDigit(int num){
        String str = num + "";
        return str.length() == 1;
    }

    private static int getCount(BinaryTree root){
        if(root == null){
            return 0;
        }
        return getCount(root.getLeft()) + getCount(root.getRight()) + 1;
    }
}
