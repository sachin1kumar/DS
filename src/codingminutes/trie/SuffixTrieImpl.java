package codingminutes.trie;

public class SuffixTrieImpl {

    private static TrieNode root = new TrieNode('\0');

    public static void main(String[] args) {
        insert("hello");
        System.out.println(search("lo"));
        System.out.println(search("ell"));
        System.out.println(search("hello"));
    }

    private static void insert(String word) {
        TrieNode curr = root;
        for (int index = 0; index < word.length(); index++) {
            for (int j = index; j < word.length(); j++) {
                char ch = word.charAt(j);
                System.out.print(ch);
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode(ch);
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isTerminated = true;
            curr = root;
            System.out.println();
        }
    }

    private static boolean search(String word) {
        TrieNode node = getNode(word);
        return node != null && node.isTerminated;
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
