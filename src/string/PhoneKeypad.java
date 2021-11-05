package string;

import java.util.ArrayList;
import java.util.List;

public class PhoneKeypad {
    public static void main(String[] args) {
        final List<String> output = new ArrayList<>();
        final List<String> arrayList = generateCombination(output, "23", "", 0, charMap());
        arrayList.stream().forEach(System.out::println);
    }

    private static List<String> generateCombination(List<String> output, String digits, String current, int index,
                                                    String[] mapping) {
        if (index == digits.length()) {
            output.add(current);
            return output;
        }

        String letters = mapping[Character.getNumericValue(digits.charAt(index))];
        for (int i = 0; i < letters.length(); i++) {
            generateCombination(output, digits, current + letters.charAt(i), index + 1, mapping);
        }
        return output;
    }

    private static String[] charMap() {
        return new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }
}
