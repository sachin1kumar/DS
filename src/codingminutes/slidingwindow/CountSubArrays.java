package codingminutes.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class CountSubArrays {

    public static void main(String[] args) {
        final int[] input = {10, 2, -2, -20, 10};
        System.out.println(getSubArrayCount(input, -10));
    }

    /*
    * Space and time complexity - O(N)
    * */
    private static int getSubArrayCount(int[] input, int k) {
      final Set<Integer> set = createSet(input);
      int count = 0;
      for (int index = 0; index < input.length; index++) {
          if (set.contains(k-input[index])) {
              count++;
          }
      }
      return count;
    }

    private static Set<Integer> createSet(int[] input) {
        final Set<Integer> set = new HashSet<>();
        for (int index = 0; index < input.length; index++) {
            set.add(input[index]);
        }
        return set;
    }
}
