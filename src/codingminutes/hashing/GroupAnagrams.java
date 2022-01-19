package codingminutes.hashing;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        final List<String> input = List.of("eat", "tea", "tan", "ate", "nat", "bat");
        System.out.println(groupAnagrams(input));
    }

    /*
    * Space Complexity - O(N)
    * Time Complexity - O(N)
    * */
    private static List<List<String>> groupAnagrams(List<String> input) {
        final Map<String, List<String>> map = new HashMap<>();
        final List<List<String>> output = new ArrayList<>();
        for (int index = 0; index < input.size(); index++) {
            String value = input.get(index);
            String hash = generateHash(value);
            List<String> list = null;
            if (map.containsKey(hash)) {
                list = map.get(hash);
            } else {
                list = new ArrayList<>();
            }
            list.add(value);
            map.put(hash, list);
        }
        //iterate hashmap.
        for (Map.Entry<String, List<String>> iterate: map.entrySet()) {
            output.add(iterate.getValue());
        }
        return output;
    }

    private static String generateHash(String string) {
        int[] freq = new int[27];
        for (int index = 0; index < string.length(); index++) {
            freq[string.charAt(index) - 'a']++;
        }
        return Arrays.toString(freq);
    }
}
