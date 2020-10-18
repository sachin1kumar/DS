package string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinSumOfSquares {
    public static void main(String[] args) {
        String str = "abccc";
        int k = 1;
        HashMap<Character, Integer> map = initFrequency(str);
        calculateHighestFreqChar(map, k);
    }

    private static void calculateHighestFreqChar(HashMap<Character, Integer> map, int k) {
        char ch = ' ';
        int freq = 0;
        // Getting an iterator
        Iterator hmIterator = map.entrySet().iterator();

        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator.next();
            char character = (char) mapElement.getKey();
            int frequency = (int) mapElement.getValue();
            if (frequency >= freq) {
                freq = frequency;
                ch = character;
            }
        }
        System.out.println("Key: "+ ch+" "+"Val: "+freq);

        while (k != 0) {
            map.put(ch, map.get(ch) - 1);
            k--;
        }

        int sum = 0;
        Iterator hmIterator2 = map.entrySet().iterator();
        //Print output...
        while (hmIterator2.hasNext()) {
            Map.Entry mapElement = (Map.Entry)hmIterator2.next();
            int frequency = (int) mapElement.getValue();
            sum = sum + (frequency * frequency);
        }

        System.out.println(sum);
    }

    private static HashMap<Character, Integer> initFrequency(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        return map;
    }
}
