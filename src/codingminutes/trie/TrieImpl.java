package codingminutes.trie;

public class TrieImpl {

    private static TrieNode root = new TrieNode('\0');

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
            if (curr.children[ch - 'a'] == null) {
                //very important check and this will print null 7 times as per
                //existing input.
                curr.children[ch - 'a'] = new TrieNode(ch);
                System.out.println("null");
            }
            curr = curr.children[ch - 'a'];
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
            if (curr.children[ch - 'a'] == null) {
                return null;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr;
    }
}
