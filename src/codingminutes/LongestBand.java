package codingminutes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestBand {
    public static void main(String[] args) {
        int[] input = {1, 9, 3, 0, 18, 5, 2, 4, 10, 7, 12, 6};
        System.out.println(getLongestBand(input));
        System.out.println(getLongestBandImproved(input));
    }

    /*
     * Time complexity- O(NlogN)
     * Space complexity - O(1)
     * */
    private static int getLongestBand(int[] input) {
        int length = input.length;

        if (length == 0) {
            return -1;
        }

        if (length == 1) {
            return 1;
        }

        //Sort the array - O(NlogN)
        Arrays.sort(input);

        int longest = 0;
        int count = 1;
        //O(N)
        for (int index = 1; index < length; index++) {
            if (input[index] - input[index - 1] == 1) {
                count++;
                longest = Math.max(longest, count);
            } else {
                count = 1;
            }
        }
        return longest;
    }

    /*
     * Time complexity- O(N)
     * Space complexity - O(N)
     * */
    private static int getLongestBandImproved(int[] input) {
        int length = input.length;

        if (length == 0) {
            return -1;
        }

        if (length == 1) {
            return 1;
        }

        //Store the elements in hashset in O(N).
        final Set<Integer> set = new HashSet<>();
        for (int index = 0; index < length; index++) {
            set.add(input[index]);
        }

        int longest = 0;

        //Iterate input array in O(N).
        for (int index = 0; index < length; index++) {
            if (set.contains(input[index] - 1)) {
                continue;
            } else {
                int nextNum = input[index];
                int count = 1;
                while (set.contains(nextNum+ 1)) {
                    count++;
                    nextNum++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}
