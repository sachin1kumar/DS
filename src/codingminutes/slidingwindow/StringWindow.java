package codingminutes.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class StringWindow {

    public static void main(String[] args) {
        //System.out.println(getSmallestWindow("hello_world", "lol")); //llo
        // i and j at 0
        // h
        // he
        // hel
        // hell
        // hello yes
        // ello yes
        // llo yes -> smallest
        // lo
        // lo_
        // lo_w
        // lo_wo
        // lo_wor
        // lo_worl yes
        // o_world
        // _world
        // world
        // orld
        // rld
        // ld
        //System.out.println(getSmallestWindow("helloe", "oel")); //loe
        // h
        // he
        // hel
        // hell
        // hello yes
        // ello yes
        // llo
        // lo
        // loe yes -> smallest
        // oe
        //System.out.println(getSmallestWindow("fizzbuzz", "fuzz")); // fizzbu
        // f
        // fi
        // fiz
        // fizz
        // fizzb
        // fizzbu yes
        // izzbu
        // zzbu
        // zbu
        // bu
        // buz
        // buzz
        // uzz
        // zz
        System.out.println(getSmallestWindow("hello", "elo")); //ello
    }

    private static String getSmallestWindow(String bigString, String smallString) {
        int bigStringLength = bigString.length();
        //Map for maintaining smallString Char count.
        Map<Character, Integer> smallMap = createMap(smallString);
        Map<Character, Integer> resultMap = new HashMap<>();
        //Apply sliding window approach on big String.
        int i = 0;
        int j = 0;
        int firstSubStringIndex = 0;
        int secondSubStringIndex = 0;
        int minLength = Integer.MAX_VALUE;

        while (j < bigStringLength && i <=  j) {
            char ch = bigString.charAt(j);
            if (!resultMap.containsKey(ch)) {
                resultMap.put(ch, 1);
            } else {
                resultMap.put(ch, resultMap.get(ch) + 1);
            }

            while (validateMaps(resultMap, smallMap)) {
                System.out.println("resultMap:"+resultMap);
                System.out.println("smallMap:"+smallMap);
                int diff = j - i;
                if (diff < minLength) {
                    minLength = diff + 1;
                    firstSubStringIndex = i;
                    secondSubStringIndex = j;
                    System.out.println(bigString.substring(firstSubStringIndex, secondSubStringIndex + 1));
                }
                resultMap.put(bigString.charAt(i), resultMap.get(bigString.charAt(i)) - 1);
                i++;
            }
            j++;
        }
        return bigString.substring(firstSubStringIndex, secondSubStringIndex + 1);
    }

    private static boolean validateMaps(Map<Character, Integer> resultMap, Map<Character, Integer> smallMap) {
        //Iterate small map
        for (Map.Entry<Character, Integer> entry: smallMap.entrySet()) {
            char key = entry.getKey();
            if (!resultMap.containsKey(key)) {
                return false;
            } else {
                int count = resultMap.get(key);
                if (count < entry.getValue()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Map<Character, Integer> createMap(String smallString) {
        final Map<Character, Integer> map = new HashMap<>();
        for (int index = 0; index < smallString.length(); index++) {
            char ch = smallString.charAt(index);
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }
        return map;
    }
}
