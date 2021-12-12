package codingminutes;

import java.util.*;

import static codingminutes.BinarySearchUtil.getElementIndex;

public class PairSum {

    public static void main(String[] args) {
        final int[] arr = {10, 5, 2, 3, -6, 9, 11};
        System.out.println(getPairSum(arr, 4));
        System.out.println(getPairSumImproved(arr, 4));
    }

    //in O(nlogn) time complexity.
    //in O(1) space complexity.
    private static List<Integer> getPairSum(int[] arr, int sum) {
        final int length = arr.length;
        final List<Integer> list = new ArrayList<>();

        if (length == 0 || length == 1) {
            return list;
        }

        //Sort the Array.
        Arrays.sort(arr);
        int index = getElementIndex(arr, 1, length - 1, sum - arr[0]);

        if (index > 0) {
            list.add(arr[0]);
            list.add(arr[index]);
        }
        return list;
    }

    //in O(n) time complexity.
    //in O(n) space complexity.
    private static List<Integer> getPairSumImproved(int[] arr, int sum) {
        final int length = arr.length;

        final Set<Integer> set = new HashSet<>();
        final List<Integer> list = new ArrayList<>();

        if (length == 0 || length == 1) {
            return list;
        }

        for (int index = 0; index < length; index++) {
            int currentElement = arr[index];
            int element = sum - currentElement;
            if (set.contains(element)) {
                list.add(element);
                list.add(currentElement);
            } else {
                set.add(currentElement);
            }
        }
        return list;
    }
}
