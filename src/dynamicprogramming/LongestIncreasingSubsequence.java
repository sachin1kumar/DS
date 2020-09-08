package dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;

public class LongestIncreasingSubsequence {

    private static int[] arr = {0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15};
    private static int[] len = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    private static int[] sub = {-1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {

        System.out.println(longestLengthSubSequence());
        //printLongestIncSequence();

    }

    private static int longestLengthSubSequence() {
        int j = 0;
        int i = 1;

        while (i < arr.length) {
            while (j < i) {
                if (arr[j] <= arr[i]) {
                    int length = len[j] + 1;
                    int ans = Math.max(length, len[i]);
                    len[i] = ans;
                    sub[i] = j;
                }
                j++;
            }
            i++;
            j = 0;
        }
        return len[len.length - 1];
    }

    private static void printLongestIncSequence() {
        int lenLastIndex = len.length - 1;
        // create arraylist to hold index

        ArrayList<Integer> list = new ArrayList<>();
        list.add(lenLastIndex);

        for (int k = 0; k < sub.length; k++) {
            System.out.print(sub[k]+" ");
        }
        System.out.println();

        int i = sub[lenLastIndex];
        list.add(i);

        while (i != -1) {
            i = sub[i];
            list.add(i);
        }

        //reverse the list
        Collections.reverse(list);

        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) == - 1){
                continue;
            }
            System.out.print(arr[list.get(j)]+ " ");
        }
    }

}
