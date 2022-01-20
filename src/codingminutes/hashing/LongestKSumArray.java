package codingminutes.hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestKSumArray {

    public static void main(String[] args) {
        final int k = 15;
        //Taking positive integers and for them sliding window will work only.
        //final int[] input = {0, 2, 1, 2, 3, 4, 5, 15, 10, 5}; //5
        final int[] input = {0, -2, 1, 2, 3, 4, 5, 15, 10, 5};
        System.out.println(getLongestSubArraySizeHashing(input, input.length, k));
    }

    /*
     * Space complexity - O(1)
     * Time complexity - O(N)
     * */
    private static int getLongestSubArraySize(int[] arr, int length, int k) {
        if (length == 0) {
            return -1;
        }

        int i = 0;
        int j = 0;

        int max = Integer.MIN_VALUE;
        int currentSum = arr[0];

        while (i < length && j < length) {
            while (j < length && currentSum <= k) {
                currentSum += arr[j];
                j++;
            }
            while (currentSum > k) {
                currentSum -= arr[i];
                i++;
            }
            if (currentSum == k) {
                int size = ((j - 1) - i) + 1;
                max = Math.max(max, size);
            }
        }
        return max;
    }

    /*
     * Space complexity - O(N)
     * Time complexity - O(N)
     * */
    private static int getLongestSubArraySizeHashing(int[] arr, int length, int k) {
        if (length == 0) {
            return -1;
        }
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int currentSum = 0;
        int max = Integer.MIN_VALUE;

        for (int index = 0; index < length; index++) {
            currentSum += arr[index];
            if (map.containsKey(currentSum - k)) {
                System.out.println(map.get(currentSum - k) + 1 +":"+ index);
                int size = (index - (map.get(currentSum - k) + 1)) + 1;
                max = Math.max(max, size);
            }
            map.put(currentSum, index);
        }
        return max;
    }
}
