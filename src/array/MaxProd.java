package array;

import java.util.HashMap;
import java.util.Map;

public class MaxProd {

    private static HashMap<Integer, Integer> hashMap = new HashMap<>();
    private static int[] arr = {2,6,3,4,1};
    private static int n = arr.length;

    public static void main(String[] args) {
        findElements(arr, n);
        getMaxPordAndCount();
    }

    private static void findElements(int[] arr, int n) {
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < (n/2); i = i + 2){

            a = arr[i];
            b = arr[i + 1];

            int updatedN = 0;
            if (n%2!=0){
                updatedN = n-1;
            }
            else{
                updatedN=n;
            }

            for (int j = i + 2; j < updatedN; j = j + 2){
                c = arr[j];
                d = arr[j+1];

                storeInMap(a, b, c, d);
            }
        }

    }

    private static void storeInMap(int a, int b, int c, int d) {

        int prod1 = a * b;
        int prod2 = c * d;

        if (prod1 == prod2){
            if (hashMap.containsKey(prod1)){
                int count = hashMap.get(prod1);
                count++;
                hashMap.put(prod1, count);
            }
            else {
                hashMap.put(prod1, 1);
            }
        }
    }

    private static void  getMaxPordAndCount(){
        int MAX = Integer.MIN_VALUE;
        int prod = 0;
        int count = 0;

        for (Map.Entry<Integer,Integer> lMap : hashMap.entrySet()){
            count = lMap.getValue();

            if(count > MAX){
                MAX = count;
                prod = lMap.getKey();
            }
        }

        System.out.println(prod+" "+count);
    }


}
