package BT;

import java.util.ArrayList;
import java.util.HashMap;

public class LCAOf3Nodes {

    private static HashMap<Integer, Integer> map = new HashMap<>();
    private static ArrayList<Integer> first = new ArrayList<>();
    private static ArrayList<Integer> second = new ArrayList<>();
    private static ArrayList<Integer> third = new ArrayList<>();
    private static boolean isDoneOne;
    private static boolean isDoneTwo;
    private static boolean isDoneThree;



    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();

        addToMap(root, 0);
        traverseFirst(root, 5);
        traverseSecond(root, 6);
        traverseThird(root, 7);

        //getUniqueNodes();

        print();

    }

    private static void print(){
        System.out.println(first.toString());
        System.out.println(second.toString());
        System.out.println(third.toString());
    }

    private static void addToMap(BinaryTree root, int d){
        if(root == null){
            return;
        }

        map.put(root.getData(), d);

        addToMap(root.getLeft(), d + 1);
        addToMap(root.getLeft(), d + 1);
    }

    private static void traverseFirst(BinaryTree root, int data1){
        if(root == null){
            return;
        }

        if(root.getData() == data1){
            isDoneOne = true;
            return;
        }

        if(!isDoneOne) {
            first.add(root.getData());

            traverseFirst(root.getLeft(), data1);
            traverseFirst(root.getRight(), data1);
        }
    }

    private static void traverseSecond(BinaryTree root, int data2){
        if(root == null){
            return;
        }

        if(root.getData() == data2){
            isDoneTwo = true;
            return;
        }

        if(!isDoneTwo){
            second.add(root.getData());

            traverseSecond(root.getLeft(), data2);
            traverseSecond(root.getRight(), data2);
        }
    }

    private static void traverseThird(BinaryTree root, int data3){
        if(root == null){
            return;
        }

        if(root.getData() == data3){
            isDoneThree = true;
            return;
        }

        if (!isDoneThree){
            third.add(root.getData());

            traverseThird(root.getLeft(), data3);
            traverseThird(root.getRight(), data3);
        }
    }
}
