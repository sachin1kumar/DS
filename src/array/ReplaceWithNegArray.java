package array;

import java.util.Arrays;
import java.util.HashSet;

public class ReplaceWithNegArray {

    public static void main(String[] args) {

        int[] input = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        //insert the elements in hashset.
        HashSet<Integer> hashSet = new HashSet<>();

        for (Integer element: input) {
            hashSet.add(element);
        }

        //checkfor element
        for (int index = 0; index < input.length; index++) {
            if (hashSet.contains(index)) {
                input[index] = index;
            } else {
                input[index] = -1;
            }
        }

        Arrays.stream(input).forEach(System.out::println);
    }
}
