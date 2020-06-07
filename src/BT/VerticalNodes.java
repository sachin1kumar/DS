package BT;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class VerticalNodes {

    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        System.out.println(verticallyBelowNodes(root).toString());
    }

    static ArrayList<Integer> verticallyBelowNodes(BinaryTree Node){
        ArrayList<Integer> nList = null;
        addToList(Node,0);
        if(list.size() == 0){
            new ArrayList<Integer>();
        }
        else{
            nList = new ArrayList<>();
            for (int i = 0; i < list.size()-1; i++){
                nList.add(list.get(i+1));
            }

        }
        return nList;
    }

    private static void addToList(BinaryTree root, int d){
        if(root == null){
            return;
        }

        if(d == 0){
            list.add(root.getData());
        }

        addToList(root.getLeft(), d-1);
        addToList(root.getRight(), d+1);
    }

}
