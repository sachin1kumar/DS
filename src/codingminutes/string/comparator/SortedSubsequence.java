package codingminutes.string.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedSubsequence {

    static List<Subsequence> output = new ArrayList<>();

    public static void main(String[] args) {
        subSequence("abcd", 0, "");
        System.out.println("Unordered: " + output);

        //Very important. Here, priority is of length and then of the subsequences.
        Collections.sort(output, new LengthComparator().thenComparing(new SequenceComparator()));
        System.out.println("Ordered: " + output);
    }

    private static void subSequence(String input, int index, String temp) {
        if (index == input.length()) {
            final Subsequence subsequence = new Subsequence(temp, temp.length());
            output.add(subsequence);
            return;
        }

        subSequence(input, index + 1, temp + input.charAt(index));
        subSequence(input, index + 1, temp);
    }
}
