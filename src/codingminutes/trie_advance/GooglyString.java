package codingminutes.trie_advance;

public class GooglyString {

    private static final TrieNode root = new TrieNode('\0');

    public static void main(String[] args) {
        final String[] words = {"goo", "gle", "google", "le", "googly", "ly", "g", "googoole"};
        createTrie(words);
        search(words);
    }

    private static void createTrie(String[] words) {
        TrieNode curr = root;
        for (int index = 0; index < words.length; index++) {
            String input = words[index];
            for (int j = 0; j < input.length(); j++) {
                char ch = input.charAt(j);
                if (!curr.map.containsKey(ch)) {
                    curr.map.put(ch, new TrieNode(ch));
                }
                curr = curr.map.get(ch);
            }
            curr.isTerminated = true;
            curr = root;
        }
    }

    private static void search(String[] words) {
        for (int index = 0; index < words.length; index++) {
            getNode(words[index]);
        }
    }

    private static void getNode(String word) {
        TrieNode curr = root;
        int terminatedCount = 0;
        final StringBuilder output = new StringBuilder();
        for (int index = 0; index < word.length(); index++) {
            char ch = word.charAt(index);
            output.append(ch);
            curr = curr.map.get(ch);
            if (curr.isTerminated) {
                terminatedCount++;
            }
        }
        if (terminatedCount >= 2 && curr.map.size() == 0) {
            System.out.println(output);
        }
    }
}
