package codingminutes.trie_advance;

public class TrieImpl {

    private static final TrieNode root = new TrieNode('\0');

    public static void main(String[] args) {
        insert("char");
        insert("chars");
        insert("car");
        System.out.println(search("car")); //true
        System.out.println(search("case")); //false
        System.out.println(startsWith("cars")); //false
        System.out.println(startsWith("car")); //true
        System.out.println(startsWith("ca")); //true
        System.out.println(startsWith("case")); //false
    }

    private static void insert(String word) {
        TrieNode curr = root;
        for (int index = 0; index < word.length(); index++) {
            char ch = word.charAt(index);
            if (!curr.map.containsKey(ch)) {
                curr.map.put(ch, new TrieNode(ch));
            }
            curr = curr.map.get(ch);
        }
        curr.isTerminated = true;
    }

    private static boolean search(String word) {
        TrieNode node = getNode(word);
        return node != null && node.isTerminated;
    }

    private static boolean startsWith(String prefix) {
        TrieNode node = getNode(prefix);
        return node != null;
    }

    private static TrieNode getNode(String word) {
        TrieNode curr = root;
        for (int index = 0; index < word.length(); index++) {
            char ch = word.charAt(index);
            if (!curr.map.containsKey(ch)) {
                return null;
            }
            curr = curr.map.get(ch);
        }
        return curr;
    }
}
