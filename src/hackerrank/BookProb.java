package hackerrank;

import java.util.ArrayList;
import java.util.TreeMap;

public class BookProb {
    public static void main(String[] args) {
        int p = 4;
        int n = 5;
        TreeMap<Integer, ArrayList<Integer>> map = initMap(n);
        System.out.println(calculateResult(map, p));
    }

    private static TreeMap<Integer, ArrayList<Integer>> initMap(int n) {
        int key  = 1;
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        for(int i = 0; i < n + 1; i = i + 2){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = i; j <= i + 1; j++){
                if(j == 0 || j == n + 1) {
                    list.add(0);
                } else {
                    list.add(j);
                }
            }
            map.put(key, list);
            key++;
        }
        return map;
    }

    private static int reversedMap(TreeMap<Integer, ArrayList<Integer>> map,int p) {
        int bResult = 0;
        ArrayList<Integer> keys = new ArrayList<Integer>(map.keySet());
        for(int i=keys.size(); i>=1;i--){
            System.out.println(i +":"+map.get(keys.get(i-1)));
            ArrayList<Integer> list = map.get(keys.get(i-1));
            if(list.contains(p)){
                break;
            }
            bResult++;
        }
        return bResult;
    }

    private static int calculateResult(TreeMap<Integer, ArrayList<Integer>> map, int p) {
        int fResult = 0;

        for (ArrayList<Integer> in : map.values()){
            if(in.contains(p)){
                break;
            }
            fResult++;
        }
        int bResult = reversedMap(map, p);
        return Math.min(fResult, bResult);
    }
}
