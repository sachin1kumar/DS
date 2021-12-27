package codingminutes.sortingsearching;

import java.util.ArrayList;
import java.util.List;

public class SortingSubarray {

    public static void main(String[] args) {
        //final int[] input = {0, 2, 4, 7, 10, 11, 7, 12, 13, 14, 16, 19, 29}; // 4 6
        //final int[] input = {0, 2, 4, 5, 10, 11, 7, 12, 13, 14, 16, 19, 29}; // 4 6
        //final int[] input = {0, 2}; // -1 -1
        //final int[] input = {2, 0}; // 0 1
        //final int[] input = {0}; // -1 -1
        final int[] input = {0, 0}; // -1 -1
        System.out.println(getUnsortedArray(input));
    }

    /*
    * Time complexity - O(N)
    * */
    private static List<Integer> getUnsortedArray(int[] input) {
        final List<Integer> list = new ArrayList<>();
        int firstSubIndex  = -1;
        int secondSubIndex = -1;
        list.add(firstSubIndex);
        list.add(secondSubIndex);
        int length  = input.length;
        if (length == 1) {
            return list;
        }
        if (length == 2 && input[1] < input[0]) {
            list.set(0, 0);
            list.set(1, 1);
            return list;
        }
        for (int index = 2; index < input.length; index++) {
            if (input[index] < input[index - 1]) {
                secondSubIndex = index;
                //int smallestDiff = Integer.MAX_VALUE;
                int diff = Integer.MAX_VALUE;
                while (diff > 0) {
                    diff = input[index - 1] - input[secondSubIndex];
                    index--;
                }
                firstSubIndex = index + 1;
                break;
            }
        }
        list.set(0, firstSubIndex);
        list.set(1, secondSubIndex);
        return list;
    }
}
