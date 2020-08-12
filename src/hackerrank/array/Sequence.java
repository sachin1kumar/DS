package hackerrank.array;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sequence {

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 1, 2};
        int[] res = permutationEquation(arr);

        for(int i = 0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }

    static int[] permutationEquation(int[] p) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = p.length;

        LinkedHashMap<Integer, Integer> map = initMap(p, n);

        for(int x = 1; x <= n; x++) {
            for(Map.Entry<Integer,Integer> rmap : map.entrySet()) {
                int w = rmap.getKey();
                int q = map.get(w);
                int s = map.get(q);
                if(x == s) {
                    list.add(w);
                    break;
                }
            }
        }

        int[] res = new int[list.size()];

        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }

        return res;
    }

    private static LinkedHashMap<Integer, Integer> initMap(int[] p, int n){
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        int key = 1;
        for(int i = 0; i < n; i++){
            map.put(key, p[i]);
            key++;
        }
        return map;
    }
}
