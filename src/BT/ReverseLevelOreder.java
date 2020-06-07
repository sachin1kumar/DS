package BT;

import java.util.ArrayList;

public class ReverseLevelOreder {

    private static ArrayList<BinaryTree> list = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        ArrayList<BinaryTree> arry = getList(root);

        ArrayList<BinaryTree> reversedArr = reverse(arry);

        for (int i = 0; i < reversedArr.size(); i++){
            System.out.print(reversedArr.get(i).getData()+" ");
        }
    }

    private static ArrayList<BinaryTree> reverse(ArrayList<BinaryTree> array) {
        int i = 0;
        int j = array.size()-1;

        while(i  < j){
            BinaryTree temp = array.get(i);
            array.set(i,array.get(j));
            array.set(j,temp);

            i++;
            j--;
        }

        return array;
    }

    private static ArrayList<BinaryTree> getList(BinaryTree root){
        if(root == null){
            return null;
        }

        int pointer = 0;

        list.add(root);

        while(pointer < list.size()){
            BinaryTree node = list.get(pointer);

            if(node.getLeft() != null){
                list.add(node.getLeft());
            }

            if (node.getRight() != null){
                list.add(node.getRight());
            }

            pointer++;
        }

        return list;
    }
}
