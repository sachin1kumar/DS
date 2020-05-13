package BT;

import java.util.ArrayList;

public class Ancestor {

    private static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        System.out.println(ancestors(root,root,6));

    }

    private static ArrayList<Integer> ancestors(BinaryTree root, BinaryTree lnode, int k){

        if(root == null){
            System.out.println("root == null");
            return null;
        }

        if (k == root.getData()){
            System.out.println("k:"+k+" arrayList:"+arrayList.toString());
            return arrayList;
        }

        if((lnode != null && lnode.getLeft() != null &&
           lnode.getLeft().getData() == root.getData()) ||
                (lnode != null && lnode.getRight() != null &&
                        lnode.getRight().getData() == root.getData())){
            arrayList.add(lnode.getData());
            System.out.println("arrayList:"+arrayList.toString()+"& lnode.getData:"+lnode.getData());
        }

        lnode = root;
        System.out.println("lnode:"+lnode);

        if (root.getLeft()!= null)
            System.out.println("lnode:getLeft:"+root.getLeft().getData());

        if (root.getRight()!= null)
            System.out.println("lnode:getRight:"+root.getRight().getData());

        ancestors(root.getLeft(),lnode,k);
        ancestors(root.getRight(),lnode,k);
        return arrayList;
    }
}
