package BT;

import java.util.*;

public class DiagonalAnagram {

    private static LinkedHashMap<Integer, ArrayList<Integer>> map1 = new LinkedHashMap<>();
    private static LinkedHashMap<Integer, ArrayList<Integer>> map2 = new LinkedHashMap<>();


    public static void main(String[] args) {
        BinaryTree root1 = BinaryTreeUseKt.takeInputLevelwise();
        BinaryTree root2 = BinaryTreeUseKt.takeInputLevelwise();

        System.out.println(arediagonalanagrams(root1,root2));

    }

    static boolean arediagonalanagrams(BinaryTree root1,BinaryTree root2){
        addMapOne(root1, 0);
        addMapTwo(root2, 0);

        if(map1.size() != map2.size()){
            return false;
        }

        // Get a set of the entries
        Set set = map1.entrySet();

        // Get an iterator
        Iterator i = set.iterator();


        // Display elements
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            if(map2.containsKey(me.getKey())){
                ArrayList<Integer> list1 = (ArrayList<Integer>)me.getValue();
                ArrayList<Integer> list2 = map2.get(me.getKey());
                if(!compareList(list1, list2)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean compareList(ArrayList<Integer> list1, ArrayList<Integer> list2){
        if(list1.size() != list2.size()){
            return false;
        }

        LinkedHashMap<Integer, Integer> map1 = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> map2 = new LinkedHashMap<>();


        for(int i=0; i < list1.size(); i++){
            if(!map1.containsKey(list1.get(i))){
                map1.put(list1.get(i),1);
            }
            else {
                int val = list1.get(i) + 1;
                map1.put(list1.get(i), val);
            }
        }

        for(int i=0; i < list2.size(); i++){
            if(!map2.containsKey(list2.get(i))){
                map2.put(list2.get(i),1);
            }
            else {
                int val = list2.get(i) + 1;
                map2.put(list2.get(i), val);
            }
        }

        // Get a set of the entries
        Set set = map1.entrySet();

        // Get an iterator
        Iterator i = set.iterator();
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            if(!(map2.containsKey(me.getKey()) && map2.get(me.getKey()) == me.getValue())){
                return false;
            }
        }
        return true;
    }

    private static void addMapOne(BinaryTree root, int d){
        if(root == null){
            return;
        }

        if(map1.containsKey(d)){
            ArrayList<Integer> list = map1.get(d);
            list.add(root.getData());
            map1.put(d, list);
        }
        else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.getData());
            map1.put(d, list);
        }

        addMapOne(root.getLeft(), d + 1);
        addMapOne(root.getRight(), d);
    }

    private static void addMapTwo(BinaryTree root, int d){
        if(root == null){
            return;
        }

        if(map2.containsKey(d)){
            ArrayList<Integer> list = map2.get(d);
            list.add(root.getData());
            map2.put(d, list);
        }
        else{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.getData());
            map2.put(d, list);
        }

        addMapTwo(root.getLeft(), d + 1);
        addMapTwo(root.getRight(), d);
    }
    
}
