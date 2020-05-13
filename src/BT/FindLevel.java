package BT;

import java.util.HashSet;

public class FindLevel {

    private static HashSet<Integer> hashSet = new HashSet<>();

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        getLevel(root,5,1);
    }

    private static void getLevel(BinaryTree root, int data, int level){
        if(root == null){
            return;
        }
        if (root.getData() == data){
            hashSet.add(level);
        }
        getLevel(root.getLeft(),data,level+1);
        getLevel(root.getRight(),data,level+1);
    }

    private static int getHashSetSize(){
        return hashSet.size();
    }
}
