package codingminutes.hashing;

import java.util.HashMap;
import java.util.Map;

public class GPTriplets {

    public static void main(String[] args) {
        final int[] arr = {1, 16, 4, 16, 64, 16};
        final Map<Integer, Integer> leftMap = getLeftMap(arr);
        final Map<Integer, Integer> rightMap = getRightMap(arr);
        System.out.println(getNoOfTriplets(arr, leftMap, rightMap, 4));
    }

    /*      Time complexity : O(N)
          a/r, a, ar
          using sliding hashing technique below:
    * */
    private static int getNoOfTriplets(int[] arr, Map<Integer, Integer> leftMap, Map<Integer, Integer> rightMap,
                                       int r) {
        int noOfTriplets = 0;
        for (int index = 0; index < arr.length; index++) {
            //update left and right maps.
            rightMap.put(arr[index], rightMap.get(arr[index]) - 1); // exclude current from right map
            //check for a/r in left and ar in right map.
            if (arr[index] % r ==0) {
                int left = arr[index] / r;
                int right = arr[index] * r;
                if (leftMap.containsKey(left) && rightMap.containsKey(right)) {
                    int leftFreq = leftMap.get(left);
                    int rightFeq = rightMap.get(right);
                    noOfTriplets += (leftFreq * rightFeq);
                }
            }
            leftMap.put(arr[index], leftMap.get(arr[index]) + 1); // include current to left map
        }
        return noOfTriplets;
    }

    private static Map<Integer, Integer> getLeftMap(int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < arr.length; index++) {
            map.put(arr[index], 0);
        }
        return map;
    }

    private static Map<Integer, Integer> getRightMap(int[] arr) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < arr.length; index++) {
            if (map.containsKey(arr[index])) {
                map.put(arr[index], map.get(arr[index]) + 1);
            } else {
                map.put(arr[index], 1);
            }
        }
        return map;
    }
}
