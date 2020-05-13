package BT;

import java.util.ArrayList;

public class MaximumSumPath {

    private static int lsum = 0;
    private static int rsum = 0;

    private static int lleaf = 0;
    private static int rleaf = 0;


    private static int lsubsum = 0;
    private static int rsubsum = 0;

    private static ArrayList<Integer> list = new ArrayList<>();
    private static ArrayList<Integer> lpath = new ArrayList<>();
    private static ArrayList<Integer> rpath = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        getLeftSum(root);
        getRightSum(root);
        findleftAndrightsum();
        getLeafandAdd(root);
        ArrayList<Integer> list = updateList();

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }

    private static int getLeftSum(BinaryTree root){
        if(root == null){
            return lsum;
        }
        if(root.getLeft() == null && root.getRight() == null){
            lleaf = root.getData();
        }
        lsum = lsum + root.getData();
        if (lleaf == 0) {
            lpath.add(root.getData());
        }
        getLeftSum(root.getLeft());
        return lsum;
    }

    private static int getRightSum(BinaryTree root){
        if(root == null){
            return rsum;
        }
        if(root.getLeft() == null && root.getRight() == null){
            rleaf = root.getData();
        }
        rsum = rsum + root.getData();
        if(rleaf == 0) {
            rpath.add(root.getData());
        }
        getRightSum(root.getRight());
        return rsum;
    }

    private static void findleftAndrightsum(){
        lsubsum = lsum - lleaf;
        rsubsum = rsum - rleaf;
    }

    private static void getLeafandAdd(BinaryTree root){
        if(root == null){
            return;
        }
        if(root.getLeft() == null && root.getRight() == null){
            list.add(root.getData());
        }
        getLeafandAdd(root.getLeft());
        getLeafandAdd(root.getRight());
    }

    private static ArrayList<Integer> updateList(){
        int size = list.size();
        int max1 = list.get(0);
        int max2 = list.get(list.size()/2);
        int lmaxchild = 0,rmaxchild = 0;


        for(int i = 0; i < size/2 ; i++){
            int lchild = list.get(i);
            int updatedElement = lchild + lsubsum;
            if(updatedElement > max1){
                max1 = updatedElement;
                lmaxchild = lchild;
            }
        }

        for(int i = size/2; i < list.size() ; i++){
            int rchild = list.get(i);
            int updatedElement = rchild + rsubsum;
            if(updatedElement > max2){
                max2 = updatedElement;
                rmaxchild = rchild;
            }
        }

        //update list according
        if(lmaxchild > rmaxchild){
            lpath.add(lmaxchild);
            return lpath;
        }else{
            rpath.add(rmaxchild);
        }
        return rpath;
    }
}
