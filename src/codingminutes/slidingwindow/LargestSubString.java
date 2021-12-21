package codingminutes.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LargestSubString {

    public static void main(String[] args) {
        //final String input = "abcaeba";
        //final String input = "prateekbhaiya";
        final String input = "aabcb";
        System.out.println(getMaxSubString(input));
    }

    /*
     * Using sliding window approach.
     * Time Complexity - O(N)
     * Space Complexity - O(N)
     * */
    private static String getMaxSubString(String input) {
        final int length = input.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            return input;
        }
        final Set<Character> set = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int j = 0;
        int firstSubStringIndex = 0;
        int secondSubStStringIndex = 0;
        int maxLength = Integer.MIN_VALUE;
        while (i < length && j < length) {
            char ch = input.charAt(j);
            if (!set.contains(ch)) {
                set.add(ch);
                stringBuilder.append(ch);
                j++;
                int builderLength = stringBuilder.length();
                if (maxLength < builderLength) {
                    maxLength = builderLength;
                    firstSubStringIndex = i;
                    secondSubStStringIndex = j;
                }
            } else {
                i++;
                j = i;
                set.clear();
                stringBuilder = new StringBuilder();
            }
        }
        return input.substring(firstSubStringIndex, secondSubStStringIndex);
    }
}
