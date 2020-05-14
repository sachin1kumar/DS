package BT;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MaxIncPath {

    private static LinkedHashMap<Integer, ArrayList<Integer>> map = new LinkedHashMap<>();
    private static ArrayList<Integer> arrayList = new ArrayList<>();
    private static int sum = 0;
    private static boolean isleaf;


    public static void main(String[] args) {
        BinaryTree root = BinaryTreeUseKt.takeInputLevelwise();
        //intializeHashMap(root,sum,map,arrayList);
        //printMap(map);
        findInorder(root);
        boolean lef = isLeaf(root,4);
        System.out.println(arrayList.toString()+":"+lef);
    }

    private static void intializeHashMap(BinaryTree root, int sum, LinkedHashMap<Integer,ArrayList<Integer>> map, ArrayList<Integer> arrayList) {
        if(root == null){
            map.put(sum,arrayList);
            System.out.println("MapKey:"+sum+"MapVal:"+map.get(sum));
            return;
        }

        sum = sum + root.getData();
        arrayList.add(root.getData());
        System.out.println(arrayList.toString());

        intializeHashMap(root.getLeft(),sum,map,arrayList);
        intializeHashMap(root.getRight(),sum,map,arrayList);
    }

    private static void printMap(LinkedHashMap<Integer, ArrayList<Integer>> map) {
        for (Map.Entry<Integer,ArrayList<Integer>> lMap : map.entrySet()){
            int key = lMap.getKey();
            ArrayList<Integer> list = lMap.getValue();
            System.out.println(key+":"+list.toString());
        }
    }

    private static void findInorder(BinaryTree root){
        if(root == null){
            return;
        }
        findInorder(root.getLeft());
        arrayList.add(root.getData());
        findInorder(root.getRight());
    }

    private static boolean isLeaf(BinaryTree root, int k){
        if(root==null){
            return isleaf;
        }

        int rootData = root.getData();
        if(rootData == k && root.getLeft() == null && root.getRight() == null) {
            isleaf = true;
            return isleaf;
        }
        isLeaf(root.getLeft(),k);
        isLeaf(root.getRight(),k);
        return isleaf;
    }
}