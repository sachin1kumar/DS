package codingminutes.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedPermutation {

    private static final List<String> output = new ArrayList<>();

    public static void main(String[] args) {
        printPermutation(new StringBuilder("acb"), 0);
        Collections.sort(output);
        System.out.println(output);
    }

    private static void printPermutation(StringBuilder input, int index) {
        if (index == input.length()) {
            output.add(input.toString());
            return;
        }

        for (int index_ = index; index_ < input.length(); index_++) {
            swap(input, index, input.charAt(index), index_, input.charAt(index_));
            printPermutation(input, index + 1);
            swap(input, index, input.charAt(index), index_, input.charAt(index_));
        }
    }

    private static void swap(StringBuilder input, int index, char charAt, int index_, char charAt1) {
        input.setCharAt(index, charAt1);
        input.setCharAt(index_, charAt);
    }
}
