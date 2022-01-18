package codingminutes.hashing;

import java.util.*;

public class AnagramsInSubString {

    private static final Map<String, Integer> hashcodeFreqMap = new HashMap<>();

    public static void main(String[] args) {
        printSubStrings("abba");
        printHashMap();
        System.out.println(getNoOfPairsOfSubString());
    }

    private static void printSubStrings(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                calculateSubStringAndInitMap(input, i, j);
            }
        }
    }

    private static void calculateSubStringAndInitMap(String input, int i, int j) {
        int[] freq = new int[27];
        for (int k = i; k <= j; k++) {
            freq[input.charAt(k) - 'a']++;
            System.out.print(input.charAt(k) + ": ");
        }

        String output = Arrays.toString(Arrays.stream(freq).toArray());
        //Print hashcode array.
        System.out.print(output);

        System.out.println();

        if (hashcodeFreqMap.containsKey(output)) {
            hashcodeFreqMap.put(output, hashcodeFreqMap.get(output) + 1);
        } else {
            hashcodeFreqMap.put(output, 1);
        }
    }

    //PrintHashmap to check frequency.
    private static void printHashMap() {
        for (Map.Entry<String, Integer> map : hashcodeFreqMap.entrySet()) {
            System.out.println("Hashcode: " + map.getKey());
            System.out.println("Count: " + map.getValue());
        }
    }

    private static int getNoOfPairsOfSubString() {
        int ans = 0;
        for (Map.Entry<String, Integer> map : hashcodeFreqMap.entrySet()) {
            int freq = map.getValue();
            ans += freq * (freq - 1) / 2; //formula to find n C 2 -> taking 2 bcoz interested in pairs only.
        }
        return ans;
    }
}
