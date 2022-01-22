package codingminutes.trie_advance;

import java.util.HashMap;
import java.util.Map;

public class PhoneNumberSearch {

    private static final Map<String, Boolean> outputMap = new HashMap<>();
    private static final TrieNode root = new TrieNode('\0');

    public static void main(String[] args) {
        final String phoneNumber = "7728335";
        final String[] words = {"prat", "prateek", "codingminutes", "code", "prat335", "teek"};
        final String[] numberMap = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        createTrie(words);
        searchHelperAndUpdateOutputMap(phoneNumber, numberMap);
        printOutput(words);
    }

    private static void createTrie(String[] words) {
        TrieNode curr = root;
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            for (int j = 0; j < word.length(); j++) {
                char ch = word.charAt(j);
                if (!curr.map.containsKey(ch)) {
                    curr.map.put(ch, new TrieNode(ch));
                }
                curr = curr.map.get(ch);
            }
            curr.isTerminated = true;
            curr = root;
        }
    }

    private static void searchHelperAndUpdateOutputMap(String phoneNumber, String[] numberMap) {
        TrieNode curr = root;
        StringBuilder output = new StringBuilder();

        for (int index = 0; index < phoneNumber.length(); index++) {
            String string = numberMap[Integer.parseInt(phoneNumber.charAt(index) + "")];
            char ch = '\0';
            for (int j = 0; j < string.length(); j++) {
                ch = string.charAt(j);
                if (curr.map.containsKey(ch)) {
                    output.append(ch);
                    curr = curr.map.get(ch);
                    break;
                }
            }
            if (curr.isTerminated) {
                outputMap.put(output.toString(), true);
                output = new StringBuilder("");
                output.append(ch);
            }
        }
    }

    private static void printOutput(String[] words) {
        for (Map.Entry<String, Boolean> entry : outputMap.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
