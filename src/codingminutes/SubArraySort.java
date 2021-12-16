package codingminutes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArraySort {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 8, 6, 7, 9, 10, 11};
        System.out.println(getIndexes(input));
        System.out.println(getIndexesOptimize(input));
    }

    /*
    * Space complexity - O(N)
    * Time complexity - O(NlogN)
    * */
    private static List<Integer> getIndexes(int[] input) {
        int length = input.length;
        final List<Integer> output = new ArrayList<>();
        int[] original = input.clone();

        //Sort the array.
        Arrays.sort(input);

        int i = 0;
        int j = length - 1;

        while (i < length && original[i] == input[i]) {
            i++;
        }

        while (j >= 0 && original[j] == input[j]) {
            j--;
        }

        if (i == length) {
            output.add(-1);
            output.add(-1);
        } else {
            output.add(i);
            output.add(j);
        }
        return output;
    }

    /*
     * Space complexity - O(N)
     * Time complexity - O(N)
     * */
    private static List<Integer> getIndexesOptimize(int[] input) {
        int length = input.length;
        final List<Integer> output = new ArrayList<>();

        int firstIndex = -1;
        int secondIndex = -1;
        boolean isFirstUpdated = false;

        for (int index = 1; index < length; index++) {
            if (input[index] < input[index - 1]) {
                if (!isFirstUpdated) {
                    firstIndex = index - 1;
                    isFirstUpdated = true;
                }
                secondIndex = index;
                //swap
                int temp = input[index];
                input[index] = input[index - 1];
                input[index - 1] = temp;
            }
        }
        output.add(firstIndex);
        output.add(secondIndex);
        return output;
    }
}
