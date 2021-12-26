package codingminutes.string;

import codingminutes.string.comparator.CustomString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SmallestString {

    public static void main(String[] args) {
        //final List<String> input = List.of("a", "ab", "aba"); // aabaab
        final List<String> input = List.of("c", "cb", "cba"); // cbacbc
        List<CustomString> output = getSmallestString(input);
        Collections.sort(output, new CustomString());
        for (int index = 0; index < output.size(); index++) {
            System.out.println(output.get(index).getString());
        }
    }

    private static List<CustomString> getSmallestString(List<String> input) {
        final List<CustomString> list = new ArrayList<>();
        for (int index = 0; index < input.size(); index++) {
            final CustomString customString = new CustomString();
            customString.setString(input.get(index));
            list.add(customString);
        }
        return list;
    }
}
