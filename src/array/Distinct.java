package array;

import java.util.LinkedHashMap;
import java.util.Map;

public class Distinct {

    private static LinkedHashMap<Integer, Integer> oddMap = new LinkedHashMap<>();
    private static LinkedHashMap<Integer, Integer> evenMap = new LinkedHashMap<>();
    private static int oddCount = 0;
    private static int evenCount = 0;

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1,1};
        addToMap(arr, 6);
        print();
    }

    private static void addToMap(int[] a, int size){
        for(int i = 0; i < size; i++){
            if(((i+1) % 2) != 0){
                if(!oddMap.containsKey(a[i])){
                    oddMap.put(a[i], 1);
                }
                else{
                    int val = oddMap.get(a[i]);
                    oddMap.put(a[i], val+1);
                }
            }
            else{
                if(!evenMap.containsKey(a[i])){
                    evenMap.put(a[i], 1);
                }
                else{
                    int val = evenMap.get(a[i]);
                    evenMap.put(a[i], val+1);
                }
            }
        }
    }

    private static void print(){
        for(Map.Entry<Integer,Integer> map : oddMap.entrySet()){
            int value = map.getValue();
            if(value == 1){
                oddCount++;
            }
        }
        for(Map.Entry<Integer,Integer> map : evenMap.entrySet()){
            int value = map.getValue();
            if(value == 1){
                evenCount++;
            }
        }
        System.out.print(oddCount+" "+evenCount);
    }
}
