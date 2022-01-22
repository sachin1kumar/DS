package codingminutes.trie_advance;

import java.util.HashMap;
import java.util.Map;

public class CuteLittleCatProblem {

    private static final TrieNode root = new TrieNode('\0');
    private static final Map<String, Boolean> outputMap = new HashMap<>();

    public static void main(String[] args) {
        final String document = "little cute cat loves to code in c++, java & python";
        final String[] words = {"cute cat", "ttl", "cat", "quick", "big"};
        //output: true, true, true, false, false
        createTrie(words);
        iterateDocument(document);
        printOutput(words);
    }

    /*
     * Steps:
     * 1. Create trie for words array.
     * 2. Iterate document and search for the word in the trie using search helper and create outputMap which contains
     * whether the match words are present in trie or not.
     * 3. Iterate words array and check whether the word contains in outputMap or not, if contain then print word and true.
     * */

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

    private static void iterateDocument(String document) {
        for (int index = 0; index < document.length(); index++) {
            searchHelper(document, index);
        }
    }

    private static void searchHelper(String document, int index) {
        TrieNode current = root;
        for (int j = index; j < document.length(); j++) {
            char ch = document.charAt(j);
            if (!current.map.containsKey(ch)) {
                return;
            }
            current = current.map.get(ch);
            if (current.isTerminated) {
                String output = document.substring(index, j + 1); //important for taking string out like ttl
                outputMap.put(output, true);
            }
        }
    }

    private static void printOutput(String[] words) {
        for (int index = 0; index < words.length; index++) {
            if (outputMap.containsKey(words[index])) {
                System.out.println(words[index] + ":" + true);
            } else {
                System.out.println(words[index] + ":" + false);
            }
        }
    }

}
